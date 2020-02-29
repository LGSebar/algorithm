package com.sebar.test.reviewleetcode.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description
 */
public class ThreeSums_15_2 {
    /**
     * 双指针的方式进行处理
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return resList;
        }

        // 进行排序,保证顺序，以及重复元素相邻
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    resList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    right--;
                    left++;
                    // 检测重复元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                }
            }

        }
        return resList;
    }
}
