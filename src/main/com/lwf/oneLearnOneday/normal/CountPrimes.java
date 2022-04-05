package com.lwf.oneLearnOneday.normal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-05 09:29
 */
public class CountPrimes {
    class test1 {
        /**
         * 执行用时：94 ms, 在所有 Java 提交中击败了95.01%的用户
         * 内存消耗：68.2 MB, 在所有 Java 提交中击败了11.12%的用户
         *
         *
         * 埃式筛选，从前向后遍历，考虑i，i的倍数肯定是合数，因为倍数肯定有因子。而一个数x是否是质数是通过小于x的所有数是否能作为x的因子来判断的
         * 因此从前向后遍历，并标记所有遍历到的i的倍速，没被标记的就是质数。
         * 1.优化，考虑遍历到的元素i，不需要对小于i的倍数进行处理，因为小于i的已经被处理过了（2*i，3*i。。2,3肯定比i先处理过了）。
         * 2.优化，只需要计算奇数，偶数肯定是合数
         * @param n
         * @return
         */
        public int countPrimes(int n) {
            if(n<3) return 0;
            int[] primes=new int[n+1];
            int count=1;
            for (int i = 3; i < n; i+=2) {
                if (primes[i]==0){
                    count++;
                    if ((long)i*i<n){

                        for (long j = i*i; j <n; j+=(2*i)) {//这里j是质数i的倍数，1倍，2倍，3倍，因此j的步长是i
                            primes[(int) j]=1;
                        }
                    }

                }
            }
            return count;
        }
    }
    class test {
        /**
         * 遍历基础上稍微优化下，所有偶数肯定不是质数
         * 还是超时。
         * @param n
         * @return
         */
        public int countPrimes(int n) {
            if(n<3) return 0;
            int count=1;

            for (int i = 3; i < n; i+=2) {
                if (isPrime(i)){
                    count++;
                }
            }
            return count;
        }

        /**
         * 暴力遍历来计算是否是质数,输入肯定是奇数，因此因子也肯定是奇数，遍历所有奇数i
         * @param n
         * @return
         */
        private boolean isPrime(int n){
            for (int i = 3; i*i <= n; i+=2) {
                if (n%i==0) {
                    return false;
                }
            }
            return true;
        }
    }
    class Solution {
        /**
         * 暴力遍历，超时
         * @param n
         * @return
         */
        public int countPrimes(int n) {
            int count=0;

            for (int i = 2; i < n; i++) {
                if (isPrime(i)){
                    count++;
                }
            }
            return count;
        }

        /**
         * 暴力遍历来计算是否是质数
         * @param n
         * @return
         */
        private boolean isPrime(int n){
            for (int i = 2; i*i < n; i++) {
                if (n%i==0) {
                    return false;
                }
            }
            return true;
        }
    }
}
