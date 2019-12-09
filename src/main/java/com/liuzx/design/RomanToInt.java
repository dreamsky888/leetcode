package com.liuzx.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuzx
 * @Date: 2019/11/13 17:04
 * @Description:
 **/
public class RomanToInt {
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int pre = 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));
            if (curr > pre) {
                num -= pre * 2;
            }
            num += curr;
            pre = curr;
        }
        return num;
    }

    public static void main(String[] args) {
        int i = RomanToInt.romanToInt("IV");
        System.out.println(i);
    }


}
