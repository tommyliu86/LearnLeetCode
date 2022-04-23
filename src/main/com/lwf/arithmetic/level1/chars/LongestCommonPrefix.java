package com.lwf.arithmetic.level1.chars;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-12 09:05
 */
public class LongestCommonPrefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
           return pre(strs,0,strs.length-1);
        }
        private String pre(String[] strs,int left,int right){
            if (left==right){
                return strs[left];
            }
            int mid=(left+right)/2;
            String leftStr=pre(strs,left,mid);
            if (leftStr==""){
                return "";
            }
            String rightStr=pre(strs,mid+1,right);
            if (rightStr==""){
                return "";
            }
            return pre(leftStr,rightStr);
        }
        private  String pre(String a,String b){
            StringBuilder builder=new StringBuilder();
            int ai=0;
            int bi=0;
            while (ai<a.length()&&bi<b.length()){
                if (a.charAt(ai)==b.charAt(bi)) {
                    builder.append(a.charAt(ai));
                    ai++;
                    bi++;
                }else{
                    break;
                }

            }
            return builder.toString();
        }
    }
}
