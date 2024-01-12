package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 2707. 字符串中的额外字符
 * @author liuwenfei
 * @date 2024/1/9 8:56
 *
 *
 */
public class MinExtraChar {
    //dic构建成一个字典数，倒叙排列，然后进行dp
    class Solution {
        public int minExtraChar(String s, String[] dictionary) {
            //构建倒序的dic字典树
            Tree root = new Tree();
            for (String s1 : dictionary) {
                buildTree(root,s1);
            }
            //dp数组
            int[] len=new int[s.length()+1];
            for (int i = 1; i < len.length; i++) {
                //初始化dp中的i位置，为1+len[i-1]，假设的是当前位置没有字典树，因此会是前一个位置+当前位置的1个
                len[i]=1+len[i-1];
                List<Integer> allMatch = getAllMatch(root, s, i - 1);
                for (Integer match : allMatch) {
                    //匹配到的字典树长度进行dp计算
                    len[i]=Math.min(len[i],len[i-match]);
                }
            }
            return len[s.length()];
        }
        public List<Integer> getAllMatch(Tree root, String s, int i){
            List<Integer> ans=new ArrayList<>();
            Tree cursor=root;
            int index=0;
            while (i>=0&&cursor.chars[ index=s.charAt(i)-'a']!=null){
                cursor=cursor.chars[index];
                if (cursor.isEnd==1){
                    ans.add(cursor.depth);
                }
                i--;
            }
            return ans;
        }
        public void buildTree(Tree root,String str){
            Tree cursor=root;
            for (int i = str.length()-1; i >= 0; i--) {
                int i1 = str.charAt(i) - 'a';
                if (cursor.chars[i1]==null) {
                    cursor.chars[i1]=new Tree();
                    cursor.chars[i1].isEnd=0;
                    cursor.chars[i1].depth=cursor.depth+1;
                }
                cursor=cursor.chars[i1];
                if (i==0){
                    cursor.isEnd=1;
                }
            }
        }
        class Tree{
            Tree[] chars=new Tree[26];
            int isEnd;
            int depth;
        }
    }
}
