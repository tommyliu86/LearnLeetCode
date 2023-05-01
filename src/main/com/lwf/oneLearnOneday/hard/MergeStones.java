package com.lwf.oneLearnOneday.hard;

public class MergeStones {
    public static void main(String[] args) {
        System.out.println(  new Solution().mergeStones(new int[]{3,5,1,2,6},
        3));
    }
    static
    class Solution {
        public int mergeStones(int[] stones, int k) {
            int l = stones.length;
            if (l<k||(l-k)%(k-1)!=0) return -1;
            int[] sums=new int[stones.length+1];
            for (int i = 1; i < sums.length; i++) {
                sums[i]=sums[i-1]+stones[i-1];

            }
            int[][] dp=new int[l][l];

            //il 是可以组合的长度开始，因此从k开始到l表示遍历的长度
            for (int il = k; il <= l; il++) {

                for (int i = 0; i +il-1< l; i++) {
                    //i起点 il是当前长度，il++
                    //从i 到 il，通过遍历左右子串
                    //左i，右i+il-1
                    int sum=0;
                    if ((il-k)%(k-1)==0){
                        sum=sums[i+il]-sums[i];
                    }
                    int j = i+k-1;
                    dp[i][i+il-1]= sum+dp[i][j]+ (j+1>i+il-1?0:dp[j+1][i+il-1]);
                    while (++j<i+il){
                        dp[i][i+il-1]=Math.min(dp[i][i+il-1],sum+dp[i][j]+ (j+1>i+il-1?0:dp[j+1][i+il-1]));
                    }
                }

            }

            return dp[0][l-1];
        }
    }
}
