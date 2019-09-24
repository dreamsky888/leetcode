package com.liuzx;

import java.util.LinkedList;

/**
 * @Author: liuzx
 * @Date: 2019/9/23 15:46
 * @Description:
 **/
public class DecodeString {
    /**
     * s = "3[a]2[bc]", 返回 "aaabcbc".
     * s = "3[a2[c]]", 返回 "accaccacc".
     * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
     *
     * @param s
     * @return
     */

    public static String decodeString(String s) {
        LinkedList<Integer> numList = new LinkedList<>();
        LinkedList<String> preStrList = new LinkedList<>();
        StringBuilder preStr = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                numList.addLast(num);
                preStrList.addLast(preStr.toString());
                num = 0;
                preStr.delete(0, preStr.length());
            } else if (ch == ']') {
                int tmpNum = numList.removeLast();
                StringBuilder tmp = new StringBuilder(preStrList.removeLast());
                for (int j = 1; j <= tmpNum; j++) {
                    tmp.append(preStr);
                }
                preStr = tmp;
            } else if (ch >= '0' && ch <= '9') {
                num = num * 10 + ch - '0';
            } else {
                preStr.append(ch);
            }
        }
        return preStr.toString();
    }

    public static void main(String[] args) {
       String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }
}
