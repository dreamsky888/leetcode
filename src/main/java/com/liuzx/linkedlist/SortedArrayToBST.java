package com.liuzx.linkedlist;

/**
 * @Author: liuzx
 * @Date: 2019/10/28 14:57
 * @Description: 将有序数组转换为二叉搜索树
 **/
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int beginIndex, int endIndex) {
        if (beginIndex > endIndex) {
            return null;
        }
        int mid = (endIndex + beginIndex) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, beginIndex, mid - 1);
        root.right = helper(nums, mid + 1, endIndex);
        return root;
    }
}
