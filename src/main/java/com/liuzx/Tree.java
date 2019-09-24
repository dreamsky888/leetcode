package com.liuzx;

/**
 * @Author: liuzx
 * @Date: 2019/8/19 14:19
 * @Description:
 **/
public class Tree {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        public Node(int _val) {
            val = _val;
        }
    }

    public Node connect(Node root) {
        Node levelHead = root;
        boolean isLeft = true;
        Node nextLevelHead = null;
        Node pre = null;
        while (levelHead != null || nextLevelHead != null) {
            if (levelHead == null) {
                levelHead = nextLevelHead;
                nextLevelHead = null;
                pre = null;
            }
            Node curr = isLeft ? levelHead.left : levelHead.right;
            if (isLeft) {
                isLeft = false;
            } else {
                isLeft = true;
                levelHead = levelHead.next;
            }
            if (curr == null) {
                continue;
            }
            if (pre != null) {
                pre.next = curr;
            }
            pre = curr;
            if (nextLevelHead == null) {
                nextLevelHead = curr;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        root.left.left = tree.new Node(4);
        root.left.right = tree.new Node(5);
        root.right.left = tree.new Node(6);
        root.right.right = tree.new Node(7);
        Node connect = tree.connect(root);
    }

}
