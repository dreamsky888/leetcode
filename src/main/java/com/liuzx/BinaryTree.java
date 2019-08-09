package com.liuzx;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: liuzx
 * @Date: 2019/8/9 15:23
 * @Description:
 **/
public class BinaryTree {
    /**
     * @Author liuzx
     * @Date 2019/8/9 15:29
     * @Description 前序遍历(非递归)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            list.add(currNode.val);
            if (currNode.right != null) {
                stack.push(currNode.right);
            }
            if (currNode.left != null) {
                stack.push(currNode.left);
            }
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
