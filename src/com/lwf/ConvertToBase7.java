package com.lwf;

/**
 * author Administrator
 * time 2019-08-20-23:42
 * {@link 504.md}
 */
public class ConvertToBase7 {
    public String convertToBase7(int num) {
        if (num==0) return "0";
        StringBuilder builder=new StringBuilder();
        int n=Math.abs( num);
        while (n!=0){
            builder.append(n%7);
            n/=7;
        }
        if (num<0)
        builder.append("-");
        return builder.reverse().toString();
    }
}
