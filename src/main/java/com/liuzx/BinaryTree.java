package com.liuzx;

import java.util.*;

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

    /**
     * @Author liuzx
     * @Date 2019/8/12 10:21
     * @Description 层次遍历
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.add(root);
        while ( !levelNodes.isEmpty()) {
            int size = levelNodes.size();
            List<Integer> datas = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = levelNodes.poll();
                datas.add(node.val);
                if (node.left != null) {
                    levelNodes.add(node.left);
                }
                if (node.right != null) {
                    levelNodes.add(node.right);
                }
            }
            list.add(datas);
        }
        return list;
    }

    /**
     * @Author liuzx
     * @Date 2019/8/12 10:21
     * @Description 层次遍历
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        DFSHelper(root,0,list);
        return list;
    }

    private void DFSHelper(TreeNode node, int level, List<List<Integer>> list) {
        if(list.size()<(level+1)){
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        if(node.left!=null){
            DFSHelper(node.left,level+1,list);
        }
        if(node.right!=null){
            DFSHelper(node.right,level+1,list);
        }
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
