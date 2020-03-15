package com.sebar.test.leetcode.five.practice;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * 198.打家劫舍
 */
public class Leetcode_198_566 {
    /**
     * 第三个房子的最大值=Math.max(第一个房子抢+当前房子最大值，第二个房子)
     * 第一个房子抢，则第二个不能抢，第三个抢不抢取决于前面，第一个房子加上现在的第三个房子能不能大于第二个房子，大于则抢
     * dp[n]=Math.max(dp[n-1],dp[n-2]+num)
     * num为当前房子的价值
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length];
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preMax = 0, currMax = 0;
        for (int num : nums) {
            int temp = currMax;
            currMax = Math.max(preMax + num, currMax);
            preMax = temp;
        }
        return currMax;
    }
}
