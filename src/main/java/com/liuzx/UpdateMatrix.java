package com.liuzx;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: liuzx
 * @Date: 2019/9/24 16:51
 * @Description: 01 矩阵
 * <p>
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 **/
public class UpdateMatrix {

    static class Matrix {
        int x;
        int y;

        public Matrix() {
        }

        public Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //广度优先搜索
    public int[][] updateMatrix(int[][] matrix) {
        int xLength = matrix.length;
        int yLength = matrix[0].length;
        int[][] distances = new int[xLength][yLength];

        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances[0].length; j++) {
                distances[i][j] = -1;
            }
        }
        Queue<Matrix> queue = new LinkedList<>();
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (matrix[i][j] == 0) {
                    distances[i][j] = 0;
                    queue.add(new Matrix(i, j));
                }
            }
        }
        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Matrix m = queue.poll();
                int xIndex = m.x;
                int yIndex = m.y;
                if (xIndex > 0 && distances[xIndex - 1][yIndex] == -1) {
                    distances[xIndex - 1][yIndex] = distance;
                    queue.add(new Matrix(xIndex - 1, yIndex));
                }
                if (xIndex < xLength - 1 && distances[xIndex + 1][yIndex] == -1) {
                    distances[xIndex + 1][yIndex] = distance;
                    queue.add(new Matrix(xIndex + 1, yIndex));
                }
                if (yIndex > 0 && distances[xIndex][yIndex - 1] == -1) {
                    distances[xIndex][yIndex - 1] = distance;
                    queue.add(new Matrix(xIndex, yIndex - 1));
                }
                if (yIndex < yLength - 1 && distances[xIndex][yIndex + 1] == -1) {
                    distances[xIndex][yIndex + 1] = distance;
                    queue.add(new Matrix(xIndex, yIndex + 1));
                }
            }
            distance++;
        }
        return distances;
    }

    //动态规划
    public int[][] updateMatrix2(int[][] matrix) {
        return null;
    }

    public static void main(String[] args) {
        UpdateMatrix test = new UpdateMatrix();
        int[][] matrix = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ints = test.updateMatrix(matrix);
        for (int i = 0; i < ints.length; i++) {
            int[] data = ints[i];
            for (int j = 0; j < data.length; j++) {
                System.out.print(data[j] + " ");
            }
            System.out.println();
        }
    }
}
