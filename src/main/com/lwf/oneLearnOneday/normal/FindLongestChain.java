package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

public class FindLongestChain {
        class Solution {
            public int findLongestChain(int[][] pairs) {
                Arrays.sort(pairs, (a, b) -> {
                        if (a[1]!=b[1]){

                            return Integer.compare(a[1],b[1]);
                        }else{
                            return  Integer.compare(a[0],b[0]);
                        }

                });
                int rtn=1;
                int[] post=pairs[pairs.length-1];
                for (int i = pairs.length - 1; i >= 0; i--) {
                    if (pairs[i][1]>post[0]&&pairs[i][0]>=post[0]) {
                        post=pairs[i];
                    }else{

                        if (pairs[i][1]<post[0]){
                            rtn++;
                            post=pairs[i];
                        }
                    }
                }
                return rtn;
            }
        }
}
