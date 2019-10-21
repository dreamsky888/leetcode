package com.liuzx.string;

/**
 * @Author: liuzx
 * @Date: 2019/10/17 9:41
 * @Description:
 **/
public class Reverse {
    public int reverse(int x) {
        int y = 0;
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        while (x != 0) {
            int num = x % 10;
            if (y > max || (y == max && num > 7)) {
                return 0;
            }
            if (y < min || (y == min && num < -8)) {
                return 0;
            }
            y = y * 10 + num;
            x = x / 10;
        }
        return y;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        int num = reverse.reverse(900000);
        System.out.println(num);
    }
}
