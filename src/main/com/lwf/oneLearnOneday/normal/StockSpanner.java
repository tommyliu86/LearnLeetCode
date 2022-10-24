package com.lwf.oneLearnOneday.normal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2022/10/21 9:03
 */
class StockSpanner {
    Deque<int[]> days = new LinkedList<>();

    int times;

    public StockSpanner() {
        times = 0;
    }

    public int next(int price) {
        times++;

        while (!days.isEmpty()&& days.peek()[0] <= price) {

            days.pop();
        }
        int pre =days.isEmpty()?0: days.peek()[1];

        days.push(new int[]{price, times});
        return times - pre;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */