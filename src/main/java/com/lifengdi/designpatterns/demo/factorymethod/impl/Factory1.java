package com.lifengdi.designpatterns.demo.factorymethod.impl;

import com.lifengdi.designpatterns.demo.factorymethod.AbstractFactory;
import com.lifengdi.designpatterns.demo.factorymethod.Product;

/**
 * @author 李锋镝
 * @date Create at 15:45 2019/12/13
 */
public class Factory1 implements AbstractFactory {
    @Override
    public Product get() {
        return new Product1();
    }
}
