package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuwenfei
 * @date 2022/11/15 9:03
 */
public class MaximumUnits {
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes,(a,b)-> Integer.compare(b[1],a[1]));
            int ans=0;
            int i=0;
            while (i<boxTypes.length&& truckSize>0){
                int[] boxType = boxTypes[i];
                if (boxType[0]<=truckSize){
                    ans+=boxType[0]*boxType[1];
                }else{
                    ans+=truckSize*boxType[1];
                }
                truckSize-=boxType[0];
                i++;
            }
            return ans;
        }
    }
}
