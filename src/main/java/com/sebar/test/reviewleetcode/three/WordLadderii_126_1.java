package com.sebar.test.reviewleetcode.three;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder-ii/description/
 * 126. 单词接龙 II
 */
public class WordLadderii_126_1 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> resList = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return resList;
        }
        bfs(beginWord, endWord, wordList, resList);
        return resList;
    }

    private void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> resList) {
        Queue<List<String>> queue = new LinkedList<>();

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        queue.offer(path);

        boolean isFound = false;
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> p = queue.poll();
                String lastWord = p.get(p.size() - 1);
                List<String> neighbors = getNeighbors(lastWord, dict);

                for (String neighbor : neighbors) {
                    // 到达结束单词
                    if (!visited.contains(neighbor)) {
                        if (neighbor.equals(endWord)) {
                            isFound = true;
                            p.add(neighbor);
                            resList.add(new ArrayList<>(p));
                            p.remove(p.size() - 1);
                        }
                        //加入当前单词
                        p.add(neighbor);
                        queue.offer(new ArrayList<>(p));
                        p.remove(p.size() - 1);
                        subVisited.add(neighbor);
                    }
                }
            }
            visited.addAll(subVisited);
            if (isFound) {
                break;
            }
        }

    }

    /**
     * 获取可以替换的单词
     *
     * @param lastWord
     * @param dict
     * @return
     */
    private List<String> getNeighbors(String lastWord, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char[] chars = lastWord.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ch) {
                    continue;
                }
                char oldChar = chars[i];
                // 替换字符
                chars[i] = ch;
                if (dict.contains(String.valueOf(chars))) {
                    res.add(String.valueOf(chars));
                }
                // 还原
                chars[i] = oldChar;
            }
        }
        return res;
    }
}
