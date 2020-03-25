package com.sebar.test.reviewleetcode.three;

import javafx.util.Pair;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder/description/
 * 127. 单词接龙
 */
public class WordLadder_127_1 {
    /**
     * bfs
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int beginLength = beginWord.length();
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < beginLength; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, beginLength);

                ArrayList<String> list = allComboDict.getOrDefault(newWord, new ArrayList<>());
                list.add(word);
                allComboDict.put(newWord, list);
            }
        }

        // 开始进行匹配
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        // 访问记录
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            Integer level = node.getValue();

            for (int i = 0; i < beginLength; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, beginLength);
                for (String s : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if (s.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(s)) {
                        visited.put(newWord, true);
                        queue.add(new Pair<>(s, level + 1));
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 双向bfs
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> begin = new HashSet<>();
        begin.add(beginWord);

        HashSet<String> end = new HashSet<>();
        end.add(endWord);

        HashSet<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }

        deBfs(begin, end, words, 2);
        return 0;
    }

    private int deBfs(HashSet<String> begin, HashSet<String> end, HashSet<String> words, int depth) {
        if (begin.size() > end.size()) {
            // 对调
            return deBfs(end, begin, words, depth);
        }

        words.removeAll(begin);
        HashSet<String> next = new HashSet<>();

        for (String str : begin) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    chars[i] = j;
                    String word = chars.toString();
                    if (words.contains(word)) {
                        if (end.equals(word)) {
                            return depth;
                        }
                        next.add(word);
                    }
                }
                chars[i] = temp;
            }
        }
        if (begin.isEmpty()) {
            return 0;
        }
        return deBfs(next, end, words, depth + 1);
    }
}
