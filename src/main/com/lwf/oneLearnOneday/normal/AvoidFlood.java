package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/10/13 8:36
 */
public class AvoidFlood {

    class Solution {
        /**
         * 也可以使用一个链表list，存储可抽水天，使用二分查找来进行 可用抽水时间的查找
         *
         * @param rains
         * @return
         */
        public int[] avoidFlood(int[] rains) {
            int[] ans=new int[rains.length];
            Arrays.fill(ans,-1);
            Map<Integer,Integer> waters=new HashMap<>();
            List<Integer> drys=new LinkedList<>();
            return null;
        }

        /**
         * 使用treeSet TreeMap系列，进行可抽水查找，使用hash保存下雨天数据
         *
         * @param rains
         * @return
         */

        public int[] avoidFlood1(int[] rains) {
            int[] ans = new int[rains.length];
            Arrays.fill(ans, -1);
            //是否下雨，哪天
            Map<Integer, Integer> waters = new HashMap<>();
            //记录可以抽水的天
            TreeSet<Integer> sortedSet = new TreeSet<>();

            for (int i = 0; i < ans.length; i++) {
                int rain = rains[i];
                if (rain == 0) {
                    sortedSet.add(i);
                } else {
                    if (waters.containsKey(rain)) {
                        Integer j = waters.get(rain);
                        if (sortedSet.isEmpty()) {
                            return new int[0];
                        } else {
                            Integer ceiling = sortedSet.ceiling(j);
                            if (ceiling == null) {
                                return new int[0];
                            }
                            ans[ceiling] = rain;
                            waters.put(rain, i);
                            sortedSet.remove(ceiling);
                        }
                    } else {
                        waters.put(rain, i);
                    }
                }
            }
            for (Integer integer : sortedSet) {
                ans[integer] = 1;
            }
            return ans;
        }
    }
}
