package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//位运算
public class CountArrangement {
    class Solution {

        public int countArrangement(int n) {
            int[] marks=new int[1<<n];
            /**
             *  位运算表示选中与否的关系，dp(i)和dp(i-1)的转移。
             *  mark表示了一个组合，其中包含了k个，那么它是和k-1个有关系的。
             *  因此，通过位运算可以去找所有的这k个，然后计算哪个可以放到n这个位置上的。
             */

            for (int i = 1; i < marks.length; i++) {
                int index = Integer.bitCount(i);
                for (int k = 0; k < n; k++) {
                    if ((i&(1<<k))!=0&&(index%(k+1)==0||(k+1)%index==0)) {
                        //因为是去掉一个1，因此肯定是遍历前面走过的。
                        marks[i]+=marks[i^(1<<k)];
                    }
                }
            }
            return marks[(1<<n)-1];
        }
    }
    class Solution1 {
        /**
         * 暴力方法，直接递归收拾，使用数组记录是否使用过数字
         * @param n
         * @return
         */
        public int countArrangement(int n) {
            boolean[] mark=new boolean[n+1];
            return dfs(1,mark,n);
        }
        public int dfs(int i,boolean[] mark,int n){
            if (i>n){
                return 1;
            }
            int count=0;
            for (int j = 1; j <= n; j++) {
                if (!mark[j]&&(j%i==0||i%j==0)){
                    mark[j]=true;
                    count+=dfs(i+1,mark,n);
                    mark[j]=false;
                }
            }
            return count;
        }
    }
}
