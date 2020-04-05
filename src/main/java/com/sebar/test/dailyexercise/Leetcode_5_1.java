package com.sebar.test.dailyexercise;

/**
 * @Author LG-QCY
 * @Date :2020/3/29 22:05
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 5. 最长回文子串 回文串正读和反读要求一样
 */
public class Leetcode_5_1 {
    /**
     * 采用字典记录
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        int len = s.length();
        int[][] arr = new int[len][len];
        int maxLen = 0;
        int maxEnd = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > maxLen) {
                    int before = len - 1 - j;
                    if (before + arr[i][j] - 1 == i) {
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    public static void main(String[] args) {
        Leetcode_5_1 coco = new Leetcode_5_1();
        String s = coco.longestPalindrome("ac");
        System.out.println(s);
    }
}
