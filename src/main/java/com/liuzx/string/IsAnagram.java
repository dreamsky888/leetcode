package com.liuzx.string;

/**
 * @Author: liuzx
 * @Date: 2019/10/17 11:36
 * @Description:
 **/
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] datas = new int[26];
        for (char c : s.toCharArray()) {
            datas[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (--datas[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
