package com.liuzx.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuzx
 * @Date: 2019/10/12 11:13
 * @Description: 杨辉三角
 **/
public class Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        for (int row = 1; row <= numRows; row++) {
            List<Integer> data = new ArrayList<>(row);
            for (int i = 0; i < row; i++) {
                if (i == 0 || i == row - 1) {
                    data.add(1);
                } else {
                    List<Integer> lastRowData = list.get(list.size() - 1);
                    data.add(lastRowData.get(i - 1) + lastRowData.get(i));
                }
            }
            list.add(data);
        }
        return list;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        list.add(1);
        for (int row = 1; row <= rowIndex; row++) {
            for (int i = row; i >= 1; i--) {
                if (i == row) {
                    list.add(1);
                } else {
                    list.set(i, list.get(i - 1) + list.get(i));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        //List<List<Integer>> generate = triangle.generate(5);
//        generate.forEach(datas -> {
//            datas.forEach(data -> {
//                System.out.print(data + " ");
//            });
//            System.out.println();
//        });
        List<Integer> rows = triangle.getRow(4);
        rows.forEach(data -> {
            System.out.print(data + " ");
        });
    }
}
