package com.liuzx.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @Author: liuzx
 * @Date: 2019/10/10 15:02
 * @Description: CGLIB代理
 **/
public class CGLIBProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ElectricCar.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, params, proxy) -> {
            System.out.println("interceptor begin.....");
            proxy.invokeSuper(obj, params);
            System.out.println("interceptor end.....");
            return null;
        });
        ElectricCar electricCar = (ElectricCar) enhancer.create();
        electricCar.drive();
    }
}
