package com.hgh.chapter01.rule02;

/**
 * @description: 构建器示例， 用户类
 * @author: huguanghui
 * @date: 2019-06-03 13:51
 */
public class User {
    //required attributes
    private String username;
    private String password;

    //attributes which not required
    private int age;
    private long tel;
    private char gender;
    private String addr;

    /**
     * 构造器私有化，提供给构建器调用
     *
     * @param builder
     */
    private User(Builder builder) {
        username = builder.username;
        password = builder.password;
        age = builder.age;
        tel = builder.tel;
        gender = builder.gender;
        addr = builder.addr;
    }

    /**
     * public static class Builder
     * 构建器
     */
    public static class Builder {
        /**
         * 需要有与被构造类完全相同的属性
         */
        private String username;
        private String password;
        private int age;
        private long tel;
        private char gender;
        private String addr;

        /**
         * 提供一个公有的构造方法，用于初始化必填的信息
         *
         * @param username
         * @param password
         */
        public Builder(String username, String password) {
            this.username = username;
            this.password = password;
        }

        /**
         * 提供链式设值方法，用于设置选填信息
         */
        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder tel(long tel) {
            this.tel = tel;
            return this;
        }

        public Builder gender(char gender) {
            this.gender = gender;
            return this;
        }

        public Builder addr(String addr) {
            this.addr = addr;
            return this;
        }

        /**
         * 提供一个构建方法，用于构建目标类
         */
        public User build() {
            return new User(this);
        }
    }

    /**
     * 用于展示User信息
     *
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", tel=" + tel +
                ", gender=" + gender +
                ", addr='" + addr + '\'' +
                '}';
    }
}
