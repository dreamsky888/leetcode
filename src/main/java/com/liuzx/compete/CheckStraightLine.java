package com.liuzx.compete;

/**
 * @author 刘钟鑫
 * @date 2019-10-21 14:25
 * @desc 缀点成线
 **/
public class CheckStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null) {
            return false;
        }
        if (coordinates.length < 3) {
            return true;
        }
        int diff_x = coordinates[1][0] - coordinates[0][0];
        int diff_y = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            int temp_x = coordinates[i][0] - coordinates[0][0];
            int temp_y = coordinates[i][1] - coordinates[0][1];
            if (diff_y * temp_x != diff_x * temp_y) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        CheckStraightLine line = new CheckStraightLine();
        int[][] coordinates = new int[][]{{1, 1}, {2, 2}, {3, 3}, {7, 7}};
        boolean b = line.checkStraightLine(coordinates);
        System.out.println(b);

    }
}
