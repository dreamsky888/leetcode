package com.liuzx.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: liuzx
 * @Date: 2019/10/16 13:51
 * @Description:有效的数独
 **/
public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>(13);
        //行
        if (!validateRow(board, set, true)) {
            return false;
        }
        //列
        if (!validateRow(board, set, false)) {
            return false;
        }
        //3x3宫
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int row = i * 3; row < (i + 1) * 3; row++) {
                    for (int col = j * 3; col < (j + 1) * 3; col++) {
                        char c = board[row][col];
                        if (c == '.') {
                            continue;
                        }
                        if (!set.add(c)) {
                            return false;
                        }
                    }
                }
                set.clear();
            }
        }
        return true;
    }

    private boolean validateRow(char[][] board, Set<Character> set, boolean rowFlag) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c;
                if (rowFlag) {
                    c = board[i][j];
                } else {
                    c = board[j][i];
                }
                if (c == '.') {
                    continue;
                }
                if (!set.add(c)) {
                    return false;
                }
            }
            set.clear();
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        Set<Character>[] rowSets = new Set[9];
        Set<Character>[] colSets = new Set[9];
        Set<Character>[] childSets = new Set[9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                if (c == '.') {
                    continue;
                }
                if (rowSets[row] == null) {
                    rowSets[row] = new HashSet<>(12);
                }
                if (!rowSets[row].add(c)) {
                    return false;
                }
                if (colSets[col] == null) {
                    colSets[col] = new HashSet<>(12);
                }
                if (!colSets[col].add(c)) {
                    return false;
                }
                int childIndex = (row / 3) * 3 + col / 3;
                if (childSets[childIndex] == null) {
                    childSets[childIndex] = new HashSet<>(12);
                }
                if (!childSets[childIndex].add(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        IsValidSudoku isValidSudoku = new IsValidSudoku();
        boolean validSudoku = isValidSudoku.isValidSudoku2(board);
        System.out.println(validSudoku);
    }
}
