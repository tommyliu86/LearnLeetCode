package com.lwf.classic.two.tow;

/**
 * @author liuwenfei
 * @date 2023/4/15 11:45
 */
public class IsAlienSorted {
    class Solution {
        int[] orders=new int[26];
        public boolean isAlienSorted(String[] words, String order) {

            for (int i = 0; i < order.length(); i++) {
                orders[order.charAt(i)-'a']=i;
            }
            for (int i = 1; i < words.length; i++) {
                String pre = words[i - 1];
                String cur = words[i];
                if (!check(pre,cur)){
                    return false;
                }
            }
            return true;
        }
        public boolean check(String a,String b){
            for (int i = 0; i < a.length()&&i < b.length(); i++) {
                if (orders[ a.charAt(i)-'a']==orders[b.charAt(i)-'a']) {
                    continue;
                }
                return orders[ a.charAt(i)-'a']<orders[b.charAt(i)-'a'];
            }
            return a.length()<=b.length();
        }
    }
}
