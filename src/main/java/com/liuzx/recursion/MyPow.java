package com.liuzx.recursion;

/**
 * @Author: liuzx
 * @Date: 2019/10/14 15:51
 * @Description:
 **/
public class MyPow {
    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        double baseNum = x;
        double result = 1;
        while (N > 0) {
            if ((N & 1) == 1) {
                result = result * baseNum;
            }
            baseNum = baseNum * baseNum;
            N = (N >>> 1);
        }
        return result;
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double v = myPow.myPow(2, 2);
        System.out.println(v);
    }
}
