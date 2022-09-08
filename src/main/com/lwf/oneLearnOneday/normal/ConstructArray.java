package com.lwf.oneLearnOneday.normal;

public class ConstructArray {
    /**
     * 如何得到k个差值，这里的思路需要从k=n-1来看，n个数的差最多有n-1个，因此可以得到这里的排列
     * 【1，n,2,n-1,3,n-2...】,也就是从1开始的递增+n开始的递减，差值正好可以是n-1~1不断减小。
     * 这部分是比较稳定的，如果有k个，k<n-1,则我们可以同样这样排列，只把最后剩下的按照递增/递减排列
     * 即可。
     */
    class Solution {
        public int[] constructArray(int n, int k) {
            int[] rtn=new int[n];

            int min=1;
            int max=n;
            boolean small=true;
            for (int i = 0; i < k; i++) {
                if (small){
                    rtn[i]=min++;
                }else{
                    rtn[i]=max--;
                }
                small=!small;
            }

            for (int i = k; i < n; i++) {
                if (small){
                    rtn[i]=max--;
                }else{
                    rtn[i]=min++;
                }
            }
            return rtn;
        }
    }
}
