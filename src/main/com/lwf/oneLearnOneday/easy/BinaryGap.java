package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-24 08:45
 */
public class BinaryGap {
    class Solution {
        public int binaryGap(int n) {
            int max=0;
            int pre=-1;
            int index=0;
            while (n!=0){
                if ((n&1)==1){
                    if (pre!=-1) {
                        max=Math.max(index-pre,max);
                    }
                    pre=index;
                }
                n>>=1;
                index++;
            }
            return max;
        }
    }
}
