package com.liuzx.array;

import com.alibaba.fastjson.JSON;

/**
 * @Author: liuzx
 * @Date: 2019/10/16 11:06
 * @Description:
 **/
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int writeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                continue;
            }
            if (writeIndex != i) {
                nums[writeIndex] = num;
            }
            writeIndex++;
        }
        for (int i = writeIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        int writeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                continue;
            }
            if (writeIndex != i) {
                nums[writeIndex] = num;
                nums[i] = 0;
            }
            writeIndex++;
        }

    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes.moveZeroes2(nums);
        System.out.println(JSON.toJSONString(nums));
    }

}
