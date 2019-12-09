package com.liuzx.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: liuzx
 * @Date: 2019/11/26 11:23
 * @Description: 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 **/
public class ZigzagLevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        boolean flag = true;
        while (!stack.isEmpty()) {
            Stack<TreeNode> nextStack = new Stack();
            List<Integer> datas = new ArrayList<>(stack.size());
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node == null) {
                    continue;
                }
                datas.add(node.val);
                if (flag) {
                    nextStack.push(node.left);
                    nextStack.push(node.right);
                } else {
                    nextStack.push(node.right);
                    nextStack.push(node.left);
                }
            }
            stack = nextStack;
            flag = !flag;
            if (datas.size() > 0) {
                list.add(datas);
            }
        }
        return list;
    }
}
