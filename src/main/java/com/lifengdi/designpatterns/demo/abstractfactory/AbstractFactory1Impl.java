package com.lifengdi.designpatterns.demo.abstractfactory;

/**
 * @author 李锋镝
 * @date Create at 16:17 2019/12/16
 */
public class AbstractFactory1Impl implements AbstractFactory {
    @Override
    public Product1 newProduct1() {
        return () -> System.out.println("AbstractFactory1Impl newProduct1");
    }

    @Override
    public Product2 newProduct2() {
        return () -> System.out.println("AbstractFactory1Impl newProduct2");
    }
}
