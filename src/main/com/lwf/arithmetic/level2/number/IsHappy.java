package com.lwf.arithmetic.level2.number;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-13 15:15
 */
public class IsHappy {
    class Solution {
        public boolean isHappy(int n) {
            Set<Integer> set=new HashSet<>();
            while (n!=1&& !set.contains(n)){
                set.add(n);
                n=power(n);
            }
            return n==1;
        }
        public int power(int n){
            int rtn=0;
            while (n!=0&&n!=1){
              rtn+= Math.pow( n%10,2);
              n/=10;
            }
            return rtn+n*n;
        }
    }
}
