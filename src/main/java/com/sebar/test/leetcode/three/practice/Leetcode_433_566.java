package com.sebar.test.leetcode.three.practice;

import java.util.HashSet;

/**
 * @author liguang
 * @Date 2020/2/27
 * @Description 433. 最小基因变化
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 */

public class Leetcode_433_566 {
    /**
     * 最小变化数
     */
    Integer minMutation = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Leetcode_433_566 code = new Leetcode_433_566();
        int i = code.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"});
        System.out.println(i);
    }

    /**
     * 最小基因变化
     * 回溯法
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
     *
     * @param start 开始基因序列
     * @param end   结束基因序列
     * @param bank  基因序列库
     * @return
     */

    public int minMutation(String start, String end, String[] bank) {
        // 回溯算法解决
        backTrack(start, end, bank, 0, new HashSet<String>());
        return minMutation == Integer.MAX_VALUE ? -1 : minMutation;
    }

    /**
     * 回溯算法解决基因变化序列
     *
     * @param current   起始基因序列
     * @param end       结束基因序列
     * @param bank      基因序列库
     * @param stepCount 计步器
     * @param tempSet   暂存中间结果
     */
    private void backTrack(String current, String end, String[] bank, int stepCount, HashSet<String> tempSet) {
        // 满足条件终止
        if (current.equalsIgnoreCase(end)) {
            minMutation = Math.min(stepCount, minMutation);
            return;
        }

        // 选择列表
        for (String str : bank) {
            int diff = 0;
            // 做出选择
            for (int i = 0; i < str.length(); i++) {
                if (current.charAt(i) != str.charAt(i)) {
                    if (++diff > 1) {
                        break;
                    }
                }
            }
            //backTrack
            if (diff == 1 && !tempSet.contains(str)) {
                tempSet.add(str);
                backTrack(str, end, bank, stepCount + 1, tempSet);
                // 撤销选择
                tempSet.remove(str);
            }
        }
    }
}
