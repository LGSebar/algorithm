package com.sebar.test.reviewleetcode.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 39. 组合总和
 */
public class CombinationSum_39_1 {
    /**
     * 返回结果
     */
    static List<List<Integer>> resList = new ArrayList<>();

    /**
     * 回溯算法
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        // 保证数据有序，便于剪枝
        Arrays.sort(candidates);
        backTrack(candidates, new ArrayList<Integer>(), target, 0);
        return resList;
    }

    /**
     * 回溯算法
     *
     * @param candidates
     * @param childList
     * @param target
     */
    private void backTrack(int[] candidates, ArrayList<Integer> childList, int target, int begin) {
        //如果满足条件
        if (target == 0) {
            resList.add(new ArrayList<>(childList));
            return;
        }
        //选择列表循环
        for (int i = begin; i < candidates.length; i++) {

            if (target - candidates[i] < 0) {
                break;
            } else {
                // 进行选择
                childList.add(candidates[i]);
                backTrack(candidates, childList, target - candidates[i], i);
                // 撤销选择
                childList.remove(childList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum_39_1 coco = new CombinationSum_39_1();
        List<List<Integer>> lists = coco.combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists);
    }
}
