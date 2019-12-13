package com.lifengdi.designpatterns.demo.factorymethod.impl;

import com.lifengdi.designpatterns.demo.factorymethod.Product;

/**
 * @author 李锋镝
 * @date Create at 15:44 2019/12/13
 */
public class Product2 implements Product {

    @Override
    public void show() {
        System.out.println("Product2");
    }
}
