package com.liuzx.recursion;

/**
 * @Author: liuzx
 * @Date: 2019/10/15 9:55
 * @Description:
 **/
public class KthGrammar {
    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }
        int halfSize = 1 << (N - 2);
        if (K <= halfSize) {
            return kthGrammar(N - 1, K);
        } else {
            return kthGrammar(N - 1, K - halfSize) ^ 1;
        }
    }

    public int kthGrammar2(int N, int K) {
        if (N == 1) return 0;
        return (~K & 1) ^ kthGrammar(N - 1, (K + 1) / 2);
    }

    public static void main(String[] args) {
        KthGrammar grammar = new KthGrammar();
        int i = grammar.kthGrammar(4, 7);
        System.out.println(i);
    }
}
