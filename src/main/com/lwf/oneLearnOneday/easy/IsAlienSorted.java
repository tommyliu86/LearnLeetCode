package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-17 09:14
 */
public class IsAlienSorted {
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            int[] orders=new int[26];
            for (int i = 0; i < order.length(); i++) {
                orders[order.charAt(i)-'a']=i;
            }
            for (int i = 1; i < words.length; i++) {
                if (compare(words[i-1], words[i],orders)>0){
                    return false;
                }
            }
            return true;
        }
        public int compare(String a,String b,int[] orders){
            char[] ca = a.toCharArray();
            char[] cb = b.toCharArray();
            for (int i = 0; i < ca.length&&i<cb.length; i++) {
                if (orders[ ca[i]-'a']>orders[cb[i]-'a']) {
                    return 1;
                }else if (orders[ca[i]-'a']<orders[cb[i]-'a']){
                    return -1;
                }
            }
            return  ca.length>cb.length?1:ca.length==cb.length?0:-1;
        }
    }
}
