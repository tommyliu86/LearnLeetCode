package com.lwf.oldtime;

import java.util.HashMap;
import java.util.Map;

/**
 * author Administrator
 * time 2019-08-09
 * 405.md
 */
public class ToHex {
    public static void main(String[] args) {
        System.out.println((long)(Math.pow(2, 32)-1));
    }
    public String toHex(int num) {

        Map<Integer,Character> map=new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i,(char)(i+'0'));
        }
        for (int i = 10; i < 16; i++) {
            map.put(i,(char)('a'+i-10));
        }
        long n=num;
        if (num<0){
            n=(long)Math.pow(2,32)+n;
        }
        StringBuilder builder=new StringBuilder();
        while(n!=0){
          long  remain  = n%16;
            n/=16;
            builder.append(map.get((int)remain   ));
        }
        return builder.reverse().toString();

    }
}
