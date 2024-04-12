package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1766. 互质树
 *
 * @author: liuwenfei
 * @date: 2024/4/11-8:56
 */
public class GetCoprimes {
    /**
     * gcd写法
     */
    class Solution {
        public int[] getCoprimes(int[] nums, int[][] edges) {
            //1.值的范围已知为1~50，因此我们可以先预处理出每个点的质数集合
            int[][] gcds = new int[51][51];
            for (int i = 1; i < gcds.length; i++) {
                for (int j = i; j < gcds[i].length; j++) {
                    if (gcd(j, i) == 1) {
                        gcds[i][j] = 1;
                    }
                }
            }
            List<Integer>[] subNodes = new List[nums.length];
            for (int i = 0; i < subNodes.length; i++) {
                subNodes[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                subNodes[edge[0]].add(edge[1]);
                subNodes[edge[1]].add(edge[0]);
            }

            int[] ans = new int[nums.length];
            Arrays.fill(ans, -1);
            //dis存入最近访问时的路径上的值的坐标
            List<Integer>[] parents = new List[51];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = new ArrayList<>();
            }
            int[] dept = new int[nums.length];

            dfs(subNodes, 0, parents, ans, gcds, nums, dept, 1);

            return ans;
        }

        /**
         * 如何找到相同深度上有哪些点？
         *
         * @param subNodes
         * @param cur
         * @param parents
         * @param ans
         * @param gcds
         * @param nums
         */
        public void dfs(List<Integer>[] subNodes, int cur, List<Integer>[] parents, int[] ans, int[][] gcds, int[] nums, int[] dept, int d) {
            dept[cur] = d;
            //如果这里使用路径列表来进行循环，会导致过长路劲的超时问题。改用存储节点值对应的最深节点，这样就可以知道路径上的每个值的最接近的点的坐标，不需要for循环！
            for (int i = parents.length - 1; i >= 0; i--) {
                List<Integer> parent = parents[i];
                if (parent.size() > 0) {
                    Integer j = parent.get(parent.size() - 1);
                    if (gcds[nums[cur]][nums[j]] == 1 || gcds[nums[j]][nums[cur]] == 1) {
                        if (ans[cur] == -1) {
                            ans[cur] = j;
                        } else {
                            ans[cur] = (dept[j] > dept[ans[cur]] ? j : ans[cur]);
                        }
                    }
                }
            }
            List<Integer> subNode = subNodes[cur];
            parents[nums[cur]].add(cur);
            for (Integer i : subNode) {
                if (dept[i] > 0) {
                    continue;
                }
                dfs(subNodes, i, parents, ans, gcds, nums, dept, d + 1);
            }
            parents[nums[cur]].remove(parents[nums[cur]].size() - 1);

        }

        //辗转除余 10 5, 5,1
        public int gcd(int x, int y) {
            if (y == 0) {
                return x;
            }
            return x > y ? gcd(y, x % y) : gcd(x, y % x);
        }
    }
}
