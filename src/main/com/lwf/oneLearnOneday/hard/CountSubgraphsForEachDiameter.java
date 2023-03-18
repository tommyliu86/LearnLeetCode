package com.lwf.oneLearnOneday.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CountSubgraphsForEachDiameter {
    class Solution {
        int mask;
        int diameter;

        public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
            //每个点的连通点的记录
            List<Integer>[] adj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<Integer>();
            }
            for (int[] edge : edges) {
                int x = edge[0] - 1;
                int y = edge[1] - 1;
                adj[x].add(y);
                adj[y].add(x);
            }

            int[] ans = new int[n - 1];
            for (int i = 1; i < (1 << n); i++) {
                int x = 32 - Integer.numberOfLeadingZeros(i) - 1;
                int mask = i;
                int y = -1;
                Queue<Integer> queue = new ArrayDeque<Integer>();
                queue.offer(x);
                mask &= ~(1 << x);
                while (!queue.isEmpty()) {
                    y = queue.poll();
                    for (int vertex : adj[y]) {
                        if ((mask & (1 << vertex)) != 0) {
                            mask &= ~(1 << vertex);
                            queue.offer(vertex);
                        }
                    }
                }
                if (mask == 0) {
                    int diameter = dfs(adj, -1, y, i);
                    if (diameter > 0) {
                        ans[diameter - 1]++;
                    }
                }
            }
            return ans;
        }

        public int dfs(List<Integer>[] adj, int parent, int u, int mask) {
            int depth = 0;
            for (int v : adj[u]) {
                if (v != parent && (mask & (1 << v)) != 0) {
                    depth = Math.max(depth, 1 + dfs(adj, u, v, mask));
                }
            }
            return depth;
        }
    }


}