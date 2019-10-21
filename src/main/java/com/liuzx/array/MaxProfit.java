package com.liuzx.array;

/**
 * @Author: liuzx
 * @Date: 2019/10/15 16:20
 * @Description:
 **/
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int length = prices.length;
        if (length == 0) {
            return profit;
        }
        int begin = 0;
        for (int i = 1; i < length; i++) {
            if (prices[i] <= prices[i - 1]) {
                if (i - 1 > begin) {
                    profit += prices[i - 1] - prices[begin];
                }
                begin = i;
            }
        }
        if (length - 1 > begin) {
            profit += prices[length - 1] - prices[begin];
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] profiles = new int[]{1, 2, 3};
        int i = maxProfit.maxProfit(profiles);
        System.out.println(i);
    }
}
