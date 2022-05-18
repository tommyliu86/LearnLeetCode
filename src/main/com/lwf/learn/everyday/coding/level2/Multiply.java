package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-16 10:21
 */
public class Multiply {
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0")||num2.equals("0")){
                return "0";
            }
            int[] n1=new int[num1.length()];
            for (int i = 0; i < n1.length; i++) {
                n1[i]=num1.charAt(i)-'0';
            }
            int[] n2=new int[num2.length()];
            for (int i = 0; i < n2.length; i++) {
                n2[i]=num2.charAt(i)-'0';
            }

            int[] ints=new int[num2.length()+num1.length()];
            for (int i = n1.length - 1; i >= 0; i--) {
                int x = n1[i];
                int j=ints.length-1-(n1.length-1-i);
                int multi=0;
                for (int k = n2.length-1; k >= 0; k--) {
                    ints[j]+=x*n2[k]+multi;
                    multi=ints[j]/10;
                    ints[j]=ints[j]%10;
                    j--;
                }
                if (multi>0){
                    ints[j]=multi;
                }
            }
            StringBuilder builder = new StringBuilder();
            boolean start=false;
            for (int i = 0; i < ints.length; i++) {
                if (!start&& ints[i]==0){
                    continue;
                }
                start=true;
                builder.append(ints[i]);
            }
            return builder.toString();
        }
    }
}
