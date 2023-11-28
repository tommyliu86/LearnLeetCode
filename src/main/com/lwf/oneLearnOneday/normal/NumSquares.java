package com.lwf.oneLearnOneday.normal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 279. 完全平方数
 */
public class NumSquares {
    /**
     * dp 动态规划，每一个数都可以用完全平方数的和表示，最差结果是都是1，
     * 因此我们可以发现，如果一个数i，找最少的完全平方组合，则i可以分解成（a+b） 我们变成了找a和b的问题，考虑我们可以把a==完全平方数，因此我们可以通过
     * 枚举所有的小于 i的完全平方数来找到b的最少组合，也就是状态转移方程
     */
    class Solution {
        public int numSquares(int n) {
            int[] counts=new int[n+1];
            for (int i = 1; i <= n; i++) {
                int cur=i;
                for (int j = 1; j*j <= i; j++) {
                    cur=Math.min(cur,1+counts[i-j*j]);
                }
                counts[i]=cur;
            }
            return counts[n];
        }
    }
    public int numSquares(int n) {
        counts=new int[n+1];
        return  normal(n);
    }

    int[] counts;

    /**
     * 暴力解法，依次遍历求解。
     * @param n
     * @return
     */
    int normal(int n){

        int min=n+1;
        for (int i = 1; i*i <=n ; i++) {
            int k=n-i*i;
            if (k==0) {
               counts[n]=1;
               return 1;
            }
            if (counts[k]==0){
                counts[k]=normal(k);
            }
            min=Math.min(min,counts[k]+1);
        }
        return min;
    }

    /**
     * 动态规划，动态规划的思想是通过总结推导公式，从i-1求解i的值。属于正向思路
     * @param n
     * @return
     */
    int dync(int n){
        int[] pows=new int[n+1];

        for (int i = 1; i <= n; i++) {
          pows[i]=i;
            for (int j = 1; j*j <=i ; j++) {
                pows[i]=Math.min(pows[i],pows[i-j*j]+1);
            }

        }
    return pows[n];
    }

    /**
     * 广度遍历，利用queue进行层的遍历 速度最快。注意需要剪枝，通过记录遍历中的k值重复出现，进行排除出queue中
     * 不然会有很多重复计算的路径，会变慢。
     * @param n
     * @return
     */
    int BFS(int n){
        Queue<node> queue=new LinkedList<>();
        int[] record=new int [n+1]; //记录是否重复路径！
        queue.add(new node(n,1));
        while (!queue.isEmpty()){
            node parent=queue.poll();
            int value =parent.val;
            int depth=parent.depth;
            for (int i = 1; i*i <=value ; i++) {
                int k=value-i*i;
                if (k==0) return depth+1;
                if (record[k]!=1){

                    ((LinkedList<node>) queue).add(new node(k,depth+1));
                    record[k]=1;
                }
            }
        }
        return -1;
    }
    class node{
        public int val;
        public int depth;
        public node(int value,int depth){
            this.val=value;
            this.depth=depth;
        }
    }
}
