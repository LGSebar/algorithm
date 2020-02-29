package com.sebar.test.reviewleetcode.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/29
 * @Description 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum_1 {
    /**
     * 采用字典的方式进行求解--一次查找字典级
     * 返回下标
     * 时间复杂度O(n) 空间复杂度也是O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] newRes = new int[2];
        Map<Integer, Integer> keyMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (keyMap.containsKey(target - nums[i])) {
                return new int[]{i, keyMap.get(target - nums[i])};
            }
            keyMap.put(nums[i], i);
        }
        return newRes;
    }

    /**
     * 两边hash表
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] newRes = new int[2];
        Map<Integer, Integer> keyMap = new HashMap<>();

        // 初始化hash表
        for (int i = 0; i < nums.length; i++) {
            keyMap.put(nums[i], i);
        }

        // 再进行查询
        for (int i = 0; i < nums.length; i++) {
            int restNum = target - nums[i];
            // 不是同一个元素
            if (keyMap.containsKey(restNum) && keyMap.get(restNum) != i) {
                return new int[]{i, keyMap.get(restNum)};
            }
        }
        return newRes;
    }

    /**
     * 暴力求解
     * 时间复杂度O(n*n)
     * 空间复杂度O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[i] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
