package com.liuzx.array;

/**
 * @Author: liuzx
 * @Date: 2019/10/15 16:00
 * @Description: 从排序数组中删除重复项
 **/
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        if (length <= 1) {
            return length;
        }
        int writeInex = 0, readIndex = 1;
        for (; readIndex < length; readIndex++) {
            if (nums[readIndex] == nums[writeInex]) {
                continue;
            }
            nums[++writeInex] = nums[readIndex];
        }
        return writeInex + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = new int[]{1, 1, 2};
        int i = removeDuplicates.removeDuplicates(nums);
        System.out.println(i);
    }
}
