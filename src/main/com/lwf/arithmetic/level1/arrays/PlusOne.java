package com.lwf.arithmetic.level1.arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-09 16:56
 */
public class PlusOne {
    class Solution {
        public int[] plusOne(int[] digits) {
            int add=1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int newI = digits[i]+add;
                add=newI/10;
                digits[i]=newI%10;
                if (add==0){
                    break;
                }
            }
            if (add==1){
                int[] newRtn=new int[digits.length+1];
                newRtn[0]=add;
                for (int i = 1; i < newRtn.length; i++) {
                    newRtn[i]=digits[i-1];
                }
                return newRtn;
            }else{
                return digits;
            }
        }
    }
}
