package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * 1094. 拼车
 *
 * @author liuwenfei
 * @date 2023/12/5 8:35
 */
public class CarPooling {

    /**
     * 数组计数，因为给定数据范围最大1000，因此直接使用1000的数组来进行记录上下车的情况，然后遍历即可，
     * 这种类似与差分数组的应用！
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


    /**
     * 合并区间,优先队列
     * treeMap 是有序哈希表，key不能重复的，treeSet是有序集合，priorityQueue是有序队列，可以重复
     */

    class Solution1 {
        public boolean carPooling(int[][] trips, int capacity) {
            Arrays.sort(trips, Comparator.comparing(a -> a[1]));
            int max = 0;
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
            for (int i = 0; i < trips.length; i++) {
                int[] trip = trips[i];
                while (!queue.isEmpty() && queue.peek()[0] <= trip[1]) {
                    int[] first = queue.poll();
                    max -= first[1];
                }
                max += trip[0];
                if (max > capacity) {
                    return false;
                }
                queue.offer(new int[]{trip[2], trip[0]});
            }
            return true;
        }
    }
}
