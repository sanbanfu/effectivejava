package com.hgh.chapter01.rule01;

/**
 * @description: 服务提供者接口 （类似JDBC中的Driver）
 * @author: huguanghui
 * @date: 2019-06-03 13:27
 */
public interface IProvider {
    IService newService();
}
