package com.liuzx.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuzx
 * @Date: 2019/11/14 10:43
 * @Description:
 **/
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            twoSum(nums, i + 1, nums[i], list);
        }
        return list;
    }

    private static void twoSum(int[] nums, int i, int num, List<List<Integer>> list) {

    }
}
