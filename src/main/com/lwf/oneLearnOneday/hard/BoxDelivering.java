package com.lwf.oneLearnOneday.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author liuwenfei
 * @date 2022/12/5 9:41
 */
public class BoxDelivering {
    class Solution {
        public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
            int n = boxes.length;
            long[] weights = new long[n + 1];
            int[] steps = new int[n];
            for (int i = 0; i < n; ++i) {
                int p = boxes[i][0], w = boxes[i][1];
                weights[i + 1] = weights[i] + w;
                if (i < n - 1) {
                    steps[i + 1] = steps[i] + (p != boxes[i + 1][0] ? 1 : 0);
                }
            }
            int[] f = new int[n + 1];
            //队列中放入的是单调变大的运输次数的下标i。 f中保存的是通过滑动窗口计算出来的值。
            Deque<Integer> q = new ArrayDeque<>();
            q.offer(0);
            for (int i = 1; i <= n; ++i) {
                //如果在窗口之外，则弹出
                while (!q.isEmpty() && (i - q.peekFirst() > maxBoxes || weights[i] - weights[q.peekFirst()] > maxWeight)) {
                    q.pollFirst();
                }
                if (!q.isEmpty()) {
                    f[i] = steps[i - 1] + f[q.peekFirst()] - steps[q.peekFirst()] + 2;
                }
                if (i < n) {
                    while (!q.isEmpty() && f[q.peekLast()] - steps[q.peekLast()] >= f[i] - steps[i]) {
                        q.pollLast();
                    }
                    q.offer(i);
                }
            }
            return f[n];
        }
    }


    class Solution2{

            public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
                int n = boxes.length;
                int[] presum=new int[n+1];
                int[] steps=new int[n+1];
                for (int i = 0; i < boxes.length; i++) {
                    presum[i+1]=presum[i]+boxes[i][1];
                    steps[i+1]=steps[i]+(i==0?1:( boxes[i][0]!=boxes[i-1][0]?1:0));
                }
                int[] dp = new int[n + 5];
                Arrays.fill(dp, 0x3f3f3f3f);
                dp[0] = 0;
                Deque<int[]> q = new ArrayDeque<int[]>(); //双端队列
                int dif = 0, wei = 0;
                for (int i = 1; i <= n; i++) {
                    int cur = dp[i - 1] + 2;//cur为每次滑动窗口增加的值即dp[i-1]+cost[i,i]
                    //在i时总共的箱子目的地个数
                    dif += i >= 2 && boxes[i - 1][0] != boxes[i - 2][0] ? 1 : 0;
                    //当前车上箱子的重量
                    wei += boxes[i - 1][1];
                    while (!q.isEmpty() && q.peekLast()[1] + dif >= cur) {
                        q.pollLast(); //构造一个单调递增的队列
                    }
                    q.add(new int[]{i, cur - dif, boxes[i - 1][1] - wei});
                    //判断左端队头是否在窗口外 并且重量不能超过最大重量
                    while (q.peekFirst()[0] <= i - maxBoxes || q.peekFirst()[2] + wei > maxWeight) q.pollFirst();
                    dp[i] = q.peekFirst()[1] + dif;
                }
                return dp[n];
            }


    }
    class Solution1 {
        public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
            int n = boxes.length;
            int[] presum=new int[n+1];
            int[] steps=new int[n+1];
            for (int i = 0; i < boxes.length; i++) {
                presum[i+1]=presum[i]+boxes[i][1];
                steps[i+1]=steps[i]+(i==0?1:( boxes[i][0]!=boxes[i-1][0]?1:0));
            }
            int[] mins=new int[n+1];
            Arrays.fill(mins,n*2);
            mins[0]=0;
            for (int i = 1; i < mins.length; i++) {
                for (int j = 1; j <= maxBoxes&& j<=i&&  presum[i]-presum[i-j]<=maxWeight; j++) {
                    mins[i]=Math.min(mins[i],mins[i-j]+steps[i]-steps[i-j+1]+2);
                }
            }
            return mins[n];
        }
    }
}
