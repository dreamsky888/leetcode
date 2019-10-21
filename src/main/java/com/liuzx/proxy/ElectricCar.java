package com.liuzx.proxy;

/**
 * @Author: liuzx
 * @Date: 2019/10/10 14:43
 * @Description:
 **/
public class ElectricCar implements Car {
    @Override
    public void drive() {
        System.out.println(" drive electric car!");
    }
}
