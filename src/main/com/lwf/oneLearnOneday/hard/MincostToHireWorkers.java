package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author liuwenfei
 * @date 2022/9/11 18:48
 */
public class MincostToHireWorkers {
    class Solution {
        public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
            Integer[] indexs=new Integer[quality.length];
            for (int i = 0; i < indexs.length; i++) {
                indexs[i]=i;
            }
            Arrays.sort(indexs, Comparator.comparingDouble(a -> (double) wage[a] / quality[a]));

            PriorityQueue<Integer> qualities=new PriorityQueue<Integer>((a,b)->Integer.compare(b,a));
            int totalQ=0;
            double rtn= Double.MAX_VALUE;
            for (int i = 0; i < k-1; i++) {
                Integer curI = indexs[i];
                totalQ+=quality[curI];
                qualities.offer(quality[curI]);
            }
            for (int i = k-1; i < quality.length; i++) {
                Integer curI = indexs[i];
                totalQ+=quality[curI];
                double x=(double) wage[curI]/quality[curI];
                rtn=Math.min(rtn,totalQ*x);

                //从k个中移除 qutity最大的一个，因为后面进来之后，给每份qutity的价格是固定的，因此去除qutity最大的人就可以保证
                //总和工资最小
                qualities.offer(quality[curI]);
                Integer poll = qualities.poll();
                totalQ-=poll;

            }
            return rtn;
        }
    }
}
