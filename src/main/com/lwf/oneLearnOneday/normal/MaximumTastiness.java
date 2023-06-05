package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/6/1 10:54
 */
public class MaximumTastiness {

    class Solution {
        //[1,2,5,8,13,21]
        public int maximumTastiness(int[] price, int k) {
            int l = price.length;
            Arrays.sort(price);
            int min=price[0];
            int max=price[l-1];
            if (k==2||max==min) return max-min;
            int step_max=(max-min+k-2)/(k-1);
            int step_min=0;
            while (step_min<step_max){
                int m=(step_max+step_min)/2;
                if (check(price,m,k)){
                    step_min=m+1;
                }else{
                    step_max=m;
                }
            }
            return step_max-1;
        }
        public boolean check(int[] price,int step,int k){
            int count=1;
            int pre=0, cur=1;
            while (cur<price.length&&count<k){
                if (price[cur]-price[pre]>=step){
                    count++;
                    pre=cur;
                }
                cur++;
            }
            return count>=k;
        }
    }
}
