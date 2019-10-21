package com.liuzx.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: liuzx
 * @Date: 2019/10/16 10:06
 * @Description: 存在重复
 **/
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        return Arrays.stream(nums).anyMatch(num -> !set.add(num));
    }
}
