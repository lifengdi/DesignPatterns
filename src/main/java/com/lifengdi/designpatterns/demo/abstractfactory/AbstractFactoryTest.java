package com.lifengdi.designpatterns.demo.abstractfactory;

/**
 * @author 李锋镝
 * @date Create at 16:23 2019/12/16
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory abstractFactory1 = new AbstractFactory1Impl();
        abstractFactory1.newProduct1().show();
        abstractFactory1.newProduct2().show();

        AbstractFactory abstractFactory2 = new AbstractFactory2Impl();
        abstractFactory2.newProduct1().show();
        abstractFactory2.newProduct2().show();
    }
}
