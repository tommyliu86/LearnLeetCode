package com.lwf.oneLearnOneday.normal;

import java.util.*;

public class CountPairs {
    /**
     * 深度优先遍历，使用map存储 所有点对，然后使用深度优先，找到所有连接的分组即可。
     */
    class Solution {
        public long countPairs(int n, int[][] edges) {
            List<Integer>[] couples=new List[n];
            for (int i = 0; i < couples.length; i++) {
                couples[i]=new ArrayList<>();
            }
            for (int[] edge : edges) {
                couples[edge[0]].add(edge[1]);
                couples[edge[1]].add(edge[0]);
            }
            int[] marks=new int[n];
            List<Integer> size=new ArrayList<>();
            for (int i = 0; i < marks.length; i++) {
                if (marks[i]==0){
                    Queue<Integer> queue=new LinkedList<>();
                    queue.offer(i);
                    marks[i]=1;
                    int c=1;
                    while (!queue.isEmpty()){
                        Integer poll = queue.poll();
                        for (Integer integer : couples[poll]) {
                            if (marks[integer]==0){
                                queue.offer(integer);
                                marks[integer]=1;
                                c++;
                            }
                        }
                    }
                    size.add(c);
                }
            }
            long ans=0;
            for (Integer integer : size) {
                ans+=(long)integer*(n-integer);
            }
            return ans/2;
        }
    }

    /**
     * 并查集 典型的并查集 查找节点数即可。
     */
    class Solution1 {
        public long countPairs(int n, int[][] edges) {
            points = new int[n];
            for (int i = 0; i < points.length; i++) {
                points[i] = i;
            }
            sums = new int[n];
            Arrays.fill(sums, 1);
            for (int[] edge : edges) {
                union(edge);
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                int sum = sums[find(i)];
                ans += n - sum;
            }
            return ans / 2;
        }

        int[] points;
        int[] sums;

        private void union(int[] p) {
            int i = find(p[0]), j = find(p[1]);
            if (i != j) {
                if (i > j) {
                    int temp = i;
                    i = j;
                    j = temp;
                }
                points[j] = i;
                sums[i] += sums[j];
            }
        }

        private int find(int x) {
            if (points[x] == x)
                return x;
            //递归向上找到根父节点,并把根节点的值给到当前x指向
            return points[x] = find(points[x]);
        }
    }
}
