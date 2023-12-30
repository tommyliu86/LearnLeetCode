package com.lwf.classic.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/2/7 15:51
 */
public class FindContinuousSequence {
    /**
     * 双指针遍历
     */
    class Solution {
        public int[][] findContinuousSequence(int target) {
            if (target<3) return new int[0][0];
            List<int[]> list=new ArrayList<>();
            int l=1;
            int r=1;

            int sum=1;
            while (r<=(target/2)+1){
                while (sum<target){
                    sum+=++r;
                }
                while (sum>target){
                    sum-=l++;
                }
                if (sum==target){
                    int[] ints=new int[r-l+1];
                    for (int i = 0; i <ints.length; i++) {
                        ints[i]=l+i;
                    }
                    list.add(ints);
                    sum+=++r;
                }
            }
            return list.toArray(new int[list.size()][]);

        }
    }
}
