package com.lwf.oneLearnOneday.normal;

import com.sun.source.tree.LambdaExpressionTree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/5/23 9:04
 */
public class LargestValsFromLabels {
    /**
     * 分析题目：题目要找最大值，因此我们把values排序后，从大到小遍历找是否可以使用，如何判断这个值是否可用时通过记录相同标签用了几个判断
     * 解法：通过分析可以知道解题使用 排序+哈希计数即可
     * 排序方法：我们使用额外index来实现排序，这样可以同时对应values和labels
     */
    class Solution {

        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {

            /**
             * index数组记录每个值的索引,用于实现基于values的值的排序
             */
            Integer[] index = new Integer[values.length];
            for (int i = 0; i < index.length; i++) {
                index[i] = i;
            }

            /**
             * 根据values的值排序index数组
             */
            Arrays.sort(index, Comparator.comparing(a -> -values[a]));

            /**
             * map记录每个label使用的次数
             */
            Map<Integer, Integer> map = new HashMap<>();

            int ans = 0;
            int i = 0;
            /**
             * 从值最大的开始遍历,如果label的使用次数未达到上限,累加值并增加使用次数,直到得到numWanted个值
             */
            while (numWanted > 0 && i < index.length) {
                Integer key = index[i++];
                int label = labels[key];
                if (map.getOrDefault(label, 0) >= useLimit) {
                    continue;
                }
                ans += values[key];
                map.put(label, map.getOrDefault(label, 0) + 1);
                numWanted--;
            }
            return ans;
        }

    }
}
