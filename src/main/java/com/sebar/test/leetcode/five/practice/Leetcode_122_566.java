package com.sebar.test.leetcode.five.practice;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 122.买卖股票的最佳时机2
 */
public class Leetcode_122_566 {
    /**
     * 贪心算法
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int nowMaxProfit = 0;
        for (int i = 1; i < prices.length - 1; i++) {
            if (prices[i] > prices[i - 1]) {
                nowMaxProfit = prices[i] - prices[i - 1];
            }

        }
        return nowMaxProfit;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        // 持有现金和持有股票
        int[] holdcash = new int[prices.length];
        int[] holdStack = new int[prices.length];

        holdcash[0] = 0;
        holdStack[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // 如果昨天的只有价格，比今天的卖出价格要大，则持有价保持不变
            holdcash[i] = Math.max(holdcash[i - 1], holdStack[i - 1] + prices[i]);
            holdStack[i] = Math.max(holdStack[i - 1], holdcash[i - 1] - prices[i]);
        }
        return holdcash[prices.length - 1];
    }

    public static void main(String[] args) {
        Leetcode_122_566 coco = new Leetcode_122_566();
//        int i = coco.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
//        int i = coco.maxProfit(new int[]{1, 2, 3, 4, 5});
        int i = coco.maxProfit2(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }
}
