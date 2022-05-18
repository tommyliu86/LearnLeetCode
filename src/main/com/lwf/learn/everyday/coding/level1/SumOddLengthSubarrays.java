package com.lwf.learn.everyday.coding.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-08 14:11
 */
public class SumOddLengthSubarrays {
    class Solution {
        public int sumOddLengthSubarrays(int[] arr) {
            int sum=0;
            int rtn=0;
            for (int i = 0; i < arr.length; i++) {
                if (i>0){
                    arr[i]+=arr[i-1];
                }
                for (int j = 0; j <= i; j++) {
                    if (((i-j+1)&1)==1){
                        if (j==0){
                            rtn+=arr[i];
                        }else{
                            rtn+=arr[i]-arr[j-1];
                        }
                    }
                }

            }
            return rtn;
        }
    }
}
