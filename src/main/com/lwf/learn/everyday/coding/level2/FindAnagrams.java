package com.lwf.learn.everyday.coding.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-24 11:26
 */
public class FindAnagrams {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int[] ps=new int[26];

            int pl = p.length();
            for (int i = 0; i < pl; i++) {
                ps[p.charAt(i)-'a']++;

            }
            int left=0;
            int[] ss=new int[26];
            List<Integer> rtn=new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                int i1 = s.charAt(i) - 'a';
                ss[i1]++;
                if (i-left+1>pl){
                    ss[s.charAt( left)-'a']--;
                    left++;
                }
                if (i-left+1==pl){
                    if (equal(ps,ss)){
                        rtn.add(left);
                    }
                }
            }
            return rtn;
        }
        public boolean equal(int[] ps,int[] ss){
            for (int i = 0; i < ps.length; i++) {
                if (ps[i]!=ss[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
