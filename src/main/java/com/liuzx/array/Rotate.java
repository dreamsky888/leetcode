package com.liuzx.array;

import com.alibaba.fastjson.JSON;

/**
 * @Author: liuzx
 * @Date: 2019/10/15 16:51
 * @Description: 旋转数组
 **/
public class Rotate {
    public void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            k = k % nums.length;
        }
        if (k == 0) {
            return;
        }
        int last = nums[nums.length - 1];
        for (int index = nums.length - 1; index > 0; index--) {
            nums[index] = nums[index - 1];
        }
        nums[0] = last;
        rotate(nums, k - 1);
    }

    public void rotate2(int[] nums, int k) {
        if (k >= nums.length) {
            k = k % nums.length;
        }
        if (k == 0) {
            return;
        }
        for (int i = 1; i <= k; i++) {
            int last = nums[nums.length - 1];
            for (int index = nums.length - 1; index > 0; index--) {
                nums[index] = nums[index - 1];
            }
            nums[0] = last;
        }
    }

    public void rotate3(int[] nums, int k) {
        if (nums.length == 0 || (k %= nums.length) == 0) {
            return;
        }
        int length = nums.length;
        int start = 0;
        int i = 0;
        int cur = nums[i];
        int cnt = 0;

        while (cnt++ < length) {
            i = (i + k) % length;
            int t = nums[i];
            nums[i] = cur;
            if (i == start) {
                ++start;
                ++i;
                cur = nums[i];
            } else {
                cur = t;
            }
        }
    }

    public void rotate4(int[] nums, int k) {
        int length = nums.length;
        if (length == 0 || (k %= length) == 0) {
            return;
        }
        reverse(nums, 0, length - k - 1);
        reverse(nums, length - k, length - 1);
        reverse(nums, 0, length - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        if (begin == end) {
            return;
        }
        int mid = ((begin + end) >> 1);
        for (int i = begin; i <= mid; i++) {
            int j = begin + end - i;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        rotate.rotate4(nums, 4);
        System.out.println(JSON.toJSONString(nums));
    }
}
