package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1976. 到达目的地的方案数
 * 需要使用 Dijkstra算法：https://leetcode.cn/problems/number-of-ways-to-arrive-at-destination/solutions/2668041/zai-ji-suan-zui-duan-lu-de-tong-shi-dpfu-g4f3/?envType=daily-question&envId=2024-03-04
 * @author: liuwenfei
 * @date: 2024/3/5-16:10
 */
public class CountPaths {
    /**
     * 错误解法，因为道路是双向链接的，因此如果一个底部节点先被访问到了，会反向把路径给走掉，导致更新不到这个节点了
     */
    class Solution {
        public int countPaths(int n, int[][] roads) {
            int[][] nodes=new int[n][n];
            for (int[] road : roads) {
                nodes[road[0]][road[1]]=road[2];
                nodes[road[1]][road[0]]=road[2];
            }
            //从节点0开始向后走，到达每个节点的最小路径的值放入到节点花费时间中，进行遍历
            long[] costs=new long[n];
            long[] counts=new long[n];
            counts[0]=1;
            Queue<Integer> queue=new LinkedList<>();
            queue.add(0);
            while (!queue.isEmpty()){
                Integer poll = queue.poll();
                for (int i = 0; i < nodes[poll].length; i++) {
                    boolean add=false;
                    if (nodes[poll][i]!=0) {
                        if (costs[i]==0) {
                            costs[i]=costs[poll]+ nodes[poll][i];
                            counts[i]+=counts[poll];
                            add=true;
                        }else if (costs[i]==costs[poll]+ nodes[poll][i]){
                            counts[i]+=counts[poll];
                            add=true;
                        }else if (costs[i]>costs[poll]+ nodes[poll][i]){
                            costs[i]=costs[poll]+ nodes[poll][i];
                            counts[i]=counts[poll];
                            add=true;
                        }
                        if (add&&i!=n-1){
                            queue.add(i);
                        }
                        nodes[poll][i]=0;


                    }
                }
            }
            return (int) counts[n-1]%1000_000_007;

        }
    }
}
