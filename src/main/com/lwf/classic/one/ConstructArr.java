package com.lwf.classic.one;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/2/7 15:10
 */
public class ConstructArr {
    class Solution {
        public int[] constructArr(int[] a) {
            int[] ans=new int[a.length];
            Arrays.fill(ans,1);
            for (int i = 1; i < ans.length; i++) {
                ans[i]=ans[i-1]*a[i-1];
            }
            int count=1;
            for (int i = ans.length - 2; i >= 0; i--) {
                count*=a[i+1];
                ans[i]*=count;
            }
            return ans;
        }
    }
}
