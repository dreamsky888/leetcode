package com.liuzx.recursion;

/**
 * @Author: liuzx
 * @Date: 2019/10/11 17:52
 * @Description: 反转字符串
 **/
public class ReverseString {
    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }

    private void helper(char[] s, int begin, int end) {
        if (begin >= end) {
            return;
        }
        swap(s, begin, end);
        helper(s, begin + 1, end - 1);
    }

    private void swap(char[] s, int begin, int end) {
        char tmp = s[begin];
        s[begin] = s[end];
        s[end] = tmp;
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        String s = "helloworld";
        char[] chars = s.toCharArray();
        reverseString.reverseString(chars);
        System.out.println(chars);
    }
}
