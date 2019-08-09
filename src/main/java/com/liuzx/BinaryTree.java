package com.liuzx;

import java.util.ArrayList;
import java.util.LinkedList;
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

    /**
     * @Author liuzx
     * @Date 2019/8/9 17:01
     * @Description 中序排序
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode currNode = stack.pop();
            list.add(currNode.val);
            root = currNode.right;
        }
        return list;
    }

    /**
     * @Author liuzx
     * @Date 2019/8/9 17:01
     * @Description 后续排序
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            list.add(0, currNode.val);
            if (currNode.left != null) {
                stack.push(currNode.left);
            }
            if (currNode.right != null) {
                stack.push(currNode.right);
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
