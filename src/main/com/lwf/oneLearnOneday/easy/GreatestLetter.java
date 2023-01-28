package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/1/28 10:36
 */
public class GreatestLetter {
    class Solution {
        public String greatestLetter(String s) {
        int[] marks=new int[26];
        int[] markb=new int[26];
        char ans=(char)0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                char bc=Character.toUpperCase(c);
                if (ans>=bc){
                    continue;
                }
                if (Character.isUpperCase(c)&&marks[c-'A']==1) {
                    ans= ans>c?ans:c;
                }
                if (!Character.isUpperCase(c)&&markb[c-'a']==1){
                    ans= ans> bc?ans:bc;
                }
                if (Character.isUpperCase(c)){
                   markb[c-'A']=1;
                }else{
                    marks[c-'a']=1;
                }
                if (ans=='Z'){
                    return String.valueOf( ans);
                }
            }
            return ans==0?"":String.valueOf(ans);
        }
    }
}
