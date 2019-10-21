package com.liuzx.string;

/**
 * @Author: liuzx
 * @Date: 2019/10/17 13:44
 * @Description:
 **/
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0, j = length - 1; ; i++, j--) {
            Character iChar = '0', jChar = '0';
            while (i < j && (iChar = getChar(s.charAt(i))) == null) {
                i++;
            }
            while (i < j && (jChar = getChar(s.charAt(j))) == null) {
                j--;
            }
            if (i >= j) {
                break;
            }
            if (iChar != jChar) {
                return false;
            }
        }
        return true;
    }


    private Character getChar(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c - 'A' + 'a');
        }
        if (c >= 'a' && c <= 'z') {
            return c;
        }
        if (c >= '0' && c <= '9') {
            return c;
        }
        return null;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        boolean flag = isPalindrome.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(flag);
    }
}
