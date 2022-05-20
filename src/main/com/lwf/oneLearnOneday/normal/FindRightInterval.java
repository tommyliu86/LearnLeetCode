package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-20 09:55
 */
public class FindRightInterval {
    class Solution {
        public int[] findRightInterval(int[][] intervals) {
            int n = intervals.length;
            int[] rtn=new int[n];

            for (int i = 0; i < n; i++) {

                rtn[i] = intervals[i][1];
                intervals[i][1]=i;
            }
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            for (int i = 0; i < n; i++) {
                int target =rtn[i];
                int half = half(intervals, 0, n - 1, target);
                if (intervals[ half][0]>=target){
                    rtn[i]=intervals[half][1];
                }else{
                    rtn[i]=-1;
                }

            }
            return rtn;
        }
        public int half(int[][] ends,int l,int r,int t){
            if (l>=r){
                return l;
            }
            int m=(l+r)/2;
            if (ends[m][0]==t){
                return m;
            }else  if (ends[m][0]>t){
                return half(ends,l,m,t);
            }else{
                return half(ends,m+1,r,t);
            }
        }
    }
}
