package com.sebar.test.reviewleetcode.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 */

public class ThreeSums_15 {
    /**
     * 双指针的方式进行查找
     * O(nlogn)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return resList;
        }

        // 先进行排序
        Arrays.sort(nums);
        // 固定两根指针
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 相同元素。跳过
                continue;
            }
            //另外两个数相加的和
            int target = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                // 大了
                if (nums[left] + nums[right] > target) {
                    right--;
                    // 小了
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    //记录这三个数
                    resList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    right--;
                    left++;
                    // 避免重复数字
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

    /**
     * 暴力求解
     */
    public List<List<Integer>> threeSumPowerFix(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return resList;
        }
        // 第一层
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int z = j + 1; z < nums.length; z++) {
                    if (nums[i] + nums[j] + nums[z] == 0) {
                        resList.add(Arrays.asList(nums[i], nums[j], nums[z]));
                    }
                }
            }
        }
        return resList;
    }
}
