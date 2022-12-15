package com.lwf.oneLearnOneday.normal;

import java.util.Set;

/**
 * @author liuwenfei
 * @date 2022/12/9 9:28
 */
public class FindMaximumXOR {
    class Solution {
        public int findMaximumXOR(int[] nums) {
            Set<Integer>[] indexes=new Set[32];
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int j=0;
                while (num!=0){
                    int i1 = num / 2;
                    num>>=1;
                    if (i1==1){
                        indexes[j].add(i);
                    }
                    j++;
                }

            }
            return 0;

        }
    }
}
