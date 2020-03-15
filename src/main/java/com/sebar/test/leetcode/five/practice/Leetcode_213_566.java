package com.sebar.test.leetcode.five.practice;

/**
 * https://leetcode-cn.com/problems/house-robber-ii/description/
 * 213。打家劫舍2
 */
public class Leetcode_213_566 {
    /**
     * 考虑到最后一家与第一家相连，则会有以下问题
     * 1.要么都不被抢， 房子选择余地变少了，则肯定比其他两种情况少抢资源
     * 2.要么第一间房子被抢，最后一间不抢
     * 3.要么最后一间房子被抢，第一间房子不抢
     * 三者取最大值
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));

    }

    /**
     * 范围进行抢劫
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int robRange(int[] nums, int start, int end) {
        int pre = 0, curr = 0;
        for (int i = start; i <= end; i++) {
            int temp = curr;
            curr = Math.max(pre + nums[i], curr);
            pre = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        Leetcode_213_566 coco = new Leetcode_213_566();
        int rob = coco.rob(new int[]{2, 3, 2});
        System.out.println(rob);
    }
}
