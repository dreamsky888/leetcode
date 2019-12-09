package com.liuzx.design;

/**
 * @Author: liuzx
 * @Date: 2019/10/29 10:26
 * @Description:
 **/
public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int value = n & 1;
            if (value == 1) {
                result = result | (1 << (31 - i));
            }
            n = n >>> 1;
        }
        return result;
    }
}
