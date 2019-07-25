package com.lwf;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(Math.pow(i, 2));

        }
    }
    public boolean isHappy(int n){
        Set<Integer>  set=new HashSet<>();
        while (!set.contains(n)){
            set.add(n);
           int sum=0;
           while (n!=0){
               sum+=Math.pow((n%10),2);
               n/=10;
           }
           n=sum;
        }
        return n==1;
    }
}
