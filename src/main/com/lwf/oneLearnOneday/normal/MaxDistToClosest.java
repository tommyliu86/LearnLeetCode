package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/8/22 18:45
 */
public class MaxDistToClosest {
    class Solution {
        public int maxDistToClosest(int[] seats) {
            int max=0;
            int i=0,j=0;
            while (j<seats.length){
                while (j<seats.length&&seats[j]==0){
                    j++;
                }

                if (i==0||j==seats.length){
                    max=Math.max(j-i,max);
                }else{
                    max=Math.max(max,(j-i+1)/2);
                }
                i=j++;
            }
            return max;
        }
    }
}
