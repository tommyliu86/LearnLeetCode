package com.lwf.learn.everyday.arith.first.d2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-27 13:49
 */
public class FindAnagrams {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int n = p.length();
            int[] chars=new int[26];
            for (int i = 0; i < p.length(); i++) {
                int pi = p.charAt(i) - 'a';
                chars[pi]++;
            }

            List<Integer> rtn=new ArrayList<>();

            int r=0;
            int l=0;

            int[] sub=new int[26];
            for (int i = n; i < s.length(); i++) {
                while (r<i){
                    int i1 = s.charAt(r) - 'a';
                    sub[i1]++;
                    r++;
                }
                while (r-l>n){
                    int i1 = s.charAt(l) - 'a';
                    sub[i1]--;
                    l++;
                }
                if (Arrays.equals(chars,sub)){
                    rtn.add(l);
                }
            }
            return rtn;
        }
    }
}
