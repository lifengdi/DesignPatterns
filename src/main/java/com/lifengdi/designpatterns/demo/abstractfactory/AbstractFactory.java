package com.lifengdi.designpatterns.demo.abstractfactory;

/**
 * 抽象工厂
 * 抽象工厂（AbstractFactory）模式的定义：
 * 是一种为访问类提供一个创建一组相关或相互依赖对象的接口，
 * 且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。
 *
 * 抽象工厂模式是工厂方法模式的升级版本，
 * 工厂方法模式只生产一个等级的产品，
 * 而抽象工厂模式可生产多个等级的产品。
 *
 * 抽象工厂模式除了具有工厂方法模式的优点外，其他主要优点如下：
 * 1. 可以在类的内部对产品族中相关联的多等级产品共同管理，而不必专门引入多个新的类来进行管理。
 * 2. 当增加一个新的产品族时不需要修改原代码，满足开闭原则。
 *
 * 其缺点是：当产品族中需要增加一个新的产品时，所有的工厂类都需要进行修改。
 * @author 李锋镝
 * @date Create at 16:14 2019/12/16
 */
public interface AbstractFactory {

    Product1 newProduct1();

    Product2 newProduct2();
}
