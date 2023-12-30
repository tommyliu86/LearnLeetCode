package com.lwf.classic.two;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀树  trie树  字典树 。
 *
 * @author liuwenfei
 * @date 2023/9/14 9:00
 */
public class Trie {
    class trNode {
        boolean isEnd = false;
        Character c;
        Map<Character, trNode> children = new HashMap<>();
    }

    trNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new trNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        trNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            trNode node = cur.children.getOrDefault(word.charAt(i), new trNode());

            node.c = word.charAt(i);
            if (i == word.length() - 1) node.isEnd = true;

            cur.children.putIfAbsent(node.c, node);
            cur = node;
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        trNode cur = searchNode(word);
        return cur != null && cur.isEnd;
    }

    private trNode searchNode(String word) {
        trNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children.containsKey(word.charAt(i))) {
                cur = cur.children.get(word.charAt(i));
            } else {
                return null;

            }
        }
        return cur;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        trNode trNode = searchNode(prefix);
        return trNode != null;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

