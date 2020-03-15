package com.sebar.test.leetcode.five.practice;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * 1143. 最长公共子序列
 */
public class Leetcode_1143_566 {
    /**
     * 求最长子序列
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestcommonSubSequence(String text1, String text2) {
        //构建一个中间数值存储的二位数组,+1是为了考虑空字符串的位置
        int[][] temp = new int[text1.length() + 1][text2.length() + 1];
        // 因为第一个的位置是空字符串的位置,采用默认值为0即可
        // 如果text1的字符==text2的字符，则用前一个数+1，
        // 如果text1的字符!=text2的字符，则取其对角线上的两个数的最大值
        for (int i = 1; i < temp.length; i++) {
            for (int j = 1; j < temp[0].length; j++) {
                temp[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1) ? temp[i - 1][j - 1] + 1 : Math.max(temp[i - 1][j], temp[i][j - 1]);
            }
        }
        return temp[temp.length - 1][temp[0].length - 1];
    }

    public static void main(String[] args) {
        Leetcode_1143_566 code = new Leetcode_1143_566();
        int i = code.longestcommonSubSequence("abcde", "ace");
        System.out.println(i);
    }
}