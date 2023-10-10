package com.lwf.topic;

import java.util.*;

/**
 * 股票系列
 * @author liuwenfei
 * @date 2023/10/8 8:22
 */
public class Stocks {
    class maxProfit1 {
        public int maxProfit(int[] prices) {

        }
    }
    /**
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
     * dp 动态规划，分别计算每个股票点 手中 有 和 无 股票的价格
     * 贪心
     */
    class maxProfit {
        public int maxProfit(int[] prices, int fee) {
            int[][] moneys=new int[prices.length][2];
            moneys[0][1]-=prices[0];
            for (int i = 1; i < moneys.length; i++) {
                moneys[i][0]=Math.max(moneys[i-1][0],moneys[i-1][1]+prices[i]-fee);
                moneys[i][1]=Math.max(moneys[i-1][1],moneys[i-1][0]-prices[i]);
            }
            return moneys[prices.length-1][0];
        }

        /**
         * 贪心写法，通过 把费用加到买入价格，表示花费
         * 这样可以记录到 买入和卖出两个点，可以获取的就是 卖出-买入，何时买卖？在 卖出>买入时 可能不是最优，因此需要 可对比机制（贪心的核心）
         * @param prices
         * @param fee
         * @return
         */
        public int maxProfit1(int[] prices, int fee) {
            //高于这个价格才盈利
            int buy=prices[0]+fee;
            int ans=0;
            for (int i = 1; i < prices.length; i++) {
                //1.buy=买入
                if (prices[i]+fee<buy){
                    buy=prices[i]+fee;
                }else if (prices[i]>buy){
                    ans+=prices[i]-buy;
                    //此时表示我们卖出的价格也是买入价格，这样如果下个价格比这个价格高，仍然可以卖出
                    // 这样的操作恰好就等于在这一天不进行任何操作，而在下一天卖出股票的收益；
                    buy=prices[i];
                }
            }
            return ans;
        }
    }
    /**
     * https://leetcode.cn/problems/online-stock-span/
     *  单调栈，保存 单调递增最小栈，查找当前价格之前的最小值即可
     */
    class StockSpanner {

        public StockSpanner() {

        }

        Deque<int[]> deque=new LinkedList<>();
        int indez=0;
        public int next(int price) {
            indez++;
            while (!deque.isEmpty()&& deque.peek()[0]<=price){
                deque.pop();
            }
            int pre=deque.isEmpty()?0:deque.peek()[1];
            deque.push(new int[]{price,indez});
            return indez-pre;
        }
    }

    /**
     * https://leetcode.cn/problems/stock-price-fluctuation/
     * 使用两个 优先队列，1个哈希表，
     * 1. hash存储 时间戳和价格，并进行更新操作
     * 2. 大根堆 小根堆 直接进行数据存储，在查找时，通过和对应时间戳的价格对比来判断是否是最新价格。
     * @author liuwenfei
     * @date 2023/10/8 8:23
     */
    public class StockPrice {
        Map<Integer,Integer> stocks=new HashMap<>();
        int newStamp=0;
        PriorityQueue<int[]> queueMax =new PriorityQueue<>((a, b)->{
            return Integer.compare(b[1],a[1]);
        });
        PriorityQueue<int[]> queueMin=new PriorityQueue<>((a,b)->{
            return Integer.compare(a[1],b[1]);
        });
        public StockPrice() {

        }

        public void update(int timestamp, int price) {
            stocks.put(timestamp,price);
            queueMax.offer(new int[]{timestamp,price});
            queueMin.offer(new int[]{timestamp,price});
            newStamp=Math.max(newStamp,timestamp);
        }

        public int current() {
            return stocks.get(newStamp);
        }

        public int maximum() {
            while (stocks.get( queueMax.peek()[0])!= queueMax.peek()[1]){
                queueMax.poll();
            }
            return queueMax.peek()[1];
        }

        public int minimum() {
            while (stocks.get( queueMin.peek()[0])!= queueMin.peek()[1]){
                queueMin.poll();
            }
            return queueMin.peek()[1];
        }
    }
}
