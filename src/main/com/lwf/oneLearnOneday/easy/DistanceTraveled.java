package com.lwf.oneLearnOneday.easy;

/**
 * 2739. 总行驶距离
 *
 * @author: liuwenfei
 * @date: 2024/4/28-19:52
 */
public class DistanceTraveled {
    class Solution {
        public int distanceTraveled(int mainTank, int additionalTank) {
           int ans=0;
           while (mainTank>=5&&additionalTank>0){
               ans+=5;
               mainTank-=5;
               mainTank++;
               additionalTank--;
           }
           return (ans +mainTank )*10;
        }
    }
}
