package com.hgh.chapter01.rule01;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 用于提供服务者注册API、服务访问API, 不可实例化 （类似JDBC中的Driver）
 * @author: huguanghui
 * @date: 2019-06-03 13:27
 */
public class ServiceManager {
    //服务提供者缓存
    private static final Map<String, IProvider> providerMap = new HashMap<>();
    //默认服务提供者名称
    private static final String DEFAULT_PROVIDER_NAME = "def";

    //私有化构造器
    private ServiceManager() {
    }

    /**
     * 注册服务提供者
     *
     * @param providerName
     * @param provider
     */
    public static void registerProvider(String providerName, IProvider provider) {
        providerMap.put(providerName, provider);
    }

    public static void registerDefaultProvider(IProvider provider) {
        providerMap.put(DEFAULT_PROVIDER_NAME, provider);
    }

    /**
     * 获取服务访问实例
     *
     * @param providerName
     * @return
     */
    public static IService getInstance(String providerName) {
        IProvider provider = providerMap.get(providerName);
        if (provider == null) {
            throw new IllegalArgumentException("未找到相应的服务提供者：" + providerName);
        }
        return provider.newService();
    }

    public static IService getInstance() {
        return getInstance(DEFAULT_PROVIDER_NAME);
    }
}

/*
#   注意：静态工厂方法与设计模式中的工厂方法模式不是一个概念
*   1、静态工厂方法相较于构造器的优点
*       a、静态工厂方法能够自定义名称，使代码可读性更高
*       b、不必在每次调用的时候都创建新的实例
*       c、可以返回类型的子类型对象
*
*   2、静态工厂方法的常用名称：
*       value
*       of
*       getInstance
*       newInstance
*       getType
*       newType
*
*   参见《Effective Java》第一条：考虑使用静态工厂方法代替构造器
* */