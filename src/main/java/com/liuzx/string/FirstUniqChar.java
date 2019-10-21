package com.liuzx.string;

/**
 * @Author: liuzx
 * @Date: 2019/10/17 11:09
 * @Description: 字符串中的第一个唯一字符
 **/
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        int[] datas = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            datas[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (datas[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
