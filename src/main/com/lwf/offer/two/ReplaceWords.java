package com.lwf.offer.two;

import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/9/15 8:37
 */
public class ReplaceWords {
    /**
     * 字典树
     */
    class Solution {
        public String replaceWords(List<String> dictionary, String sentence) {
            TrNode root = new TrNode();
            for (String s : dictionary) {
                root.add(s, root);
            }
            StringBuilder stringBuilder = new StringBuilder();

            for (String s : sentence.split(" ")) {
                stringBuilder.append(root.find(s, root)).append(" ");
            }
            return stringBuilder.substring(0, stringBuilder.length() - 1);

        }

        class TrNode {
            TrNode[] children = new TrNode[26];
            char c;
            boolean isWord = false;

            public void add(String str, TrNode root) {
                for (int i = 0; i < str.length(); i++) {
                    int i1 = str.charAt(i) - 'a';
                    if (root.children[i1] == null) {
                        root.children[i1] = new TrNode();
                    }
                    root.children[i1].c = str.charAt(i);

                    if (i == str.length() - 1) root.children[i1].isWord = true;

                    root = root.children[i1];
                }

            }

            public String find(String str, TrNode root) {

                for (int i = 0; i < str.length(); i++) {
                    int i1 = str.charAt(i) - 'a';
                    if (root.children[i1] == null) {
                        return str;
                    }
                    if (root.children[i1].isWord) {
                        return str.substring(0, i + 1);
                    } else {
                        root = root.children[i1];
                    }

                }
                return str;

            }
        }
    }

}
