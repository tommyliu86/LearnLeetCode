package com.lwf.oneLearnOneday.normal;

public class MinOperationsMaxProfit {
    /**
     * 一次遍历，进行计算保存最大max
     */
    class Solution {
        public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
            int remain=0,max=Integer.MIN_VALUE,in=0,out=0,index=-1;
            for (int i = 0; remain>0|| i < customers.length; i++) {
                remain+= i<customers.length? customers[i]:0;
                out+=runningCost;
                in+=boardingCost*(remain>3?4:remain);
                remain-=remain>3?4:remain;
                if (max<in-out){
                    max=in-out;
                    index=i+1;
                }

            }
            return max<=0?-1:index;
        }
    }
}
