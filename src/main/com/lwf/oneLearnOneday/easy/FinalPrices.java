package com.lwf.oneLearnOneday.easy;

import java.util.Stack;

public class FinalPrices {
    class Solution {
        public int[] finalPrices(int[] prices) {
            Stack<Integer> stack=new Stack<>();

            for (int i = prices.length - 1; i >= 0; i--) {
                int price = prices[i];

                while (!stack.isEmpty()&&stack.peek()> price){
                    stack.pop();
                }
                if (!stack.isEmpty()){

                    prices[i]-=stack.peek();
                }
                stack.push(price);
            }
            return prices;
        }
    }
}
