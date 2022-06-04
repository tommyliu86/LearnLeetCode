package com.lwf.learn.everyday.data.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-03 10:35
 */
public class PartitionLabels {
    class Solution {
        public List<Integer> partitionLabels(String s) {
            int[] far = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int i1 = s.charAt(i) - 'a';
                far[i1] = i;
            }
            List<Integer> rtn=new ArrayList<>();
            int left = 0;
            int right = 0;
            while (right < s.length()) {
                int i = s.charAt(left) - 'a';
                int max = far[i];
                int j=left+1;
                while (j<max){
                    int ji = s.charAt(j) - 'a';
                   max=Math.max( far[ji],max);
                   j++;
                }
                rtn.add(max-left+1);
                left=max+1;
                right=left;

            }
            return rtn;
        }
    }
}
