package com.liuzx.array;

import com.alibaba.fastjson.JSON;

/**
 * @Author: liuzx
 * @Date: 2019/10/16 14:49
 * @Description: 旋转图像
 **/
public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int count = matrix.length / 2;
        for (int num = 0; num < count; num++) {
            int begin = num;
            int end = matrix.length - 1 - num;
            for (int i = 0; i < end - begin; i++) {
                int tmp = matrix[begin][begin + i];
                matrix[begin][begin + i] = matrix[end - i][begin];
                matrix[end - i][begin] = matrix[end][end - i];
                matrix[end][end - i] = matrix[begin + i][end];
                matrix[begin + i][end] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        RotateMatrix matrix = new RotateMatrix();
        int[][] ma = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        matrix.rotate(ma);
        System.out.println(JSON.toJSONString(ma));
    }
}
