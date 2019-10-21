package com.liuzx.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liuzx
 * @Date: 2019/10/14 14:14
 * @Description: 斐波那契数
 **/
public class Fib {
    private Map<Integer, Integer> caches = new HashMap<>();

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        if (caches.get(N) != null) {
            return caches.get(N);
        }
        int sum = fib(N - 1) + fib(N - 2);
        caches.put(N, sum);
        return sum;
    }

    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        int pre = 0;
        int cur = 1;
        for (int i = 2; i <= N; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }

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

    public int fib3(int N) {
        if (N <= 1) {
            return N;
        }
        if (N == 2) {
            return 1;
        }
        Matrix matrix = new Matrix(1, 1, 1, 0);
        matrix = matrix.selfMul(N - 2);
        return matrix.x0y0 + matrix.x1y0;
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        int num = fib.fib3(6);
        System.out.println(num);
    }
}
