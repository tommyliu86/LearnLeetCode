package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/1/28 11:27
 */
public class CalculateTax {
    class Solution {
        public double calculateTax(int[][] brackets, int income) {
            long sum=0l;
            int i=0;
            int remain=income;
            int pre=0;
            while (remain>0){
                remain=income-brackets[i][0];
                if (remain>0){
                    sum+=(brackets[i][0]-pre)*brackets[i][1];
                }else{
                    sum+=(income-pre)*brackets[i][1];
                }
                pre=brackets[i][0];
                i++;
            }
            return (double)sum/100;
        }
    }
}
