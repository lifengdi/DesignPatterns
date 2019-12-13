package com.lifengdi.designpatterns.demo.factorymethod;

import com.lifengdi.designpatterns.demo.factorymethod.impl.Factory1;
import com.lifengdi.designpatterns.demo.factorymethod.impl.Factory2;

/**
 * 工厂方法（FactoryMethod）模式的定义：
 * 定义一个创建产品对象的工厂接口，将产品对象的实际创建工作推迟到具体子工厂类当中。
 * 这满足创建型模式中所要求的“创建与使用相分离”的特点。
 *
 * 我们把被创建的对象称为“产品”，把创建产品的对象称为“工厂”。
 *
 * 工厂方法模式的主要优点有：
 * 用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程；
 * 在系统增加新的产品时只需要添加具体产品类和对应的具体工厂类，无须对原工厂进行任何修改，满足开闭原则；
 *
 * 其缺点是：
 * 每增加一个产品就要增加一个具体产品类和一个对应的具体工厂类，这增加了系统的复杂度。
 * @author 李锋镝
 * @date Create at 15:46 2019/12/13
 */
public class FactoryTest {

    public static void main(String[] args) {
        AbstractFactory factory = new Factory1();
        factory.get().show();

        AbstractFactory factory2 = new Factory2();
        factory2.get().show();
    }
}
