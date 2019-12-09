package com.liuzx.design;

/**
 * @Author: liuzx
 * @Date: 2019/10/29 11:06
 * @Description:
 **/
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <=0 || (n % 2) == 0 || (n % 5) == 0) {
            return false;
        }
        int divide = 3;
        while (n != 1) {
            if (n % divide != 0) {
                return false;
            }
            n = n / divide;
            if (n > divide) {
                divide *= 3;
            } else if (n < divide) {
                divide = 3;
            }

        }
        return true;
    }

    public boolean isPowerOfThree2(int n) {
        if (n < 3 || (n % 2) == 0 || (n % 5) == 0) {
            return false;
        }
        int max = Integer.MAX_VALUE / 3;
        int maxNum = 3;
        while (maxNum <= max) {
            maxNum *= 3;
        }
        if (maxNum % n == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int num = 1;
        while (num < 10000) {
            System.out.println(num + ":" + Integer.toBinaryString(num));
            num *= 3;
        }
    }
}
