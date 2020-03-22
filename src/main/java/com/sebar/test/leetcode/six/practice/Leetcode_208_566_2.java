package com.sebar.test.leetcode.six.practice;

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/#/description
 * 208. 实现 Trie (前缀树) 字典树
 */
public class Leetcode_208_566_2 {
    class Trie {
        private TrieNode root;

        /**
         * Initialize your data structure here
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * insert a word into the trie
         */
        public void insert(String word) {
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!temp.containsKey(c)) {
                    temp.put(c, new TrieNode());
                }
                temp = temp.get(c);
            }
            // 结束符
            temp.setEnd();
        }

        /**
         * Returns if the word is in the trie
         */
        public boolean search(String word) {
            TrieNode trieNode = searchPrefix(word);
            return trieNode != null && trieNode.isEnd();
        }

        /**
         * search a prefix or whole key in trie and returns the node where search end
         */
        public TrieNode searchPrefix(String word) {
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (temp.containsKey(c)) {
                    temp = temp.get(c);
                } else {
                    return null;
                }
            }
            return temp;

        }

        /**
         * Return if there is any word in the trie that starts with the given prefix
         */
        public boolean startsWith(String prefix) {
            TrieNode trieNode = searchPrefix(prefix);
            return trieNode != null;
        }


    }

    class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        private TrieNode() {
            this.links = new TrieNode[R];
        }

        /**
         * 是否包含字符
         *
         * @param ch
         * @return
         */
        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }


    }
}
