package com.liuzx.algorithm;

/**
 * @Author: liuzx
 * @Date: 2019/10/22 9:15
 * @Description: 算法导论 4.1 最长连续子数组
 **/
public class MaxSubArray {
    /**
     * 暴力破解法
     * o(n^2)
     *
     * @param array
     * @return
     */
    public Result getMaxSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int leftIndex = 0, rightIndex = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int beginIndex = 0; beginIndex < array.length; beginIndex++) {
            int currValue = 0;
            for (int currIndex = beginIndex; currIndex < array.length; currIndex++) {
                currValue += array[currIndex];
                if (currValue > maxValue) {
                    maxValue = currValue;
                    leftIndex = beginIndex;
                    rightIndex = currIndex;
                }
            }
        }
        Result result = new Result();
        result.left = leftIndex;
        result.right = rightIndex;
        result.max = maxValue;
        return result;
    }

    public class Result {
        public int left;
        public int right;
        public int max;
    }

    /**
     * 分治法（自顶向下），递归实现
     * o(nlogn)
     *
     * @param array
     */
    public Result getMaxSubArray2(int[] array, int left, int right) {
        Result result = new Result();
        if (left == right) {
            result.left = left;
            result.right = right;
            result.max = array[left];
            return result;
        }
        int mid = (left + right) / 2;
        Result leftResult = getMaxSubArray2(array, left, mid);
        Result rightResult = getMaxSubArray2(array, mid + 1, right);
        Result crossResult = getMaxCrossArray(array, mid, left, right);
        if (rightResult.max > leftResult.max) {
            leftResult = rightResult;
        }
        if (crossResult.max > leftResult.max) {
            leftResult = crossResult;
        }
        return leftResult;
    }

    private Result getMaxCrossArray(int[] array, int mid, int left, int right) {
        Result result = new Result();
        int maxLeftValue = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += array[i];
            if (sum > maxLeftValue) {
                maxLeftValue = sum;
                result.left = i;
            }
        }
        sum = 0;
        int maxRightValue = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += array[i];
            if (sum > maxRightValue) {
                maxRightValue = sum;
                result.right = i;
            }
        }
        result.max = maxLeftValue + maxRightValue;
        return result;
    }

    /**
     * 动态规划（DP）
     * o(n)
     *
     * @param array
     * @return
     */
    public Result getMaxSubArray3(int[] array) {
        Result result = new Result();
        result.max = Integer.MIN_VALUE;
        int maxEndI = Integer.MIN_VALUE;
        int leftI = 0;
        for (int i = 0; i < array.length; i++) {
            if (maxEndI < 0) {
                maxEndI = array[i];
                leftI = i;
            } else {
                maxEndI += array[i];
            }
            if (result.max < maxEndI) {
                result.left = leftI;
                result.right = i;
                result.max = maxEndI;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSubArray impl = new MaxSubArray();
        int[] array = new int[]{-1, 4, 2, -10, 5};
        // Result result = impl.getMaxSubArray(array);
        // Result result = impl.getMaxSubArray2(array, 0, array.length - 1);
        Result result = impl.getMaxSubArray3(array);
        System.out.println("left:" + result.left + ",right:" + result.right + ",max:" + result.max);
    }
}
