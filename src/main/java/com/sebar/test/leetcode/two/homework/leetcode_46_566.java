package com.sebar.test.leetcode.two.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liguang
 * @Date 2020/2/22
 * @Description
 */
public class leetcode_46_566 {

    public static void main(String[] args) {
        leetcode_46_566 code = new leetcode_46_566();
        List<List<Integer>> listList = code.permute(new int[]{1, 2, 3});
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backTrack(output, new ArrayList<>(), nums);

        return output;
    }

    /**
     * 回溯算法
     *
     * @param output   输出结果集
     * @param tempList 暂存结果集
     * @param nums     输入的数组
     */
    private void backTrack(List<List<Integer>> output, ArrayList<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            output.add(new ArrayList<>(tempList));
        }
        for (int i = 0; i < nums.length; i++) {
            // 包含该元素就跳过，添加未包含的元素
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            backTrack(output, tempList, nums);
            // 移掉最后一个元素，形成新的数组
            tempList.remove(tempList.size() - 1);
        }
    }
}
