package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/7/28 8:52
 */
public class MinimumTime {
    class Solution {
        /**
         * 计算完成所有任务所需的最短时间
         * 使用动态规划的思想，将任务依次分解成子任务进行求解，使用递归进行计算
         * 时间复杂度：O(n^2)，其中 n 为任务的数量。每个任务可能有多个前置任务，所以需要对每个任务都进行递归计算，而递归的时间复杂度为 O(n)
         * 空间复杂度：O(n)，需要使用一个长度为 n 的数组保存每个任务完成所需的时间
         */
        public int minimumTime(int n, int[][] relations, int[] time) {
            Map<Integer, List<Integer>> preMap = new HashMap<>(); // 用于保存每个任务的前置任务列表
            for (int i = 0; i < relations.length; i++) {
                int preTask = relations[i][0]; // 前置任务的编号
                int currentTask = relations[i][1]; // 当前任务的编号
                List<Integer> preList = preMap.getOrDefault(currentTask, new ArrayList<>()); // 获取当前任务的前置任务列表
                preList.add(preTask); // 将前置任务加入前置任务列表
                preMap.put(currentTask, preList); // 更新前置任务列表
            }

            int[] times = new int[n]; // 保存每个任务完成所需的时间
            int longestTime = 0; // 最长的完成时间
            for (int i = 0; i < times.length; i++) {
                longestTime = Math.max(longestTime, calculateTime(i, preMap, times, time)); // 计算每个任务的完成时间，并更新最长的完成时间
            }

            return longestTime;
        }

        /**
         * 计算任务 i 的完成时间
         */
        private int calculateTime(int i, Map<Integer, List<Integer>> preMap, int[] times, int[] time) {
            if (times[i] > 0) { // 如果任务 i 的完成时间已经计算过了，则直接返回之前的结果
                return times[i];
            }

            List<Integer> preTasks = preMap.get(i + 1); // 获取任务 i 的前置任务列表
            if (preTasks == null) { // 如果任务 i 没有前置任务
                times[i] = time[i]; // 则任务 i 的完成时间就是自身所需的时间
                return times[i];
            }

            for (Integer preTask : preTasks) { // 遍历任务 i 的前置任务列表
                times[i] = Math.max(times[i], calculateTime(preTask - 1, preMap, times, time)); // 递归计算前置任务的完成时间，并取最大值
            }

            times[i] += time[i]; // 将任务 i 的时间加上自身所需的时间，即为任务 i 的完成时间

            return times[i];
        }
    }

}
