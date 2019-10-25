package com.liuzx.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuzx
 * @Date: 2019/10/23 15:25
 * @Description: 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 **/
public class StrStr {
    /**
     * 暴力破解
     * o(n^2)
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = i;
            for (int nIndex = 0; nIndex < needle.length(); nIndex++, j++) {
                if (haystack.charAt(j) != needle.charAt(nIndex)) {
                    break;
                }
                if (nIndex == needle.length() - 1) {
                    return i;
                }

            }
        }
        return -1;
    }

    /**
     * Sunday算法
     * 平均o(n)
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int nLength = needle.length();
        for (int i = 0; i < nLength; i++) {
            map.put(needle.charAt(i), nLength - i);
        }
        int hLength = haystack.length();
        int hIndex = 0;
        while (hIndex <= hLength - nLength) {
            int j = hIndex;
            for (int nIndex = 0; nIndex < needle.length(); nIndex++, j++) {
                if (haystack.charAt(j) != needle.charAt(nIndex)) {
                    if(hIndex+nLength>=hLength){
                        return -1;
                    }
                    Integer distance = map.get(haystack.charAt(hIndex + nLength));
                    if (distance == null) {
                        hIndex += needle.length() + 1;
                    } else {
                        hIndex += distance;
                    }
                    break;
                }
                if (nIndex == needle.length() - 1) {
                    return hIndex;
                }
            }
        }
        return -1;
    }

    /**
     * KMP算法
     * 平均o(n)
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr3(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int[] next = new int[needle.length()];
        next[0] = -1;
        next[1] = 0;
        //TODO KMP算法的next数组如何算
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {

            for (int nIndex = 0; nIndex < needle.length(); nIndex++, i++) {
                if (haystack.charAt(i) != needle.charAt(nIndex)) {
                    break;
                }
                if (nIndex == needle.length() - 1) {
                    return i;
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        int i = strStr.strStr2("hello", "ll");
        System.out.println(i);
    }
}
