package com.liuzx.array;

/**
 * @Author: liuzx
 * @Date: 2019/10/16 10:18
 * @Description:
 **/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = new int[]{2, 2, 1};
        SingleNumber singleNumber = new SingleNumber();
        int i = singleNumber.singleNumber(data);
        System.out.println(i);
    }
}
