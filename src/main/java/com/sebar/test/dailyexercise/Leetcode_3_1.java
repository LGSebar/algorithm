package com.sebar.test.dailyexercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author LG-QCY
 * @Date :2020/3/27 21:21
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 3. 无重复字符的最长子串
 */
public class Leetcode_3_1 {
    /**
     * 双指针,遇到相同的则统计中间的差距，此时第一根指针前移动，第二根指针不动，第二根指针只有在不同的时候才移动
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> map = new HashSet<>();
        map.add(s.charAt(0));
        int maxGap = 0, pointA = 0, pointB = 1;
        while (pointA < s.length() && pointB < s.length()) {
            if (!map.contains(s.charAt(pointB))) {
                // 统计中间的差距
                maxGap = Math.max(maxGap, (pointB - pointA));
                // 移动pointB指针
                map.add(s.charAt(pointB++));
            } else {
                map.remove(s.charAt(pointA++));
            }
        }
        return maxGap;
    }

    public int solution2(String s) {
        int maxGap = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, pointA = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                pointA = Math.max(map.get(s.charAt(j)), pointA);
            }
            maxGap = Math.max(maxGap, (j - pointA) + 1);
            map.put(s.charAt(j), j + 1);
        }
        return maxGap;
    }

    public int solution3(String s) {
        int maxGap = 0;
        int[] indexChar = new int[126];

        for (int j = 0, pointA = 0; j < s.length(); j++) {
            pointA = Math.max(indexChar[s.charAt(j)], pointA);
            maxGap = Math.max(maxGap, j - pointA + 1);
            indexChar[s.charAt(j)] = j + 1;
        }
        return maxGap;
    }

    public static void main(String[] args) {
        Leetcode_3_1 coco = new Leetcode_3_1();
//        int i = coco.lengthOfLongestSubstring("abcabcbb");
        int i = coco.solution2("abcabcbb");
        System.out.println(i);
    }
}
