package com.lwf.learn.everyday.second.day5;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-17 09:46
 */
public class FindAnagrams {
    /**
     * 滑动窗口+双数组保存char的个数，借助数组是否相等进行确认是否异位词
     */
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            char[] chars = p.toCharArray();
            int[] ps=new int[128];
            for (char aChar : chars) {
                ps[aChar]++;
            }

            char[] sChar = s.toCharArray();
            int[] ss=new int[128];

            int left=0;
            int right=0;
            List<Integer> rtn=new ArrayList<>();

            while (right<sChar.length){
                char c = sChar[right];
                if (ps[c]==0) {
                    left=++right;
                    ss=new int[128];
                }else{
                    ss[c]++;
                    if (right-left+1>chars.length){
                        ss[sChar[left]]--;
                        left++;
                    }
                    if ((right-left+1)==chars.length){
                        if (Arrays.equals(ps,ss)){
                            rtn.add(left);
                        }
                    }
                    right++;
                }

            }
            return rtn;
        }
    }
}
