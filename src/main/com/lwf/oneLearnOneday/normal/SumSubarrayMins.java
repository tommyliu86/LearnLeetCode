package com.lwf.oneLearnOneday.normal;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2022/10/28 8:45
 */
public class SumSubarrayMins {

    /**
     * 123 2 4 3 2 1
     * 找到单调增加的最小值的index
     */
    class Solution {
        public int sumSubarrayMins(int[] arr) {
            int mod=1000000007;
            Stack<Integer> indexes=new Stack<>();
            long[] sums=new long[arr.length];
            long ans=0;
            for (int i = 0; i < arr.length; i++) {
                int cur = arr[i];
                while (!indexes.isEmpty()&&arr[indexes.peek()]>=cur){
                    indexes.pop();
                }
                if (!indexes.isEmpty()) {
                 sums[i]=  sums[ indexes.peek()]+(i-indexes.peek())*cur;
                }else{
                    sums[i]=(i+1)*cur;
                }
                sums[i]%=mod;
                indexes.push(i);
                ans+=sums[i];
                ans%=mod;
            }
            return (int) ans;
        }
    }
}
