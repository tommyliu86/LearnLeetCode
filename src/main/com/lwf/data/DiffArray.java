package com.lwf.data;

/**
 * 差分数组
 * 灵神题单
 * https://leetcode.cn/problems/car-pooling/solutions/2550264/suan-fa-xiao-ke-tang-chai-fen-shu-zu-fu-9d4ra/?envType=daily-question&envId=2023-12-04
 * @author liuwenfei
 * @date 2023/12/5 9:05
 */
public class DiffArray {
    /**
     * 差分数组定义：1.d[0]=a[0]    d[i]=a[i]-a[i-1]
     * 1. 差分数组记录的是数组的相邻元素之间的差，这样的话，对于数组的一个连续区间，想要进行统一的加或减时，只需要对这一段区间的头和尾进行头加尾减
     * 2. 差分数组一般是用来作为辅助数组使用，通过表示相邻元素的差值，就可以表示一段区间内的元素的分布情况，因此，对于i~j，我们想要对整个区间+1，则我们可以
     *      在i+1，在j-1，这样就是对整个区间进行了加+1操作，
     * 头加尾减！
     * 这样就表示了整个数组上的区间加和区间减。
     * 下面题目中的车站到站之后的乘客额上下车正好是一个实际的场景，是一个标准的差分数组题目！
     */
    /**
     * 1094. 拼车
     * 差分数组的简单应用
     */
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] counts=new int[1001];
            for (int i = 0; i < trips.length; i++) {
                int[] trip = trips[i];
                counts[trip[1]]+=trip[0];
                counts[trip[2]]-=trip[0];
            }
            int sum=0;
            for (int i = 0; i < counts.length; i++) {
                sum+=counts[i];
                if (sum>capacity)
                    return false;
            }
            return true;
        }
    }

}
