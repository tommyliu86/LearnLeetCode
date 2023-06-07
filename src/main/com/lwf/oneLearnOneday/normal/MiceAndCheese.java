package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuwenfei
 * @date 2023/6/7 9:27
 */
public class MiceAndCheese {
    /**
     *   这种排序会变慢 因此如果可以就少用 :Arrays.sort(indez, Comparator.comparing(a->reward2[a]-reward1[a]));
     */
    class Solution {
        public int miceAndCheese(int[] reward1, int[] reward2, int k) {
            Integer[] diffs=new Integer[reward1.length];
            for (int i = 0; i < diffs.length; i++) {
                diffs[i]=reward1[i]-reward2[i];
            }
            Arrays.sort(diffs);
            int sum= 0;
            for (int i = 0; i < reward2.length; i++) {
                sum+=reward2[i];
            }
            for (int i = 0; i < k; i++) {
                sum=sum+diffs[diffs.length-1-i];
            }
            return sum;
        }
    }
}
