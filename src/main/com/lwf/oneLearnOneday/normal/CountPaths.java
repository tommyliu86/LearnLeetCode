package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * 1976. 到达目的地的方案数
 * 需要使用 Dijkstra算法：https://leetcode.cn/problems/number-of-ways-to-arrive-at-destination/solutions/2668041/zai-ji-suan-zui-duan-lu-de-tong-shi-dpfu-g4f3/?envType=daily-question&envId=2024-03-04
 * floyd 算法一般使用递归或dp，找到所有的两个点之间的最小距离，用在需要使用全量数据的时候会更好
 * dijkstra算法则是直接求解两点间的距离，更适合用在单点问题上
 *
 * @author: liuwenfei
 * @date: 2024/3/5-16:10
 */
public class CountPaths {
    /**
     * 错误解法，因为道路是双向链接的，因此如果一个底部节点先被访问到了，会反向把路径给走掉，导致更新不到这个节点了
     * 因此需要使用Dijkstra算法才行
     */
    class Solution {
        public int countPaths(int n, int[][] roads) {
            int[][] nodes = new int[n][n];
            for (int[] road : roads) {
                nodes[road[0]][road[1]] = road[2];
                nodes[road[1]][road[0]] = road[2];
            }
            //从节点0开始向后走，到达每个节点的最小路径的值放入到节点花费时间中，进行遍历
            long[] costs = new long[n];
            Arrays.fill(costs, -1);
            costs[0] = 0;
            //记录是否已经是最小
            boolean[] mark = new boolean[n];
            //记录从0到节点的最小长度的路线数目
            long[] counts = new long[n];
            counts[0] = 1;


            //直接的for循环，我们在内部使用找到节点n-1 变成最小值的时候就停止

            for (int k = 0; k < n; k++ ) {
                //找到没有使用过的节点中的最小节点
                long min = Long.MAX_VALUE;
                int indez = 0;
                for (int i = 0; i < costs.length; i++) {
                    if (!mark[i]&& costs[i] != -1&& costs[i] < min) {
                        min = costs[i];
                        indez = i;
                    }
                }
                mark[indez]=true;

                int[] node = nodes[indez];
                //遍历要移动的节点可以链接的节点进行更新
                for (int i = 0; i < node.length; i++) {
                    //这里需要判断没有mark过的节点并且这个节点和indez相连接
                    if (!mark[i]&&node[i]!=0){
                        //原来没链接
                        if (costs[i]==-1||costs[i]>costs[indez]+node[i]){
                            costs[i]=costs[indez]+node[i];
                            counts[i]=counts[indez];
                        } else if (costs[i]==costs[indez]+node[i]) {
                            counts[i]=(counts[i]+ counts[indez])%1000_000_007;
                        }
                    }
                }
            }
            return (int) counts[n-1];
        }
    }
}
