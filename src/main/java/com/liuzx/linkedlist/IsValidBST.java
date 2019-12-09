package com.liuzx.linkedlist;

/**
 * @Author: liuzx
 * @Date: 2019/10/28 14:33
 * @Description:
 **/
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(null, null, root);
    }

    private boolean helper(Integer minValue, Integer maxValue, TreeNode node) {
        if (node == null) {
            return true;
        }
        if (minValue != null && node.val <= minValue) {
            return false;
        }
        if (maxValue != null && node.val >= maxValue) {
            return false;
        }
        return helper(minValue, node.val, node.left) && helper(node.val, maxValue, node.right);
    }
}
