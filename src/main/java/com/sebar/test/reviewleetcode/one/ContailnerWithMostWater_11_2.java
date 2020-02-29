package com.sebar.test.reviewleetcode.one;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description
 */

public class ContailnerWithMostWater_11_2 {
    public int maxArea(int[] nums) {
        int maxArea = 0, left = 0, right = nums.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(nums[left], nums[right] * (right - left)));
            // 左边比右边高
            if (nums[left] > nums[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
