package com.lwf.classic.two;

/**
 * 前缀树 
 * @author liuwenfei
 * @date 2023/9/15 9:08
 */
public class MagicDictionary {


    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {

    }

    TrNode root = new TrNode();

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            TrNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                int i1 = s.charAt(i) - 'a';
                if (cur.children[i1] == null) {
                    cur.children[i1] = new TrNode();
                }
                if (i == s.length() - 1)
                    cur.children[i1].isEnd = true;

                cur = cur.children[i1];
            }

        }
    }

    public boolean search(String searchWord) {
        int diff = search(searchWord,0,root,0);
        return diff==1;
    }

    private int search(String s, int i, TrNode cur,int diff) {
        if (i==s.length())return cur.isEnd? diff:2;

        int i1 = s.charAt(i) - 'a';
        if (diff==1){
            if (cur.children[i1]==null)
                return 2;
            else{
                int diffs = search(s, i + 1, cur.children[i1], diff);
                if (diffs==1)
                    return 1;

                return 2;
            }

        }else if (diff==0){

            for (int i2 = 0; i2 < cur.children.length; i2++) {
                if (cur.children[i2] != null) {
                    int diffs = search(s, i + 1, cur.children[i2], i1==i2?0:1);
                    if (diffs == 1) return 1;
                }
            }

        }

        return 2;
    }

    class TrNode {
        TrNode[] children = new TrNode[26];
        boolean isEnd = false;
    }
/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
}
