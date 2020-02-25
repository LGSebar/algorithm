package com.sebar.test.leetcode.three;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_78_566 {
    /**
     * 回溯算法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        backRack(nums, resList, new ArrayList<>(), 0);
        return resList;
    }

    private void backRack(int[] nums, List<List<Integer>> resList, List<Integer> tempList, int index) {
        resList.add(new ArrayList<>(tempList));
        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            backRack(nums, resList, tempList, i + 1);
            // 移除最后一个，后退一步
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * 二进制位移
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> moveSubSets(int[] nums) {
        List<List<Integer>> subList = new ArrayList<>();
        int x = 1 << nums.length;
        for (int i = 0; i < x; i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                int i1 = i >> j;
                int y = (i1) & 1;
                if (y == 1) {
                    sub.add(nums[j]);
                }
            }
            subList.add(sub);
        }
        return subList;
    }

    /**
     * 枚举的方式解决
     * 逐个枚举，空集的幂集只有空集，每增加一个元素，让之前幂集中的每个集合，追加这个元素，就是新增的子集。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> enumSubSets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        resList.add(new ArrayList<>());

        for (int num : nums) {
            int size = resList.size();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> subList = new ArrayList<>(resList.get(i));
                subList.add(num);

                resList.add(subList);
            }
        }
        return resList;
    }

    /**
     * 递归枚举
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> recursiveEnumSubSet(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        recursiveEnum(nums, resList, 0);
        return resList;
    }

    /**
     * @param nums
     * @param resList
     * @param i
     */
    private void recursiveEnum(int[] nums, List<List<Integer>> resList, int i) {
        // recursive terminator
        if (i >= nums.length) {
            return;
        }

        // process on
        int size = resList.size();
        for (int i1 = 0; i1 < size; i1++) {
            ArrayList<Integer> subList = new ArrayList<>(resList.get(i1));
            subList.add(nums[i]);

            resList.add(subList);
        }

        // drill down
        recursiveEnum(nums, resList, i + 1);
    }

    public static void main(String[] args) {
        Leetcode_78_566 code = new Leetcode_78_566();
//        List<List<Integer>> subsets = code.subsets(new int[]{1, 2, 3});
//        List<List<Integer>> subsets = code.moveSubSets(new int[]{1, 2, 3});
        List<List<Integer>> subsets = code.enumSubSets(new int[]{1, 2, 3});

    }
}
