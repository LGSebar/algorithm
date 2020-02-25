package com.sebar.test.leetcode.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_17_566 {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     */
    static Map<Integer, String> phoneCharMap = new HashMap<>();

    Leetcode_17_566() {
        phoneCharMap.put(2, "abc");
        phoneCharMap.put(3, "def");
        phoneCharMap.put(4, "ghi");
        phoneCharMap.put(5, "jkl");
        phoneCharMap.put(6, "mno");
        phoneCharMap.put(7, "pqrs");
        phoneCharMap.put(8, "tuv");
        phoneCharMap.put(9, "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> resList = new ArrayList<>();

        return resList;
    }
}
