package com.lwf.oldtime;

import java.util.LinkedList;
import java.util.List;

/**
 * author Administrator
 * time 2019-08-11
 * {@link 412.md}
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list=new LinkedList<>();
        for (int i = 1; i <=n; i++) {
            list.add(getReplace(i));
        }
        return list;
    }
    String getReplace(int k){
        if (k%15==0){
            return "FizzBuzz";
        }else if(k%5==0){
            return "Buzz";
        }else if(k%3==0){
            return "Fizz";
        }else{
            return String.valueOf(k);
        }
    }
}
