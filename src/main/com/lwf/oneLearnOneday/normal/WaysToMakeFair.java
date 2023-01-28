package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/1/28 9:05
 */
public class WaysToMakeFair {
    /**
     * dp动态规划
     * 动态规划：当解题的思路可以归纳到跟随变量i变化的一个方程式时，就可以使用dp思路来进行求解
     */

    /**
     * 预处理+枚举遍历
     */
    class Solution {
        public int waysToMakeFair(int[] nums) {
            //存偶数count
            int[] counts=new int[nums.length+1];

            int allCount=0;
            for (int i = 0; i < nums.length; i++) {
                allCount+=nums[i];
                if ((i%2)==0){
                   counts[i+1]=(i>0? counts[i-1]:0)+nums[i];
                }

            }
            int ans=0;
            int subCount=0;
            for (int i = nums.length - 1; i > 0; i--) {
                if ((i%2)==0){
                    if (counts[i-1]+subCount==allCount-(counts[i-1]+subCount)-nums[i]) {
                        ans+=1;
                    }
                }else{
                    if (counts[i]+subCount==allCount-(counts[i]+subCount)-nums[i]) {
                        ans+=1;
                    }
                    subCount+=nums[i];
                }


            }
            if (subCount==allCount-subCount-nums[0]){
                ans++;
            }
            return ans;
        }
    }
}
