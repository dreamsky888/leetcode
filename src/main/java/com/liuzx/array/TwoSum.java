package com.liuzx.array;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuzx
 * @Date: 2019/10/16 11:34
 * @Description:
 **/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        int[] data = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null && !index.equals(i)) {
                data[0] = i;
                data[1] = index;
                break;
            }
        }
        return data;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] data = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null && !index.equals(i)) {
                data[0] = i;
                data[1] = index;
                break;
            }
            map.put(target - nums[i], i);
        }
        return data;
    }

    public static void main(String[] args) {
        int[] data = new int[]{3, 2, 4};
        TwoSum singleNumber = new TwoSum();
        int[] i = singleNumber.twoSum(data, 6);
        System.out.println(JSON.toJSONString(i));
    }
}
