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
    static Map<String, String> phoneCharMap = new HashMap<>();
    List<String> resList = new ArrayList<>();

    Leetcode_17_566() {
        phoneCharMap.put("2", "abc");
        phoneCharMap.put("3", "def");
        phoneCharMap.put("4", "ghi");
        phoneCharMap.put("5", "jkl");
        phoneCharMap.put("6", "mno");
        phoneCharMap.put("7", "pqrs");
        phoneCharMap.put("8", "tuv");
        phoneCharMap.put("9", "wxyz");
    }

    public static void main(String[] args) {
        Leetcode_17_566 code=new Leetcode_17_566();
        List<String> stringList = code.letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backTrack(digits, "");
        }
        return resList;
    }

    /**
     * 当前操作的字符数字
     *
     * @param digits
     * @param nowChar
     */
    private void backTrack(String digits, String nowChar) {
        if (digits.length() == 0) {
            resList.add(nowChar);
            return;
        }
        // 获取第一个数字
        String substringChar = digits.substring(0, 1);
        // 字符获取
        String charString = phoneCharMap.get(substringChar);
        for (int i = 0; i < charString.length(); i++) {
            String letter = phoneCharMap.get(substringChar).substring(i, i + 1);
            backTrack(digits.substring(1), nowChar + letter);
        }
    }
}
