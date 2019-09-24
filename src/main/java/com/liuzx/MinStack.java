package com.liuzx;

import java.util.Stack;

/**
 * @Author: liuzx
 * @Date: 2019/8/23 11:15
 * @Description:
 **/
public class MinStack {
    // 数据栈
    private Stack<Integer> data;
    // 辅助栈
    private Stack<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }


    public void push(int x) {
        // 数据栈和辅助栈一定会增加元素
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        }
    }

    public void pop() {
        int value = data.peek();
        if (!data.isEmpty()) {
            data.pop();
        }
        if (value == helper.peek().intValue()) {
            helper.pop();
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if (!helper.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(0);
        minStack.push(1);
        minStack.push(-2);
        minStack.push(5);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
