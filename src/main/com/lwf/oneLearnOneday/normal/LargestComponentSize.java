package com.lwf.oneLearnOneday.normal;

import java.util.*;

public class LargestComponentSize {
    public static void main(String[] args) {
        System.out.println(new Solution().f(10000));
    }
 static    class Solution {
        public int largestComponentSize(int[] nums) {
            Map<Integer,List<Integer>> indexes=new HashMap<>();

            return 0;
        }
        public int f(int x){
            int[] ints=new int[x+1];
            int rtn=0;
            for (int i = 2; i < ints.length; i++) {
                if (ints[i]==0){
                    rtn++;
                    for (int j = 2; j*i < ints.length; j++) {
                        ints[i*j]=1;
                    }
                }
            }
            return rtn;
        }
    }
}
