package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * https://leetcode-cn.com/problems/the-time-when-the-network-becomes-idle/
 * 2039. 网络空闲的时刻
 * @author: liuwenfei14
 * @date: 2022-03-20 19:05
 */
public class NetworkBecomesIdle {
    class Solution {
        public int networkBecomesIdle(int[][] edges, int[] patience) {
            //每个顶点直接向连接的其他顶点，由于图中相邻节点一般不止一个，而且有向上向下的，因此一般全部
            //都保存下来，在BFS or DFS时，通过使用一个boolean[]数组来表示一个节点列表，并且值记录是否已经访问过来控制访问的方向。
            List<Integer>[] neighbors=new List[patience.length];
            for (int i = 0; i < neighbors.length; i++) {
                neighbors[i]=new ArrayList<>();
            }
            //通过遍历edges来构建出所有相邻节点值列表
            for (int[] edge : edges) {
                int a = edge[0];
                int b = edge[1];
                neighbors[a].add(b);
                neighbors[b].add(a);
            }
            boolean[] points=new boolean[patience.length];
            points[0]=true;
            Queue<Integer> queue=new LinkedList<>();
            int depth=1;
            int times=0;
            queue.add(0);
            while (!queue.isEmpty()){
                int currentSize = queue.size();
                for (int i = 0; i < currentSize; i++) {
                    Integer curr = queue.poll();
                    for (Integer integer : neighbors[curr]) {
                        if (!points[integer]) {
                            queue.add(integer);
                            int curTime=patience[integer]*((2*depth-1)/patience[integer])+2*depth+1;
                            times=Math.max(times,curTime);
                            points[integer]=true;
                        }
                    }

                }
                depth++;
            }
            return times;
        }
    }
}
