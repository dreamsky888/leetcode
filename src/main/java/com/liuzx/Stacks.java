package com.liuzx;

import java.util.*;

/**
 * @Author: liuzx
 * @Date: 2019/8/28 14:18
 * @Description:
 **/
public class Stacks {
    /**
     * @Author liuzx
     * @Date 2019/8/28 14:18
     * @Description 有效的括号
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (map.containsKey(a)) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (map.get(a) != stack.pop()) {
                    return false;
                }
            } else {
                stack.add(a);
            }
        }
        return stack.isEmpty();
    }

    /**
     * @Author liuzx
     * @Date 2019/8/28 16:17
     * @Description 每日温度
     */
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] diff = new int[T.length];
        stack.add(0);
        for (int i = 1; i < T.length; i++) {
            int value = T[i];
            while (!stack.isEmpty()) {
                int preIndex = stack.peek();
                int preValue = T[preIndex];
                if (preValue >= value) {
                    break;
                }
                diff[preIndex] = i - preIndex;
                stack.pop();
            }
            stack.add(i);
        }
        return diff;
    }

    /**
     * @Author liuzx
     * @Date 2019/8/28 16:17
     * @Description 逆波兰表达式求值
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> symbolSet = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for (String token : tokens) {
            if (!symbolSet.contains(token)) {
                stack.add(Integer.parseInt(token));
                continue;
            }
            int secondCal = stack.pop();
            int firstCal = stack.pop();
            int finalCal = 0;
            switch (token.charAt(0)) {
                case '+':
                    finalCal = firstCal + secondCal;
                    break;
                case '-':
                    finalCal = firstCal - secondCal;
                    break;
                case '*':
                    finalCal = firstCal * secondCal;
                    break;
                case '/':
                    finalCal = firstCal / secondCal;
                    break;
            }
            stack.add(finalCal);
        }
        return stack.pop();
    }


}
