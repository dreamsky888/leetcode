package com.liuzx;

import java.util.Arrays;

/**
 * @Author: liuzx
 * @Date: 2019/9/24 11:27
 * @Description: 图像渲染
 **/
public class FloodFill {
    private int oldColor, newColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        oldColor = image[sr][sc];
        this.newColor = newColor;
        if (this.oldColor == this.newColor) {
            return image;
        }
        floodFill(image, sr, sc);
        return image;
    }

    private void floodFill(int[][] image, int sr, int sc) {
        if (sr < 0 || sr >= image.length) {
            return;
        }
        if (sc < 0 || sc >= image[0].length) {
            return;
        }
        if (image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        floodFill(image, sr + 1, sc);
        floodFill(image, sr - 1, sc);
        floodFill(image, sr, sc + 1);
        floodFill(image, sr, sc - 1);
    }

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] results = floodFill.floodFill(image, sr, sc, newColor);
        Arrays.stream(results).forEach(result -> {
            Arrays.stream(result).forEach(data -> System.out.print(data + " "));
            System.out.println();
        });
    }
}
