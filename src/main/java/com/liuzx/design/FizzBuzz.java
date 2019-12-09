package com.liuzx.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuzx
 * @Date: 2019/10/28 16:50
 * @Description: 写一个程序，输出从 1 到 n 数字的字符串表示。
 * <p>
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * <p>
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * <p>
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 **/
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        int threeValue = 2;
        int fiveValue = 4;
        for (int i = 0; i < n; i++) {
            if (i == threeValue && i == fiveValue) {
                list.add("FizzBuzz");
                threeValue += 3;
                fiveValue += 5;
            } else if (i == threeValue) {
                list.add("Fizz");
                threeValue += 3;
            } else if (i == fiveValue) {
                list.add("Buzz");
                fiveValue += 5;
            } else {
                list.add((i + 1) + "");
            }
        }
        return list;
    }
}
