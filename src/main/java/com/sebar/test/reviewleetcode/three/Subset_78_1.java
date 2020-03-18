package com.sebar.test.reviewleetcode.three;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 * 78. 子集
 */
public class Subset_78_1 {
    /**
     * 回溯算法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> resList = new ArrayList<>();
        backtrack(nums, resList, new ArrayList<>(), 0);
        return resList;
    }

    private void backtrack(int[] nums, List<List<Integer>> resList, List<Integer> childList, int level) {
        //
        resList.add(new ArrayList<>(childList));
        for (int i = level; i < nums.length; i++) {
            childList.add(nums[level]);
            backtrack(nums, resList, childList, level + 1);
            // 移除最后一个
            childList.remove(childList.size() - 1);
        }


    }
}
