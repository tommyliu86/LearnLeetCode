package com.lwf.offer.two.tow;

/**
 * @author liuwenfei
 * @date 2023/3/30 9:09
 */
public class Divide {
    class Solution {
        public int divide(int a, int b) {
            if(a==0||b==1) return a;
            if (a==Integer.MIN_VALUE&&b==-1) return Integer.MAX_VALUE;
            //都转为负数，这样不用考虑符号问题，而且a=integer.min时无法转正数，因此使用负数来计算。
            boolean conv=false;
            if (a<0){
                conv=!conv;
            }else{
                a=-1*a;
            }
            if (b<0){
                conv=!conv;
            }else {
                b=-1*b;
            }
            int ans=0;
            while (a<=b){
                int bb=b;
                int i=1;
                while (bb>=a-bb){
                    bb+=bb;
                    i+=i;
                }
                a-=bb;
                ans+=i;
            }
            return ans*(conv?-1:1);
        }
    }
}
