package com.liuzx.string;

/**
 * @Author: liuzx
 * @Date: 2019/10/17 14:22
 * @Description:
 **/
public class MyAtoi {
    public int myAtoi(String str) {
        int index = 0;
        int length = str.length();
        int positiveFlag = 1;
        while (index < length && str.charAt(index) == ' ') {
            index++;
        }
        if (index < length && str.charAt(index) == '+') {
            index++;
        } else if (index < length && str.charAt(index) == '-') {
            positiveFlag = -1;
            index++;
        }
        int sum = 0;
        int max = Integer.MAX_VALUE / 10;
        int min = -Integer.MIN_VALUE / 10;
        for (; index < length; index++) {
            char c = str.charAt(index);
            if (c < '0' || c > '9') {
                break;
            }
            int value = (c - '0') * positiveFlag;
            if (sum > max || (sum == max && value > 7)) {
                sum = Integer.MAX_VALUE;
                break;
            }
            if (sum < min || (sum == min && value < -8)) {
                sum = Integer.MIN_VALUE;
                break;
            }
            sum = sum * 10 + value;
        }
        return sum;
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        int i = myAtoi.myAtoi("-91283472332");
        System.out.println(i);
    }
}
