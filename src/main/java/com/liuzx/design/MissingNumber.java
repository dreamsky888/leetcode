package com.liuzx.design;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: liuzx
 * @Date: 2019/10/29 10:01
 * @Description:
 **/
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int total = ((length + 1) * length) / 2;
        for (int num : nums) {
            total -= num;
        }
        return total;
    }

    public int missingNumber2(int[] nums) {
        boolean[] notExist = new boolean[nums.length + 1];
        for (int num : nums) {
            notExist[num] = true;
        }
        for (int i = 0; i < notExist.length; i++) {
            if (!notExist[i]) {
                return i;
            }
        }
        return 0;
    }

    public int missingNumber3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (set.add(i)) {
                return i;
            }
        }
        return 0;
    }

    public int missingNumber4(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }
        for (int i = 1; i <= nums.length; i++) {
            a ^= i;
        }
        return a;
    }
}
