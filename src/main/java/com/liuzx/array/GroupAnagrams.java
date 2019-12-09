package com.liuzx.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘钟鑫
 * @date 2019-11-27 17:32
 * @desc 字谜分组
 **/
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        Integer[] sortArray = new Integer[26];
        for (String str : strs) {
            //置零
            Arrays.fill(sortArray, 0);
            //设置值
            str.chars().forEach(ch -> sortArray[ch- 'a'] += 1);
            //转为字符串
            StringBuilder builder = new StringBuilder();
            Arrays.stream(sortArray).forEach(num -> builder.append(num).append("#"));
            String key = builder.toString();
            //储存到map中
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String a="werejf";
        a.chars().forEach(c->{
            System.out.println((char)c);
        });
    }
}
