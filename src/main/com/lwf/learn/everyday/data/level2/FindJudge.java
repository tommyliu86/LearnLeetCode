package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-13 14:28
 */
public class FindJudge {
    class Solution {
        public int findJudge(int n, int[][] trust) {
            int[] out=new int[n+1]; //信任别人
            int[] in=new int[n+1]; //被别人信任
            for (int i = 0; i < trust.length; i++) {
                int[] ints = trust[i];
                out[ints[0]]++;
                in[ints[1]]++;
            }
            int j=0;
            for (int i = 0; i < in.length; i++) {
                if (in[i]==n-1&&out[i]==0) {
                    j=i;
                }
            }
            return j;
        }
    }
}
