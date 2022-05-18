package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-15 18:54
 */
public class PlusOne {
    class Solution {
        public int[] plusOne(int[] digits) {
            int plus=1;
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i]+=plus;

                plus=digits[i]/10;
                digits[i]%=10;

            }
            if (plus==1){
                int[] rtn=new int[digits.length+1];
                rtn[0]=plus;
                for (int i = 1; i < rtn.length; i++) {
                    rtn[i]= digits[i-1];
                }
                return rtn;
            }else{
                return digits;
            }

        }
    }
}
