package com.liuzx.SortSearch;

/**
 * @Author: liuzx
 * @Date: 2019/10/28 15:11
 * @Description: 合并两个有序数组
 **/
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            if (j < 0) {
                break;
            }
            if (i < 0) {
                nums1[k] = nums2[j--];
            } else {
                nums1[k] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
            }
        }
    }
}
