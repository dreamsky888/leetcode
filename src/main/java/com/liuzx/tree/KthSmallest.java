package com.liuzx.tree;

/**
 * @Author: liuzx
 * @Date: 2019/11/26 13:42
 * @Description:
 **/
public class KthSmallest {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Data {
        int sort;
        Integer value;

        Data(int sort, Integer value) {
            this.sort = sort;
            this.value = value;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        Data data = helper(root, k);
        return data.value;
    }

    private Data helper(TreeNode node, int k) {
        if (node == null) {
            return new Data(0, null);
        }
        Data leftPair = helper(node.left, k);
        int leftSize = leftPair.sort;
        if (leftSize == k) {
            return leftPair;
        }
        if (leftSize + 1 == k) {
            return new Data(k, node.val);
        }
        Data rightPair = helper(node.right, k - leftSize - 1);
        if (rightPair.sort + leftSize + 1 == k) {
            return new Data(k, rightPair.value);
        }
        return new Data(leftSize + rightPair.sort + 1, null);
    }

    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        TreeNode node = kthSmallest.new TreeNode(1);
        node.right = kthSmallest.new TreeNode(2);
        int i = kthSmallest.kthSmallest(node, 2);
        System.out.println(i);
    }
}
