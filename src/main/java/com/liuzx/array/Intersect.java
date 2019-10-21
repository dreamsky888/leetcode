package com.liuzx.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liuzx
 * @Date: 2019/10/16 10:30
 * @Description: 两个数组的交集 II
 **/
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>(nums1.length);
        for (int num : nums1) {
            Integer count = map1.get(num);
            if (count == null) {
                count = 0;
            }
            map1.put(num, count + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            Integer count = map1.get(num);
            if (count == null || count == 0) {
                continue;
            }
            list.add(num);
            map1.put(num, count - 1);
        }
        int[] datas = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            datas[i] = list.get(i);
        }
        return datas;
    }

    public static void main(String[] args) {

    }
}
