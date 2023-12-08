package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 2646. 最小化旅行的价格总和
 * @author liuwenfei
 * @date 2023/12/6 9:37
 */
public class MinimumTotalPrice {
    class Solution {
        public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
            //找到每个点相邻点
            List<Integer>[] next = new List[n];
            for (int i = 0; i < n; i++) {
                next[i] = new ArrayList<Integer>();
            }
            for (int[] edge : edges) {
                next[edge[0]].add(edge[1]);
                next[edge[1]].add(edge[0]);
            }
            //记录每个点在最短路径上被走过的次数
            int[] count = new int[n];
            for (int[] trip : trips) {
                dfs(trip[0], -1, trip[1], next, count);
            }
            //使用相邻点矩阵+每个点次数+price进行dp，计算每个点减半或不见半进行dp的最小值，因为从一个点开始，只有减半/不减半两种情况，因此直接计算这两种情况即可
            int[] pair = dp(0, -1, price, next, count);
            return Math.min(pair[0], pair[1]);
        }

        public boolean dfs(int node, int parent, int end, List<Integer>[] next, int[] count) {
            if (node == end) {
                count[node]++;
                return true;
            }
            for (int child : next[node]) {
                if (child == parent) {
                    continue;
                }
                if (dfs(child, node, end, next, count)) {
                    count[node]++;
                    return true;
                }
            }
            return false;
        }

        public int[] dp(int node, int parent, int[] price, List<Integer>[] next, int[] count) {
            int[] res = {price[node] * count[node], price[node] * count[node] / 2};
            for (int child : next[node]) {
                if (child == parent) {
                    continue;
                }
                int[] pair = dp(child, node, price, next, count);
                res[0] += Math.min(pair[0], pair[1]); // node 没有减半，因此可以取子树的两种情况的最小值
                res[1] += pair[0]; // node 减半，只能取子树没有减半的情况
            }
            return res;
        }
    }

}
