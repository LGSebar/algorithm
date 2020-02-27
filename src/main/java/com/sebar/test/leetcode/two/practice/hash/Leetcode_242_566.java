package com.sebar.test.leetcode.two.practice.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liguang
 */
public class Leetcode_242_566 {
    /**
     * 检查是不是字母异位词
     * 思路：将第一个字符串的每一个字符转化为char存入map中，
     * 第二个字符串每一个字符于它进行比较是否存在
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> stringCharMenu = new HashMap<>();

        char[] sCharArray = s.toCharArray();
        for (int i = 0; i < sCharArray.length; i++) {
            if (stringCharMenu.containsKey(sCharArray[i])) {
                stringCharMenu.put(sCharArray[i], stringCharMenu.get(sCharArray[i]) + 1);
            } else {
                stringCharMenu.put(sCharArray[i], 1);
            }
        }

        // 将第二个转化为字符串,存在则进行减一，不存在直接弹出false
        char[] tCharArray = t.toCharArray();
        for (int i = 0; i < tCharArray.length; i++) {
            if (!stringCharMenu.containsKey(tCharArray[i])) {
                return false;
            } else {
                Integer value = stringCharMenu.get(tCharArray[i]);
                if (value - 1 == 0) {
                    stringCharMenu.remove(tCharArray[i]);
                } else {
                    stringCharMenu.put(tCharArray[i], value - 1);
                }
            }
        }
        if (!stringCharMenu.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean solutionTwo(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // 初始化一个26字符一位数组
        int[] charMenu = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charMenu[s.charAt(i) - 'a']++;
            charMenu[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < charMenu.length; i++) {
            if (charMenu[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode_242_566 solution = new Leetcode_242_566();

        boolean anagram = solution.isAnagram("anagram", "nagaram");
        System.out.println(anagram);

        boolean anagram1 = solution.isAnagram("cat", "fat");
        System.out.println(anagram1);

        boolean anagram2 = solution.isAnagram("aacc", "ccac");
        System.out.println(anagram2);
    }
}
