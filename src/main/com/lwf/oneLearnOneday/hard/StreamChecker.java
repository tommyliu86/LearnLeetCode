package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author liuwenfei
 * @date 2023/3/24 8:52
 */
public class StreamChecker {
    /**
     * 字典树
     * 构建字典树，并保存输入的数据流chars，每次查找字典树即可
     */

    TreeSet root;

    private void add(String str,int i,TreeSet treeSet){

        char cur = str.charAt(i);
        TreeSet child = treeSet.children[cur - 'a'];
        if (child==null) {
            child=new TreeSet();
            child.aChar=cur;
            treeSet.children[cur-'a']=child;
        }
        if (i==0) {
            child.isEnd=true;
            return;
        }
        add(str,i-1,child);
    }
    private boolean isOk(int i,TreeSet treeSet){
        if (i<0) return false;
        if (treeSet==null||treeSet.children[letters.get(i) - 'a']==null) {
            return false;
        }
        TreeSet child = treeSet.children[letters.get(i) - 'a'];
        if (child.isEnd==true) {
            return true;
        }else{
            return isOk(i-1,child);
        }
    }
    public StreamChecker(String[] words) {
        root = new TreeSet();
        for (int i = 0; i < words.length; i++) {
            add(words[i],words[i].length()-1,root);
        }
    }
    List<Character> letters=new ArrayList<>();
    public boolean query(char letter) {
        letters.add(letter);
        return isOk(letters.size()-1,root);
    }

    static class TreeSet {
        char aChar;
        boolean isEnd=false;
        TreeSet[] children=new TreeSet[26];

    }

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
}
