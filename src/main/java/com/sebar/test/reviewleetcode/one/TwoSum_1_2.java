package com.sebar.test.reviewleetcode.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description
 */
public class TwoSum_1_2 {
    /**
     * 暴力求解
     * 两遍循环
     * 时间复杂度O(n*n) 空间复杂度O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 两遍hash
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> keyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            keyMap.put(nums[i], i);
        }

        // 再一次进行查询
        for (int j = 0; j < nums.length; j++) {
            int res = target - nums[j];
            if (keyMap.containsKey(res) && keyMap.get(res) != j) {
                return new int[]{keyMap.get(res), j};
            }
        }
        return new int[]{};
    }

    /**
     * 一遍hash
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> keyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (keyMap.containsKey(target - nums[i])) {
                return new int[]{target - nums[i], i};
            }
        }
        return new int[]{};
    }
}
