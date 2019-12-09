package com.liuzx.design;

/**
 * @Author: liuzx
 * @Date: 2019/10/29 10:48
 * @Description:
 **/
public class HammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
           count++;
           n &= (n-1);
        }
        return count;
    }
}
