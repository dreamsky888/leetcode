package com.liuzx.recursion;

/**
 * @Author: liuzx
 * @Date: 2019/10/14 15:25
 * @Description:
 **/
public class ClimbStairs {
    static class Matrix {
        private int x0y0, x1y0, x0y1, x1y1;

        public Matrix() {
        }

        public Matrix(int x0y0, int x1y0, int x0y1, int x1y1) {
            this.x0y0 = x0y0;
            this.x1y0 = x1y0;
            this.x0y1 = x0y1;
            this.x1y1 = x1y1;
        }

        public Matrix multiply(Matrix mul) {
            Matrix result = new Matrix();
            result.x0y0 = this.x0y0 * mul.x0y0 + this.x1y0 * mul.x0y1;
            result.x1y0 = this.x0y0 * mul.x1y0 + this.x1y0 * mul.x1y1;
            result.x0y1 = this.x0y1 * mul.x0y0 + this.x1y1 * mul.x0y1;
            result.x1y1 = this.x0y1 * mul.x1y0 + this.x1y1 * mul.x1y1;
            return result;
        }

        public Matrix selfMul(int n) {
            if (n == 1) {
                return this;
            }
            Matrix halfResult = selfMul(n / 2);
            Matrix multiply = halfResult.multiply(halfResult);
            if ((n & 1) == 1) {
                multiply = multiply.multiply(this);
            }
            return multiply;
        }
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        Matrix matrix = new Matrix(1, 1, 1, 0);
        matrix = matrix.selfMul(n - 2);
        return matrix.x0y0 * 2 + matrix.x1y0;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int num = climbStairs.climbStairs(6);
        System.out.println(num);
    }

}
