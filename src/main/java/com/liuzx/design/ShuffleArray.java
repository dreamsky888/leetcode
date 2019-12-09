package com.liuzx.design;

import java.util.Random;

/**
 * @Author: liuzx
 * @Date: 2019/10/28 16:24
 * @Description:
 **/
public class ShuffleArray {

    static class Solution {
        private int[] nums;
        private int[] randomNums;

        public Solution(int[] nums) {
            this.nums = nums;
            this.randomNums = nums.clone();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            randomNums = nums;
            nums = nums.clone();
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            for (int i = 0; i < randomNums.length; i++) {
                int j = new Random().nextInt(randomNums.length - 1);
                int tmpValue = randomNums[i];
                randomNums[i] = randomNums[j];
                randomNums[j] = tmpValue;
            }
            return randomNums;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution(new int[]{1, 2, 3});
        solution.reset();
        for (int i = 0; i < 20; i++) {
            int[] shuffle = solution.shuffle();
            for (int j = 0; j < shuffle.length; j++) {
                System.out.print(shuffle[j] + ",");
            }
            System.out.println();
        }

    }
}
