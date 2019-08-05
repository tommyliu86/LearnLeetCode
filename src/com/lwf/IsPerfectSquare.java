package com.lwf;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * author Administrator
 * time 2019-08-03
 */
public class IsPerfectSquare {
    public static void main(String[] args) {
        for (int i = 1; i <10 ; i++) {
            System.out.println(i*i);
        }
    }
    public boolean isPerfectSquare(int num) {
        Set<Integer> set=new HashSet<>(Arrays.asList(0,1,4,5,6,9));
        int m=num%10;
        if (!set.contains(m)) return false;
        else    {

        }
        return false;
    }
}
