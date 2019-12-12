package com.lifengdi.designpatterns.demo.singleton;

/**
 * 单例模式-懒汉模式
 * 特点是类加载时没有生成单例，只有当第一次调用 getlnstance 方法时才去创建这个单例
 * 缺点是每次访问时都要同步，会影响性能，且消耗更多的资源
 *
 * @author 李锋镝
 * @date Create at 11:24 2019/12/12
 */
public class LazySingleton {
    //保证 instance 在所有线程中同步
    private static volatile LazySingleton instance = null;

    //private 避免类在外部被实例化
    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        //getInstance 方法前加同步
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
