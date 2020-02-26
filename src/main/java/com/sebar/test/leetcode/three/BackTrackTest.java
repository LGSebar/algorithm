package com.sebar.test.leetcode.three;

import java.util.*;

/**
 * 回溯算法练习题
 */

/**
 * 回溯模板
 * result = []
 * def backtrack(路径, 选择列表):
 * if 满足结束条件:
 * result.add(路径)
 * return
 * <p>
 * for 选择 in 选择列表:
 * 做选择
 * backtrack(路径, 选择列表)
 * 撤销选择
 */
public class BackTrackTest {
    /**
     * 结果集
     */
    static List<List<Integer>> resList = new ArrayList<>();

    /**
     * 回溯算法练习1
     * 题目要求 n个数，全部的排列列表
     *
     * @param nums 数组
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        // 调用回溯
        backTrack(nums, new ArrayList<>());
        return resList;
    }

    /**
     * 回溯算法练习1
     * 题目要求 n个数，全部的排列列表
     *
     * @param nums     输入的数组
     * @param tempList 临时寄存数组列表
     */
    private void backTrack(int[] nums, List<Integer> tempList) {
        // 结束条件
        if (tempList.size() == nums.length) {
            resList.add(new ArrayList<>(tempList));
            return;
        }

        // 开始循环取用数据
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            // 回溯
            backTrack(nums, tempList);
            //撤销选择
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * 回溯算法生成括号
     * https://leetcode-cn.com/problems/generate-parentheses
     * （（（）））
     *
     * @param n
     * @return
     */
    public List<String> backTrackGenerateParentHesis(int n) {
        List<String> resParentList = new ArrayList<>();
        backTrackHesis("", resParentList, 0, 0, n);
        return resParentList;
    }

    /**
     * 回溯算法生成括号
     *
     * @param s             开始拼接的字符串
     * @param resParentList 结果集
     * @param left          左括号使用数量
     * @param right         右括号使用数量
     * @param n             左右括号可使用数量
     */
    private void backTrackHesis(String s, List<String> resParentList, int left, int right, int n) {
        // 满足条件结束 左右括号都达到阈值结束
        if (left == n && right == n) {
            resParentList.add(s);
            return;
        }
        // 选择列表
        // 做出选择
        // 左括号没用完，则使用左括号
        if (left < n) {
            backTrackHesis(s + "(", resParentList, left + 1, right, n);
        }
        // 右括号没用完，则可以使用右括号
        if (right < left) {
            backTrackHesis(s + ")", resParentList, left, right, n);
        }
        // 撤销选择
    }

    /**
     * 回溯算法练习题
     * https://leetcode-cn.com/problems/combinations/
     * 题目
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     *
     * @param n 范围
     * @param k 一条记录数据个数
     * @return
     */
    public List<List<Integer>> backTrackCombine(int n, int k) {
        List<List<Integer>> combineList = new ArrayList<>();
        backTrackCombineLogic(combineList, new ArrayList<>(), n, k, 1);
        return combineList;
    }

    /**
     * 回溯解决1-n k个数的所有组合形态
     *
     * @param combineList 组合结果集
     * @param tempList
     * @param n           范围
     * @param k           个数
     * @param start       开始数字
     */
    private void backTrackCombineLogic(List<List<Integer>> combineList, ArrayList<Integer> tempList, int n, int k, int start) {
        // 满足条件结束
        if (tempList.size() == k) {
            combineList.add(new ArrayList<>(tempList));
            return;
        }

        // 选择列表
        for (int i = start; i <= n; i++) {
            // 做出选择
            tempList.add(i);
            // 返回路径
            backTrackCombineLogic(combineList, tempList, n, k, i + 1);
            // 撤退
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * 回溯算法练习题
     * https://leetcode-cn.com/problems/permutations-ii
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     * 输入: [1,1,2]
     * 输出:
     * [
     * [1,1,2],
     * [1,2,1],
     * [2,1,1]
     * ]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> backTrackPermuteUnique(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums.length == 0) {
            return resList;
        }

        // 先进行排序 排序是剪纸的前提，主要是，排完序后，重复的元素就会处于相邻的位置
        Arrays.sort(nums);
        // 记录元素是否被使用过
        boolean[] used = new boolean[nums.length];
        // 使用队列进行数据暂存
        Deque<Integer> path = new ArrayDeque<>();
        backTrackPermuteUniqueLogic(resList, path, used, 0, nums);
        return resList;
    }

    /**
     * 使用回溯算法进行求解可重复元素的组合
     *
     * @param resList 结果集
     * @param path    暂存结果
     * @param used    记录元素是否已经被使用过
     * @param depth   当前深度
     * @param nums    元素
     */
    private void backTrackPermuteUniqueLogic(List<List<Integer>> resList, Deque<Integer> path,
                                             boolean[] used, int depth, int[] nums) {
        // 满足条件进行结束
        if (path.size() == nums.length) {
            resList.add(new ArrayList<>(path));
            return;
        }

        // 选择列表
        for (int i1 = 0; i1 < nums.length; i1++) {
            // 元素已经被标识为使用过
            if (used[i1]) {
                continue;
            }
            // 出现元素一样的直接跳过
            // i1>1 是为了保证nums[i1-1]有意义
            if (i1 > 1 && nums[i1] == nums[i1 - 1] && !used[i1]) {
                continue;
            }
            // 做出选择
            path.addLast(nums[i1]);
            //标识元素被使用了
            used[i1] = true;
            //回溯
            backTrackPermuteUniqueLogic(resList, path, used, depth + 1, nums);
            // 撤退操作--标识元素还没有被使用
            used[i1] = false;
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        BackTrackTest test = new BackTrackTest();
        List<List<Integer>> permute = test.permute(new int[]{1});
        System.out.println(permute);

//        List<List<Integer>> lists = test.backTrackCombine(3, 2);
//        System.out.println(lists);
    }
}
