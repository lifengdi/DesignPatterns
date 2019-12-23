package com.lifengdi.designpatterns.demo.abstractfactory;

/**
 * @author 李锋镝
 * @date Create at 16:17 2019/12/16
 */
public class AbstractFactory2Impl implements AbstractFactory {
    @Override
    public Product1 newProduct1() {
        return () -> System.out.println("AbstractFactory2Impl newProduct1");
    }

    @Override
    public Product2 newProduct2() {
        return () -> System.out.println("AbstractFactory2Impl newProduct2");
    }
}
