package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.logging.SocketHandler;

/**
 * @author liuwenfei
 * @date 2023/3/22 18:34
 */
public class BestTeamScore {
    class Solution {
        public int bestTeamScore(int[] scores, int[] ages) {
            int[][] peops=new int[ages.length][2];
            for (int i = 0; i < peops.length; i++) {
                peops[i][0]=ages[i];
                peops[i][1]=scores[i];
            }
            Arrays.sort(peops,(a,b)->{
                if (a[1]==b[1]){
                    return Integer.compare(a[0], b[0]);
                }else{
                    return Integer.compare(a[1],b[1]);
                }
            });
            int curAge=0;
            int[] dp=new int[ages.length];
            for (int i = 0; i < peops.length; i++) {
                for (int j = i-1; j >= 0; j--) {
                    //年龄大于j，则可以直接接到j后面
                    if (peops[i][0]>=peops[j][0]){
                        dp[i]=Math.max(dp[i],dp[j]);
                    }
                }
                dp[i]+=peops[i][1];
                curAge=Math.max(curAge,dp[i]);
            }
            return curAge;

        }
    }
}
