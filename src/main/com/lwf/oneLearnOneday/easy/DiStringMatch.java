package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-09 09:17
 */
public class DiStringMatch {
    class Solution {
        public int[] diStringMatch(String s) {
            int[] rtn=new int[s.length()+1];
            int l=0;
            int b=s.length();
            for (int i = 0; i < rtn.length-1; i++) {
                if (s.charAt(i)=='I'){
                    rtn[i]=l++;
                }else{
                    rtn[i]=b--;
                }
            }
            rtn[rtn.length-1]=b;
            return rtn;
        }
    }
}
