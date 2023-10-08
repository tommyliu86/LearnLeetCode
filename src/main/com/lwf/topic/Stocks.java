package com.lwf.topic;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 股票系列
 * @author liuwenfei
 * @date 2023/10/8 8:22
 */
public class Stocks {
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
