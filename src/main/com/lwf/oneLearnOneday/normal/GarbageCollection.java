package com.lwf.oneLearnOneday.normal;

/**
 * @author: liuwenfei
 * @date: 2024/5/11-8:31
 */
public class GarbageCollection {
    /**
     * 遍历，
     */
    class Solution {
        public int garbageCollection(String[] garbage, int[] travel) {
            int m=0,p=0,g=0;
            int ans=0;
            int[] preSum=new int[garbage.length];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i]=preSum[i-1]+travel[i-1];
            }
            for (int i = 0; i < garbage.length; i++) {
                String gar = garbage[i];
                char[] chars = gar.toCharArray();
                int m1=0,p1=0,g1=0;
                for (int j = 0; j < chars.length; j++) {
                    m1 += (chars[j] == 'M' ? 1 : 0);
                    p1 += (chars[j] == 'P' ? 1 : 0);
                    g1 += (chars[j] == 'G' ? 1 : 0);
                }
                if (m1>0){
                    ans+=m1+ preSum[ i]-preSum[m];
                    m=i;
                }
                if (p1>0){
                    ans+=p1+ preSum[ i]-preSum[p];
                    p=i;
                }
                if (g1>0){
                    ans+=g1+ preSum[ i]-preSum[g];
                    g=i;
                }
            }
            return ans;
        }
    }
}
