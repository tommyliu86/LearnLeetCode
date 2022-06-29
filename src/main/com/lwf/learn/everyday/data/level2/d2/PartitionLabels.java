package com.lwf.learn.everyday.data.level2.d2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-28 15:53
 */
public class PartitionLabels {
    class Solution {
        public List<Integer> partitionLabels(String s) {
            int[] maxI=new int[26];
            for (int i = 0; i < s.length(); i++) {
                int j = s.charAt(i) - 'a';
                maxI[j]=i;
            }
            List<Integer> rtn=new ArrayList<>();
            int left=0;
            int right=0;
            while (right<s.length()){
               int max= maxI[ s.charAt(right)-'a'];
               while (right<max){
                   max=Math.max(max,maxI[ s.charAt(right)-'a']);
                   right++;
               }
               rtn.add(right-left+1);
               left=++right;
            }
            return rtn;
        }
    }
}
