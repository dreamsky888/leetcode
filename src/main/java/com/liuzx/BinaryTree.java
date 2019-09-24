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
        if (root == null) {
            return list;
        }
        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.add(root);
        while (!levelNodes.isEmpty()) {
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
        DFSHelper(root, 0, list);
        return list;
    }

    private void DFSHelper(TreeNode node, int level, List<List<Integer>> list) {
        if (list.size() < (level + 1)) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        if (node.left != null) {
            DFSHelper(node.left, level + 1, list);
        }
        if (node.right != null) {
            DFSHelper(node.right, level + 1, list);
        }
    }

    /**
     * @Author liuzx
     * @Date 2019/8/16 9:56
     * @Description 树的最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.add(root);
        int maxDepth = 0;
        while (!levelNodes.isEmpty()) {
            maxDepth++;
            int size = levelNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = levelNodes.poll();
                if (node.left != null) {
                    levelNodes.add(node.left);
                }
                if (node.right != null) {
                    levelNodes.add(node.right);
                }
            }
        }
        return maxDepth;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth2(root.left);
        int rightDepth = maxDepth2(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * @Author liuzx
     * @Date 2019/8/16 11:49
     * @Description 是否是镜像对称
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.add(root.left);
        levelNodes.add(root.right);
        while (!levelNodes.isEmpty()) {
            TreeNode leftNode = levelNodes.poll();
            TreeNode rightNode = levelNodes.poll();
            if (!equal(leftNode, rightNode)) {
                return false;
            }
            if (leftNode != null) {
                levelNodes.add(leftNode.left);
                levelNodes.add(rightNode.right);
                levelNodes.add(leftNode.right);
                levelNodes.add(rightNode.left);
            }
        }
        return true;
    }

    private boolean equal(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if ((leftNode != null && rightNode == null) || (leftNode == null && rightNode != null)) {
            return false;
        }
        if (leftNode.val == rightNode.val) {
            return true;
        }
        return false;
    }

    /**
     * @Author liuzx
     * @Date 2019/8/19 10:03
     * @Description 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        root.val = sum - root.val;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //叶子节点
            if (node.left == null && node.right == null) {
                if (node.val == 0) {
                    return true;
                } else {
                    continue;
                }
            }
            //非叶子节点
            if (node.left != null) {
                node.left.val = node.val - node.left.val;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val - node.right.val;
                queue.add(node.right);
            }
        }
        return false;
    }

    /**
     * @Author liuzx
     * @Date 2019/8/19 11:36
     * @Description 根据一棵树的中序遍历与后序遍历构造二叉树。
     * <p>
     * 注意:
     * 你可以假设树中没有重复的元素。
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int iBegin, int iEnd, int[] postorder, int pBegin, int pEnd) {
        int rootValue = postorder[pEnd];
        TreeNode root = new TreeNode(rootValue);
        if (iBegin == iEnd) {
            return root;
        }
        int rootIndex = 0;
        for (int i = iBegin; i <= iEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        if (iBegin < rootIndex) {
            int pLeftEnd = pBegin + rootIndex - 1 - iBegin;
            root.left = buildTreeHelper(inorder, iBegin, rootIndex - 1, postorder, pBegin, pLeftEnd);
        }
        if (rootIndex < iEnd) {
            int pRightBegin = pEnd + rootIndex - iEnd;
            root.right = buildTreeHelper(inorder, rootIndex + 1, iEnd, postorder, pRightBegin, pEnd - 1);
        }
        return root;
    }

    /**
     * @Author liuzx
     * @Date 2019/8/19 13:56
     * @Description 根据一棵树的前序遍历与中序遍历构造二叉树。
     * <p>
     * 注意:
     * 你可以假设树中没有重复的元素。
     */
    public TreeNode preBuildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper2(int[] preorder, int pBegin, int pEnd, int[] inorder, int iBegin, int iEnd) {
        if (iBegin > iEnd) {
            return null;
        }
        int rootValue = preorder[pBegin];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = 0;
        for (int i = iBegin; i <= iEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        root.left = buildTreeHelper2(preorder, pBegin + 1, rootIndex + pBegin - iBegin, inorder, iBegin, rootIndex - 1);
        root.right = buildTreeHelper2(preorder, rootIndex + pBegin - iBegin + 1, pEnd, inorder, rootIndex + 1, iEnd);
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftCommonNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightCommonNode = lowestCommonAncestor(root.right, p, q);
        if (leftCommonNode != null && rightCommonNode != null) {
            return root;
        }
        if (leftCommonNode != null) {
            return leftCommonNode;
        }
        if (rightCommonNode != null) {
            return rightCommonNode;
        }
        return null;
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean emptyFlag = false;
        while (!queue.isEmpty()) {
            if (emptyFlag) {
                break;
            }
            int size = queue.size();
            emptyFlag = true;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    builder.append("n").append(",");
                } else {
                    builder.append(node.val).append(",");
                    queue.add(node.left);
                    queue.add(node.right);
                    if (node.left != null || node.right != null) {
                        emptyFlag = false;
                    }
                }
            }
            builder.deleteCharAt(builder.length() - 1).append(".");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] levels = data.split("\\.");
        TreeNode root = new TreeNode(Integer.parseInt(levels[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < levels.length; i++) {
            String[] nodeDatas = levels[i].split(",");
            int j = 0;
            int size = queue.size();
            for (int queueIndex = 0; queueIndex < size; queueIndex++) {
                TreeNode node = queue.poll();
                String leftVal = nodeDatas[j++];
                String rightVal = nodeDatas[j++];
                if (!leftVal.equals("n")) {
                    node.left = new TreeNode(Integer.parseInt(leftVal));
                    queue.add(node.left);
                }
                if (!rightVal.equals("n")) {
                    node.right = new TreeNode(Integer.parseInt(rightVal));
                    queue.add(node.right);
                }
            }
        }
        return root;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
//        BinaryTree tree = new BinaryTree();
//        int[] preorder = new int[]{3, 9, 20, 15, 7};
//        int[] inorder = new int[]{9, 3, 15, 20, 7};
//
//        TreeNode node = tree.preBuildTree(preorder, inorder);
//        List<List<Integer>> list = tree.levelOrder(node);
//        list.forEach(datas -> {
//            datas.forEach(a -> System.out.print(a + " "));
//            System.out.println();
//        });
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.new TreeNode(1);
        root.left = tree.new TreeNode(2);
        root.right = tree.new TreeNode(3);
        root.left.left = tree.new TreeNode(4);
        root.left.left.right = tree.new TreeNode(5);
        root.left.right = tree.new TreeNode(6);
        root.right.left = tree.new TreeNode(7);
        root.right.right = tree.new TreeNode(8);
        String node = tree.serialize(root);
        root = tree.deserialize(node);
        String node2 = tree.serialize(root);
        System.out.println(node);
        System.out.println(node2);
    }
}
