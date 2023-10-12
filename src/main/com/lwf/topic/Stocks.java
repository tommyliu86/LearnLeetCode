package com.lwf.topic;

import java.util.*;

/**
 * 股票系列
 * 股票中的题目，都是对 数组 进行 不同方法进行计算的求解，处理的数据结构相同，但算法不同，因此放一起，可以加深对同类型数据结构的不同算法的思考。
 * 这样以后看到相同数据结构和求解要求，基本上就可以很快的找到要使用的算法了~~😄
 * @author liuwenfei
 * @date 2023/10/8 8:22
 */
public class Stocks {
    /**
     * 第一题
     * 121. 买卖股票的最佳时机
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
     *
     * 使用常数，保存 i前面的最小值，并把i-min 作为可获取的最大进行保存即可。
     */
    class Solution_1 {
        public int maxProfit(int[] prices) {
            int min=prices[0];
            int ans=0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i]>min){
                    ans=Math.max(ans,prices[i]-min);
                }else{
                    min=prices[i];
                }
            }
            return ans;
        }
    }
    /**
     * 第二题
     * 买卖股票的最佳时机 II
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
     *
     *
     */
    class Solution_2 {
        //贪心 获取所有正向差,直接一次遍历
        public int maxProfit(int[] prices) {
           int ans=0;
            for (int i = 0; i < prices.length-1; i++) {
                ans+=Math.max(0, prices[i+1]-prices[i]);
            }
            return ans ;
        }

    }

    /**
     * 第三题
     * 123. 买卖股票的最佳时机 III
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
     *
     *
     */
    class Solution_3 {
        /**
         * dp 通过记录 买 卖 买2 卖2来进行
         * 第一次的买卖和第二次的买卖其实都可以一起计算，只有到第二次买卖真正产生时两个才会有差异
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            //买 卖 买2 卖2
           int[][] dps=new int[prices.length][4];
            //第一次的买卖和第二次的买卖其实都可以一起计算，只有到第二次买卖真正产生时两个才会有差异
           dps[0][0]=-prices[0];
           dps[0][2]=-prices[0];
            for (int i = 1; i < prices.length; i++) {
                //第一次买的最佳
                dps[i][0]=Math.max(dps[i-1][0],-prices[i]);
                dps[i][1]=Math.max(dps[i-1][0]+prices[i],dps[i-1][1]);

                dps[i][2]=Math.max(dps[i-1][1]-prices[i],dps[i-1][2]);
                dps[i][3]=Math.max(dps[i-1][2]+prices[i],dps[i-1][3]);
            }
            return  Math.max( dps[prices.length-1][1], dps[prices.length-1][3]);
        }


        /**
         *
         * 把数组拆分成两个，分别求每个的最大
         * 超时
         * @param prices
         * @return
         */
        public int maxProfit1(int[] prices) {
            int ans=max(prices,0,prices.length-1);
            for (int i = 0; i < prices.length-1; i++) {
                ans=Math.max(ans,max(prices,0,i)+max(prices,i+1,prices.length-1));
            }
            return ans;
        }
        private int max(int[] prices,int i,int j){
            int min=prices[i];
            int ans=0;
            for (int i1 = i+1; i1 <= j; i1++) {
                if (prices[i1]>min){
                    ans=Math.max(prices[i1]-min,ans);
                }else{
                    min=prices[i1];
                }
            }
            return ans;
        }
    }

    /**
     * 第四题
     * 188. 买卖股票的最佳时机 IV
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
     *
     * 通过第三题的思路，我们可以考虑使用一个n* k*2 长度的二维数组 ，保存所有的状态，也就是不进行空间优化
     * 而实际上，对于所有的状态转移都是 买入依据卖出的 因此我们可以直接使用一个数组保存状态转移常量，然后遍历整体数据来进行dp
     *
     */
    class Solution_4 {
        public int maxProfit(int k, int[] prices) {
            //0 有 1 无 其中 k 表示正好交易k次
            int[][] dps=new int[k+1][2];
            //这里需要这样初始化所有的买入，不然后续的计算会因为 没有初始化的价格而导致计算错误，这里的意思可以理解成原地交易了K次。
            //这样好理解
            for (int i = 0; i < dps.length; i++) {
                dps[i][0] = -prices[0];
            }
            for (int i = 0; i < prices.length; i++) {
                int price = prices[i];
                dps[0][0]=Math.max(dps[0][0],-prices[i]);
                for (int j = 1; j < dps.length; j++) {
                    //先买k次，才能卖出第k次，因此 每一次的买都是下一次的卖出的对应 先计算 卖 再买
                    dps[j][1]=Math.max(dps[j][0]+price,dps[j][1]);
                    dps[j][0]=Math.max( dps[j-1][1]-price,dps[j][0]);
                }
            }
            int ans=0;
            for (int i = 0; i < dps.length; i++) {
                ans=Math.max(dps[i][1],ans);
            }
            return ans;
        }
    }

    class maxProfit1 {
        /**
         * 第五题 309. 买卖股票的最佳时机含冷冻期
         * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
         * 冷冻期，通过额外的一个冷冻期状态来
         *
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            //0 可买 1可卖 2冷冻
            int[][] dps = new int[prices.length][3];

            dps[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dps[i][0] = Math.max(dps[i - 1][0], dps[i - 1][2]);
                dps[i][1] = Math.max(dps[i - 1][1], dps[i - 1][0] - prices[i]);
                dps[i][2] = dps[i - 1][1] + prices[i];
            }
            return Math.max(dps[prices.length - 1][0], dps[prices.length - 1][2]);
        }

        /**
         * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
         * 包含冷冻期，
         * 买股票，股票 通过 i-2 的位置来买入，
         *
         * @param prices
         * @return
         */
        public int maxProfit1(int[] prices) {
            //0 无 1 有
            int[][] dps = new int[prices.length][2];

            dps[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dps[i][0] = Math.max(dps[i - 1][0], dps[i - 1][1] + prices[i]);
                // 买入股票，则需要通过 i-2
                dps[i][1] = Math.max((i - 2 >= 0 ? dps[i - 2][0] : 0) - prices[i], dps[i - 1][1]);
            }
            return dps[prices.length - 1][0];
        }
    }

    /**
     * 第六题
     * 714. 买卖股票的最佳时机含手续费
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
     * dp 动态规划，分别计算每个股票点 手中 有 和 无 股票的价格
     * 贪心
     */
    class maxProfit {
        public int maxProfit(int[] prices, int fee) {
            int[][] moneys = new int[prices.length][2];
            moneys[0][1] -= prices[0];
            for (int i = 1; i < moneys.length; i++) {
                moneys[i][0] = Math.max(moneys[i - 1][0], moneys[i - 1][1] + prices[i] - fee);
                moneys[i][1] = Math.max(moneys[i - 1][1], moneys[i - 1][0] - prices[i]);
            }
            return moneys[prices.length - 1][0];
        }

        /**
         * 贪心写法，通过 把费用加到买入价格，表示花费
         * 这样可以记录到 买入和卖出两个点，可以获取的就是 卖出-买入，何时买卖？在 卖出>买入时 可能不是最优，因此需要 可对比机制（贪心的核心）
         *
         * @param prices
         * @param fee
         * @return
         */
        public int maxProfit1(int[] prices, int fee) {
            //高于这个价格才盈利
            int buy = prices[0] + fee;
            int ans = 0;
            for (int i = 1; i < prices.length; i++) {
                //1.buy=买入
                if (prices[i] + fee < buy) {
                    buy = prices[i] + fee;
                } else if (prices[i] > buy) {
                    ans += prices[i] - buy;
                    //此时表示我们卖出的价格也是买入价格，这样如果下个价格比这个价格高，仍然可以卖出
                    // 这样的操作恰好就等于在这一天不进行任何操作，而在下一天卖出股票的收益；
                    buy = prices[i];
                }
            }
            return ans;
        }
    }

    /**
     * 第七题
     * 901. 股票价格跨度
     * https://leetcode.cn/problems/online-stock-span/
     * 单调栈，保存 单调递增最小栈，查找当前价格之前的最小值即可
     */
    class StockSpanner {

        public StockSpanner() {

        }

        Deque<int[]> deque = new LinkedList<>();
        int indez = 0;

        public int next(int price) {
            indez++;
            while (!deque.isEmpty() && deque.peek()[0] <= price) {
                deque.pop();
            }
            int pre = deque.isEmpty() ? 0 : deque.peek()[1];
            deque.push(new int[]{price, indez});
            return indez - pre;
        }
    }

    /**
     * 第八题
     * 2034. 股票价格波动
     * https://leetcode.cn/problems/stock-price-fluctuation/
     * 使用两个 优先队列，1个哈希表，
     * 1. hash存储 时间戳和价格，并进行更新操作
     * 2. 大根堆 小根堆 直接进行数据存储，在查找时，通过和对应时间戳的价格对比来判断是否是最新价格。
     *
     * @author liuwenfei
     * @date 2023/10/8 8:23
     */
    public class StockPrice {
        Map<Integer, Integer> stocks = new HashMap<>();
        int newStamp = 0;
        PriorityQueue<int[]> queueMax = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b[1], a[1]);
        });
        PriorityQueue<int[]> queueMin = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });

        public StockPrice() {

        }

        public void update(int timestamp, int price) {
            stocks.put(timestamp, price);
            queueMax.offer(new int[]{timestamp, price});
            queueMin.offer(new int[]{timestamp, price});
            newStamp = Math.max(newStamp, timestamp);
        }

        public int current() {
            return stocks.get(newStamp);
        }

        public int maximum() {
            while (stocks.get(queueMax.peek()[0]) != queueMax.peek()[1]) {
                queueMax.poll();
            }
            return queueMax.peek()[1];
        }

        public int minimum() {
            while (stocks.get(queueMin.peek()[0]) != queueMin.peek()[1]) {
                queueMin.poll();
            }
            return queueMin.peek()[1];
        }
    }
}
