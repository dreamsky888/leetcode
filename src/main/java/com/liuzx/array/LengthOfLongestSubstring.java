package com.liuzx.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘钟鑫
 * @date 2019-11-28 16:25
 * @desc
 **/
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer index = map.get(ch);
            if (index != null && index >= begin) {
                int tmpMax = i - begin;
                if (tmpMax > max) {
                    max = tmpMax;
                }
                begin = index + 1;
            }
            map.put(ch, i);

        }
        int tmpMax = s.length() - begin;
        if (tmpMax > max) {
            max = tmpMax;
        }
        return max;
    }

    public static void main(String[] args) {
        String a = " ";
        LengthOfLongestSubstring substring = new LengthOfLongestSubstring();
        int i = substring.lengthOfLongestSubstring(a);
        System.out.println(i);
    }
}
