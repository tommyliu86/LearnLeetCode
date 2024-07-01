package com.lwf.oneLearnOneday.hard;

import java.util.*;

/**
 * @author: liuwenfei
 * @date: 2024/6/13-8:56
 */
public class FindMaximumElegance {
    class Solution {
        public long findMaximumElegance(int[][] items, int k) {
            //从大到小排列，因为子序列，所以和位置无关
            Arrays.sort(items,(a,b)->Integer.compare(b[0],a[0]));

            //记录每个cat的出现的数量
            Set<Integer> categorys=new HashSet<>();
            long sum=0;
            int i=0;
            Stack<Integer> indez=new Stack<>();

            //直接取最大的k个
            for (; i < k; i++) {
                int[] item = items[i];
                if (!categorys.contains(item[1])){
                    indez.add(item[0]);
                    categorys.add(item[1]);
                }

                sum+=item[0];
            }

            //继续遍历数组，找到可以让结果变大的数
            for (; i < items.length; i++) {
                int[] item = items[i];
                if (categorys.contains(item[1])) {
                    continue;
                }
                if (indez.size()==0) {
                    continue;
                }
                Integer cur = indez.pop();

                if ((long)(sum-cur+item[0])+(categorys.size()+1)*(categorys.size()+1)>sum+categorys.size()*categorys.size()){
                    categorys.add(item[1]);
                    sum= sum-cur+item[0];
                }

            }
            return sum+(categorys.size()*categorys.size());
        }
    }
}
