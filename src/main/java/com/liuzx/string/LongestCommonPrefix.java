package com.liuzx.string;

/**
 * @Author: liuzx
 * @Date: 2019/10/25 11:58
 * @Description:
 **/
public class LongestCommonPrefix {
    /**
     * 分治法
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int maxLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < maxLength) {
                maxLength = str.length();
            }
        }
        return helper(strs, 0, strs.length - 1, maxLength);
    }

    private String helper(String[] strs, int begin, int end, int maxLength) {
        if (begin == end) {
            return strs[begin];
        }
        int mid = (begin + end) / 2;
        String firstPrefix = helper(strs, begin, mid, maxLength);
        if (firstPrefix.equals("")) {
            return "";
        }
        if (firstPrefix.length() < maxLength) maxLength = firstPrefix.length();
        String secondPrefix = helper(strs, mid + 1, end, maxLength);
        if (secondPrefix.length() < maxLength) maxLength = secondPrefix.length();
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < maxLength; i++) {
            if (firstPrefix.charAt(i) == secondPrefix.charAt(i)) {
                builder.append(firstPrefix.charAt(i));
            } else {
                break;
            }
        }
        return builder.toString();
    }

    /**
     * 水平扫描法
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (str.length() == 0) {
                return "";
            }
            if (prefix.length() > str.length()) {
                prefix = prefix.substring(0, str.length());
            }
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * 水平扫描法
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix4(String[] strs) {
        if (strs.length == 0) return "";
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int index = 1; index < strs.length; index++) {
                if (strs[index].length() == i || strs[index].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    class TrieNode {
        private TrieNode[] nodes;
        private int size = 0;
        private boolean isEnd = false;

        public TrieNode put(char c) {
            if (nodes == null) {
                nodes = new TrieNode[26];
            }

            int index = c - 'a';
            if (nodes[index] == null) {
                size++;
                TrieNode trieNode = new TrieNode();
                nodes[index] = trieNode;
            }
            return nodes[index];
        }

        public TrieNode singleContain(char ch) {
            if (size != 1) {
                return null;
            }
            return nodes[ch - 'a'];
        }
    }

    /**
     * 前缀树
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode();
        if (strs.length == 0) return "";
        for (String str : strs) {
            TrieNode currNode = root;
            for (int i = 0; i < str.length(); i++) {
                currNode = currNode.put(str.charAt(i));
            }
            currNode.isEnd = true;
        }
        int i = 0;
        TrieNode currNode = root;
        for (; i < strs[0].length(); i++) {
            if (currNode.isEnd) {
                break;
            }
            currNode = currNode.singleContain(strs[0].charAt(i));
            if (currNode == null) {
                break;
            }
        }
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] arrays = new String[]{"aa", "", "aaa"};
        String s = longestCommonPrefix.longestCommonPrefix(arrays);
        System.out.println(s);
    }
}
