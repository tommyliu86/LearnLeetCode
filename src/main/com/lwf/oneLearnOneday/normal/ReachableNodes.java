package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2368. 受限条件下可到达节点的数目
 * 深度有限遍历   ，并查集的合并连通块！
 * @author: liuwenfei
 * @date: 2024/3/4-9:38
 */
public class ReachableNodes {
    class Solution {
        public int reachableNodes(int n, int[][] edges, int[] restricted) {
            Set<Integer> restricts = new HashSet<>();
            for (int i : restricted) {
                restricts.add(i);
            }
            List<Integer>[] nodes = new List[n];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                if (!restricts.contains( edge[1])) {
                    nodes[edge[0]].add(edge[1]);
                }
                if (!restricts.contains(edge[0])) {
                    nodes[edge[1]].add(edge[0]);
                }
            }
            return  dfs(nodes,0,-1,restricts);
        }
        public int dfs(List<Integer>[] nodes, int node, int parent, Set<Integer> res) {
            if (res.contains(node)) {
                return 0;
            }
            int ans = 1;
            List<Integer> subNode = nodes[node];
            for (Integer i : subNode) {
                if (parent != i && !res.contains(i)) {
                    ans += dfs(nodes, i, node, res);
                }
            }
            return ans;
        }
    }

    /**
     * 常规思路，构建set保留所有的res节点，然后构建出节点数，通过深度优先遍历，找到所有可达节点
     */
    class Solution1 {
        public int reachableNodes(int n, int[][] edges, int[] restricted) {
            Set<Integer> restricts = new HashSet<>();
            for (int i : restricted) {
                restricts.add(i);
            }
            List<Integer>[] nodes = new List[n];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                nodes[edge[0]].add(edge[1]);
                nodes[edge[1]].add(edge[0]);
            }
            return dfs(nodes, 0, -1, restricts);

        }

        public int dfs(List<Integer>[] nodes, int node, int parent, Set<Integer> res) {
            if (res.contains(node)) {
                return 0;
            }
            int ans = 1;
            List<Integer> subNode = nodes[node];
            for (Integer i : subNode) {
                if (parent != i && !res.contains(i)) {
                    ans += dfs(nodes, i, node, res);
                }
            }
            return ans;
        }
    }
}
