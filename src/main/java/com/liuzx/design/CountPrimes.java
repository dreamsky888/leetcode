package com.liuzx.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuzx
 * @Date: 2019/10/28 17:12
 * @Description:
 **/
public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        int count = 1;
        list.add(2);
        for (int i = 3; i < n; i = i + 2) {
            int max = (int) Math.sqrt(i) + 1;
            boolean flag = true;
            for (Integer num : list) {
                if (num > max) {
                    break;
                }
                if (i % num == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(i);
                count++;
            }
        }
        return count;
    }
}
