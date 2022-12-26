package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2022/12/19 9:09
 */
public class ValidPath {
    class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            parents = new int[n];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
            for (int i = 0; i < edges.length; i++) {
                union(edges[i][0], edges[i][1]);

            }
            return find(source) == find(destination);
        }

        int[] parents;

        public int find(int i) {
            if (parents[i] == i) {
                return i;
            }
            return parents[i] = find(parents[i]);
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            parents[px] = parents[py];

        }
    }
}
