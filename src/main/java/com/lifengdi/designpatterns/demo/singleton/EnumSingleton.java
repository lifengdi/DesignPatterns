package com.lifengdi.designpatterns.demo.singleton;

/**
 * 单例模式-枚举
 * 枚举也是一种特殊的单例模式。可以避免反射、序列化的问题。
 *
 * 反射问题：
 * 懒汉模式和饿汉模式通过私有化构造方法来避免类在外部被实例化，
 * 但是可以通过JAVA的反射机制调用私有构造方法来实例化单例类，所以私有化构造方法并不保险。
 *
 * 序列化问题：
 * 懒汉模式和饿汉模式被序列化前后的对象并不相等（任何一个readObject方法，
 * 不管是显式的还是默认的，它都会返回一个新建的实例，这个新建的实例不同于该类初始化时创建的实例）。
 * 当然这个问题也可以被解决。
 * @author 李锋镝
 * @date Create at 11:36 2019/12/12
 */
public enum EnumSingleton {
    INSTANCE;
    public EnumSingleton getInstance(){
        return INSTANCE;
    }
}
