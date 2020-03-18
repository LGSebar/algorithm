package com.sebar.test.reviewleetcode.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 40. 组合总和 II
 */
public class CombinationSumii_40_1 {
    List<List<Integer>> resList = new ArrayList<>();

    /**
     * 结果集
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        Arrays.sort(candidates);

        backTrack(candidates, new ArrayList<Integer>(), target, 0);
        return resList;
    }

    /**
     * @param candidates
     * @param childList
     * @param target
     * @param index
     */
    private void backTrack(int[] candidates, ArrayList<Integer> childList, int target, int index) {
        if (target == 0) {
            resList.add(new ArrayList<>(childList));
            return;
        }
        //选择列表
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            childList.add(candidates[i]);
            backTrack(candidates, childList, target - candidates[i], i + 1);
            // 撤销选项
            childList.remove(childList.size() - 1);
        }
    }
}
