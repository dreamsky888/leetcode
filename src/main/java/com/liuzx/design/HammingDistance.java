package com.liuzx.design;

/**
 * @Author: liuzx
 * @Date: 2019/10/29 10:38
 * @Description:
 **/
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        x = x ^ y;
        int count = 0;
        while (x != 0) {
            if ((x & 1) == 1) {
                count++;
            }
            x = x >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        HammingDistance distance = new HammingDistance();
        int i = distance.hammingDistance(1, 4);
        System.out.println(i);
    }
}
