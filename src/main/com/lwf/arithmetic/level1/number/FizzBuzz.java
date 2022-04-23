package com.lwf.arithmetic.level1.number;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-19 17:27
 */
public class FizzBuzz {
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> rtn=new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i%15==0){
                    rtn.add("FizzBuzz");
                }else if (i%5==0){
                    rtn.add("Buzz");
                }else if(i%3==0){
                    rtn.add("Fizz");
                }else{
                    rtn.add(String.valueOf( i));
                }
            }
            return rtn;
        }
    }
}
