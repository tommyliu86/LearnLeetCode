package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/9/24 19:45
 */
public class Decrypt {
    class Solution {
        public int[] decrypt(int[] code, int k) {
            if (k==0){
                Arrays.fill(code,0);
                return code;
            }
            int n = code.length;
            int[] sums=new int[n+1];
            for (int i = 1; i < sums.length; i++) {
                sums[i]=sums[i-1]+code[i-1];
            }
            for (int i = 0; i < code.length; i++) {
                int start=i;
                int cur=0;
                int end=i+k;
                if (k>0){

                    if (end<n){
                        cur=sums[end+1]-sums[i+1];
                    }else{
                        end%=n;
                        cur=sums[n]-sums[i+1]+sums[end+1];
                    }
                }else{
                    if (end>=0){
                        cur=sums[i]-sums[end];
                    }else{
                        end+=n;
                        cur=sums[i]+sums[n]-sums[end];
                    }
                }
                code[i]=cur;
            }
            return code;

        }
    }
}
