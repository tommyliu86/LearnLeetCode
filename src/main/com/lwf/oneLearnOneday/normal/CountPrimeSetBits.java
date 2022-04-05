package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-05 09:37
 */
public class CountPrimeSetBits {
    class Solution {
        List<Integer> primes= Arrays.asList(2,3,5,7,11,13,17,19,21,23,29,31);
        public int countPrimeSetBits(int left, int right) {
            int count=0;
            for (int i = left; i <=right; i++) {
                if (isPrime(i)){
                    count++;
                }
            }
            return count;
        }
        private boolean isPrime(int n){

            int count=0;
            while(n>0){
                count++;
                n=n&(n-1);
            }
            if (primes.contains(count)){
                return true;
            }
            else {
                return  false;
            }
        }
    }
}
