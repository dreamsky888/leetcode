package com.liuzx.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: liuzx
 * @Date: 2019/10/15 11:03
 * @Description: 不同的二叉搜索树 II
 **/
public class GenerateTrees {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return null;
        }
        return helper(1, n);
    }

    private List<TreeNode> helper(int begin, int end) {
        List<TreeNode> nodes = new ArrayList<>();
        if (begin > end) {
            nodes.add(null);
            return nodes;
        }

        for (int i = begin; i <= end; i++) {
            List<TreeNode> leftList = helper(begin, i - 1);
            List<TreeNode> rightList = helper(i + 1, end);
            final int value = i;
            leftList.forEach(leftNode ->
                    rightList.forEach(rightNode -> {
                        TreeNode node = new TreeNode(value);
                        node.left = leftNode;
                        node.right = rightNode;
                        nodes.add(node);
                    })
            );
        }
        return nodes;
    }

    public static void main(String[] args) {
        GenerateTrees trees = new GenerateTrees();
        List<TreeNode> nodes = trees.generateTrees(3);
        nodes.forEach(root -> {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode currNode = queue.poll();
                if (currNode == null) {
                    System.out.print("null,");
                } else {
                    System.out.print(currNode.val + ",");
                    queue.add(currNode.left);
                    queue.add(currNode.right);
                }
            }
            System.out.println("");
        });
    }
}
