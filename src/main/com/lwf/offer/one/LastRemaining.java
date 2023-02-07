package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/2/7 16:56
 */
public class LastRemaining {
    class Solution {
        //1.index变换，数列下标为结果，则，f(n-1)和f(n)之间的坐标如何换算？ f(n)=(m+f(n-1))%n 因为f(n-1)的第一个index指向的是f（n）的m
        //递归计算，设f(n,m) 返回的index
        public int lastRemaining(int n, int m) {
            //返回的是首index
            if (n==1) return 0;
            int i=lastRemaining(n-1,m);
            return (m+i)%n;
        }

    }
    class Solution1 {
        //1.index变换，数列下标为结果，则，f(n-1)和f(n)之间的坐标如何换算？ f(n)=(m+f(n-1))%n 因为f(n-1)的第一个index指向的是f（n）的m
        //迭代计算，每次计算下一个位置应该是什么即可
        public int lastRemaining(int n, int m) {
            int ans=0;
            for (int i = 2; i <= n; i++) {
                ans=(ans+m)%i;
            }
            return ans;
        }

    }
}
