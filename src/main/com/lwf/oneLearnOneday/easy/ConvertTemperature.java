package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/3/21 9:06
 */
public class ConvertTemperature {
    class Solution {
        public double[] convertTemperature(double celsius) {
            double[] ans=new double[2];
            ans[0]=celsius+273.15d;
            ans[1]=celsius*1.8d+32d;
            return ans;
        }
    }
}
