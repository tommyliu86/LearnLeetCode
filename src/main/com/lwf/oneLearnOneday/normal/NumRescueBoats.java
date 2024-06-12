package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * 881. 救生艇
 *
 * @author: liuwenfei
 * @date: 2024/6/12-9:06
 */
public class NumRescueBoats {
    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int ans=0;
            int i=0,j=people.length;
            while (i<=j){
                if (i!=j&& people[j]+people[i]>limit){
                    j--;
                }else{
                    j--;
                    i++;
                }
                ans++;
            }
            return ans;
        }
    }
}
