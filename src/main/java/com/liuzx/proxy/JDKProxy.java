package com.liuzx.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author: liuzx
 * @Date: 2019/10/10 14:41
 * @Description:
 **/
public class JDKProxy {
    public static void main(String[] args) {
        ElectricCar car = new ElectricCar();
        Class carClazz = car.getClass();
        Car carProxy = (Car) Proxy.newProxyInstance(carClazz.getClassLoader(), carClazz.getInterfaces(), (proxy, method, params) -> {
            System.out.println(proxy.getClass().getName());
            method.invoke(car, null);
            return null;
        });
        carProxy.drive();
    }
}
