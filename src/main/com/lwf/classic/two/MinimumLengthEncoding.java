package com.lwf.classic.two;

public class MinimumLengthEncoding {
    /**
     * 前缀树。
     * https://leetcode.cn/problems/iSwD2y/description/?envType=study-plan-v2&envId=coding-interviews-special
     */
    class Solution {
        public int minimumLengthEncoding(String[] words) {
            Node root=new Node();
            for (String word : words) {
                root.add(word);
            }
            getLength(root,0);
            return sum;
        }
        int sum=0;
        public void getLength(Node node,int deep){
            if (node.count==0){
                sum+=deep+1;
            }
            for (Node child : node.children) {
                if (child!=null){
                    getLength(child,deep+1);
                }
            }
        }

        class Node {
            Node[] children = new Node[26];
            int count;
            void add(String s){
                Node cur=this;
                for (int i = s.length() - 1; i >= 0; i--) {
                    char ch = s.charAt(i);
                    if (cur.children[ch-'a']==null) {
                        cur.children[ch-'a']=new Node();
                        cur.count++;
                    }
                    cur=cur.children[ch-'a'];
                }
            }
        }
    }
}
