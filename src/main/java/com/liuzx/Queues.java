package com.liuzx;

import java.util.*;

/**
 * @Author: liuzx
 * @Date: 2019/8/21 14:23
 * @Description: 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少
 **/
public class Queues {

    public int numSquares(int n) {
        List<Integer> squareDatas = new ArrayList<>();
        int index = 1;
        int sum = index * index;
        int[] datas = new int[n];
        while (sum <= n) {
            if (sum == n) {
                return 1;
            }
            datas[sum - 1] = 1;
            squareDatas.add(sum);
            index++;
            sum = index * index;
        }


        for (int i = 1; i < datas.length; i++) {
            if (datas[i] != 0) {
                continue;
            }
            int value = i + 1;
            int minCount = value;
            for (Integer squareData : squareDatas) {
                if (squareData > value) {
                    break;
                }
                int tmpCount = 1 + datas[i - squareData];
                if (tmpCount < minCount) {
                    minCount = tmpCount;
                }
            }
            datas[i] = minCount;
        }
        return datas[n - 1];
    }

    /**
     * @Author liuzx
     * @Date 2019/8/22 16:21
     * @Description 岛屿数量
     * <p>
     * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
     */
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            char[] chars = grid[i];
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '1') {
                    num++;
                    infect(grid, i, j);
                }
            }
        }
        return num;
    }

    private void infect(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length) {
            return;
        }
        if (j < 0 || j == grid[0].length) {
            return;
        }
        if (grid[i][j] == '0' || grid[i][j] == '2') {
            return;
        }

        grid[i][j] = '2';
        infect(grid, i - 1, j);
        infect(grid, i + 1, j);
        infect(grid, i, j - 1);
        infect(grid, i, j + 1);
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet(Arrays.asList(deadends));
        if (deadSet.contains(target)) {
            return -1;
        }
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        set1.add("0000");
        set2.add(target);
        int count = 0;
        while (!set1.isEmpty() & !set2.isEmpty()) {
            //交换
            if (set1.size() > set2.size()) {
                Set<String> tmpSet = set1;
                set1 = set2;
                set2 = tmpSet;
            }
            Set<String> set3 = new HashSet<>();
            for (String str : set1) {
                if (set2.contains(str)) {
                    return count;
                }
                if (visited.contains(str) || deadSet.contains(str)) {
                    continue;
                }
                visited.add(str);
                addQueue(str, set3);

            }
            set1 = set3;
            count++;
        }
        return -1;
    }

    private void addQueue(String str, Set<String> set3) {
        for (int i = 0; i < 4; i++) {
            StringBuilder builder = new StringBuilder(str);
            char c = (char) (builder.charAt(i) + 1);
            if (c > '9') {
                c = '0';
            }
            builder.setCharAt(i, c);
            set3.add(builder.toString());
            builder = new StringBuilder(str);
            c = (char) (builder.charAt(i) - 1);
            if (c < '0') {
                c = '9';
            }
            builder.setCharAt(i, c);
            set3.add(builder.toString());
        }
    }

    public static void main(String[] args) {
        Queues queue = new Queues();
        String[] deadEnds = new String[]{"0000"};
        String target = "8888";
//        String[] deadEnds = new String[]{"8888"};
//        String target = "0009";
        int i = queue.openLock(deadEnds, target);
        System.out.println("数量：" + i);
    }
}
