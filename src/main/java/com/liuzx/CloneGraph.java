package com.liuzx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liuzx
 * @Date: 2019/9/18 16:01
 * @Description: 克隆图
 **/
public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return cloneHelper(node, map);
    }

    private Node cloneHelper(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node cloneNode = new Node();
        cloneNode.val = node.val;
        map.put(node.val, cloneNode);
        cloneNode.neighbors = new ArrayList<>(node.neighbors.size());
        node.neighbors.forEach(childNode -> {
            cloneNode.neighbors.add(cloneHelper(childNode, map));
        });
        return cloneNode;
    }
}
