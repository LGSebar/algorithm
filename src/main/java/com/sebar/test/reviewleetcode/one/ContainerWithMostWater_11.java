package com.sebar.test.reviewleetcode.one;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description 11. 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 */

public class ContainerWithMostWater_11 {
    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public int maxArea(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int maxArea = 0;
        int left = 0;
        int right = nums.length - 1;

        //存多少水，取决于最短的那一根
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(nums[left], nums[right]) * (right - left));
            if (nums[left] > nums[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

}
