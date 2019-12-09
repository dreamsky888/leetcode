package com.liuzx.dp;

/**
 * @Author: liuzx
 * @Date: 2019/10/28 15:52
 * @Description:
 **/
public class Rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int preValue = 0;
        int currValue = 0;
        for (int i = 0; i < length; i++) {
            int tmpValue = currValue;
            int containI = nums[i] + preValue;
            currValue = containI > currValue ? containI : currValue;
            preValue = tmpValue;
        }
        return currValue;
    }
}
