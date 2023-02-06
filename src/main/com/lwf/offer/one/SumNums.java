package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/2/1 15:26
 */
public class SumNums {
    class Solution {
        public int sumNums(int n) {
            //使用赋值语句+逻辑运算符
           boolean flag= n>0&&(n+=sumNums(n-1))>0;
           return n;
        }
    }
}
