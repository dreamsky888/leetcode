package com.liuzx;

import java.util.*;

/**
 * @Author: liuzx
 * @Date: 2019/8/29 9:59
 * @Description:
 **/
public class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    private Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        List<Node> neighbors = new ArrayList<>(node.neighbors.size());
        Node cloneNode = new Node(node.val, neighbors);
        node.neighbors.forEach(neighbor -> {
            if (!map.containsKey(neighbor.val)) {

            }
        });
        return null;
    }

    /**
     * @Author liuzx
     * @Date 2019/8/30 11:57
     * @Description 目标和
     */
    public int findTargetSumWays2(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();
        if (sum < S) {
            return 0;
        }
        sum += S;
        if (sum < 0 || sum % 2 == 1) {
            return 0;
        }
        sum /= 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[sum];
    }

    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        findTargetSumWays(nums, 0, S);
        return count;
    }

    private void findTargetSumWays(int[] nums, int index, int s) {
        if (index == nums.length) {
            if (s == 0) {
                count++;
            }
            return;
        }
        findTargetSumWays(nums, index + 1, s + nums[index]);
        findTargetSumWays(nums, index + 1, s - nums[index]);
    }

    public static void main(String[] args) {
        Node node = new Node();
        int targetSumWays = node.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(targetSumWays);
    }
}
