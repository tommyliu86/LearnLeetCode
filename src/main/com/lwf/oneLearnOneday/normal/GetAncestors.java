package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * 2192. 有向无环图中一个节点的所有祖先
 * from home
 * author: liuwu
 * time: 2024/4/4 9:27
 */
public class GetAncestors {
    class Solution {
        /**
         * 有向无环，一般使用拓扑排序
         * @param n
         * @param edges
         * @return
         */
        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            SortedSet<Integer>[] res = new SortedSet[n];
            for (int i = 0; i < n; i++) {
                res[i]=new TreeSet<>();
            }
            //完成初始化
            int[] degree = new int[n];
            List<Integer>[] ed=new List[n];
            for (int i = 0; i < ed.length; i++) {
                ed[i]=new ArrayList<>();
            }
            //拓扑排序
            for (int[] edge : edges) {
                degree[edge[1]]++;
                ed[edge[0]].add(edge[1]);
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (degree[i] == 0) {
                    queue.add(i);
                }
            }
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer cur = queue.poll();
                    List<Integer> next = ed[cur];
                    for (Integer nex : next) {
                        degree[nex]--;
                        res[nex].add(cur);
                        res[nex].addAll(res[cur]);
                        if (degree[nex] == 0) {
                            queue.add(nex);
                        }
                    }
                }
            }
            List<List<Integer>> ans=new ArrayList<>();
            for (int i = 0; i < res.length; i++) {
                ans.add(new ArrayList<>(res[i]));
            }
            return ans;
        }
    }
}
