package com.liuzx.dp;

/**
 * @Author: liuzx
 * @Date: 2019/10/22 10:53
 * @Description:
 **/
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxSoFar = 0;
        int maxEndI = 0;
        for (int i = 1; i < prices.length; i++) {
            int diffPrice = prices[i] - prices[i - 1];
            maxEndI = maxEndI < 0 ? diffPrice : diffPrice + maxEndI;
            if (maxSoFar < maxEndI) {
                maxSoFar = maxEndI;
            }
        }
        return maxSoFar;
    }
}
