package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA. User: liuwenfei14 Date: 2019-11-25 Time: 09:33
 */
public class Trie {
    public boolean endpoint = false;
    public Map<Character, Trie> children = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (null == word || word.length() == 0) return;
        char[] chars = word.toCharArray();
        insert(chars, 0, this);

    }

    private void insert(char[] chars, int index, Trie curTrie) {
        if (index >= chars.length) {
            curTrie.endpoint=true;
            return;
        }

        if (!curTrie.children.containsKey(chars[index])) {

            curTrie.children.put(chars[index], new Trie());
        }
        insert(chars, index + 1, curTrie.children.get(chars[index]));
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (null == word || word.length() == 0) return false;
        return search(word.toCharArray(), 0, this, false);
    }

    private boolean search(char[] chars, int index, Trie curTrie, boolean forPrefix) {
        if (index >= chars.length) {
            if (forPrefix) {
                return true;
            } else {
                return curTrie.endpoint;
            }
        }
        if (curTrie.children.containsKey(chars[index])) {

            return search(chars, index + 1, curTrie.children.get(chars[index]), forPrefix);
        } else {
            return false;
        }
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return search(prefix.toCharArray(), 0, this, true);
    }


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
