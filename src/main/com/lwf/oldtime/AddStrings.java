package com.lwf.oldtime;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * {@link 415.md}
 */
public class AddStrings {
    public static void main(String[] args) {
        char[] chars=new char[]{'a','b','c','d'};
        System.out.println(String.valueOf(chars, 1, 3));
    }
    public String addStrings(String num1, String num2) {
        if (null==num1||num1.length()==0) return num2;
        if (null==num2||num2.length()==0) return num1;
        char[] rtn=new char[Math.max(num1.length()+1,num2.length()+1)];
        int flag=0;
        for (int i = 0; i < rtn.length; i++) {
            int c1=num1.length()>i? num1.charAt(num1.length()-i-1)-'0':0;
            int c2=num2.length()>i? num2.charAt(num2.length()-i-1)-'0':0;
         rtn[rtn.length-1-i]=(char) ((c1+c2+flag)%10+'0');
         flag=(c1+c2+flag )/10;
        }
//        if (flag !=0) return String.format("%d%s",flag,String.valueOf(rtn));
        if (rtn[0]==0) return String.valueOf(rtn,1,rtn.length-1);
        return String.valueOf(rtn);
    }
}
