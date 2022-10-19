package com.lwf.oneLearnOneday.hard;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2022/10/18 8:54
 */
public class AtMostNGivenDigitSet {
    /**
     * dp ，注意dp的每一个行的逻辑！
     */
    class Solution {
        public int atMostNGivenDigitSet(String[] digits, int n) {
            int[] digs=new int[digits.length];
            for (int i = 0; i < digs.length; i++) {
                digs[i]= Integer.valueOf( digits[i]);
            }
            Arrays.sort(digs);
            Set<Integer> sets=new HashSet<>();
            int[] count=new int[10];
            int k=1;
            for (int i = 0; i < digs.length; i++) {
                int dig = digs[i];
                sets.add(dig);
                while (k<dig){
                    count[k]=count[k-1];
                    k++;
                }
                count[k]=count[k-1]+1;
                k++;
            }
            while (k<10){
                count[k]=count[k-1];
                k++;
            }
            List<Integer> ni=new ArrayList<>();
            while (n>0){
                ni.add( n % 10);
                n/=10;
            }
            Collections.reverse(ni);
            int[][] dp=new int[ni.size()+1][2];
            dp[0][1]=1;
            for (int i = 1; i < dp.length; i++) {
                Integer cur = ni.get(i - 1);
                dp[i][0]=dp[i-1][0]*sets.size()+ dp[i-1][1] *(getMin(count,cur,sets)) +(i>1?sets.size():0) ;
                dp[i][1]=dp[i-1][1]==1?(sets.contains(cur)?1:0):0;

            }
            return dp[ni.size()][0]+dp[ni.size()][1];
            //12345
            //13
        }
        private int getMin(int[] count,int cur,Set<Integer> sets){
            return sets.contains(cur) ? count[cur] - 1 : count[cur];
        }

    }
    /**
     * 暴力遍历，超时
     */
    class Solution1 {
        public int atMostNGivenDigitSet(String[] digits, int n) {
            int[] digs=new int[digits.length];
            for (int i = 0; i < digs.length; i++) {
                digs[i]= Integer.valueOf( digits[i]);
            }
            Arrays.sort(digs);
            Queue<Long> queue=new LinkedList<>();
            int count=0;
            for (int dig : digs) {
                queue.offer((long) dig);
            }
            while (queue.peek()<=n){
                count++;
                Long poll = queue.poll();
                for (int i = 0; i < digs.length; i++) {
                    queue.offer(poll*10+digs[i]);
                }
            }
            return count;
        }
    }
}
