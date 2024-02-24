package com.lwf.oneLearnOneday.normal;

public class MinOperationsMaxProfit {
    /**
     * 直接模拟，使用i表示转动次数，记录每次可以上去的人数
     */
    class Solution {
        public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
            int persons=0,i=0,j=0;
            int costs=0;
            int maxC=Integer.MIN_VALUE,maxI=-1;
            while (persons!=0||j<customers.length){
                persons+=j<customers.length? customers[j++]:0;
                costs+=Math.min(persons,4)*boardingCost-runningCost;
                persons-=Math.min(persons,4);
                i++;
                if (costs>maxC){
                    maxI=i;
                    maxC=costs;
                }
            }
            if (maxC>0){
                return maxI;
            }else{
                return -1;
            }
        }
    }
    /**
     * 一次遍历，进行计算保存最大max
     */
    class Solution1 {
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
