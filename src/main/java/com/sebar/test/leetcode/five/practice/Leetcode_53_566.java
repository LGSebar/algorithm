package com.sebar.test.leetcode.five.practice;

/**
 * 最大子序列
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class Leetcode_53_566 {
    /**
     * 最大子序列和
     * 最优子结构 dp[i]=Math.max(num[i],maxSum)
     * 中间状态存储 需要记录当前数与上一个数相加的最大数
     * 递推工程
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // 特殊情况
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //中间存储
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(maxSum, nums[i]);
        }
        return maxSum;
    }


    public static void main(String[] args) {
        Leetcode_53_566 coco = new Leetcode_53_566();
        int i = coco.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);

    }
}
