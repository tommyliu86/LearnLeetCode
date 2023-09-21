package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 拓扑排序
 * @author liuwenfei
 * @date 2023/9/21 8:55
 */
public class CollectTheCoins {
    /**
     * 无根，因此需要记录相互的依赖关系
     * 重在思路，反向考虑，从叶子出发进行遍历的方法
     */
    class Solution {
        public int collectTheCoins(int[] coins, int[][] edges) {
            int[] degrees=new int[coins.length];
            List<Integer>[] relations=new List[coins.length];
            for (int i = 0; i < relations.length; i++) {
                relations[i]=new ArrayList<>();
            }
            for (int[] edge : edges) {
                degrees[edge[0]]++;
                degrees[edge[1]]++;
                relations[edge[0]].add(edge[1]);
                relations[edge[1]].add(edge[0]);
            }
            //使用遍历所有叶子节点，然后从叶子节点开始删除无用节点
            Queue<Integer> queue=new LinkedList<>();
            for (int i = 0; i < degrees.length; i++) {
                if (degrees[i]==1&&coins[i]==0) {
                    queue.offer(i);
                }
            }
            //剩余的节点个数
            int rest=coins.length;
            while (!queue.isEmpty()){
                Integer poll = queue.poll();
                rest--;
                degrees[poll]--;
                for (Integer i : relations[poll]) {
                    degrees[i]--;
                    if (degrees[i]==1&&coins[i]==0){
                        queue.offer(i);
                    }
                }
            }
            //剩余的叶子节点都是有金币的。这时我们从节点向内删除两层，剩余的是必须遍历到的节点
            for (int i = 0; i < 2; i++) {
                queue=new LinkedList<>();
                for (int j = 0; j < degrees.length; j++) {
                    if (degrees[j]==1) {
                        queue.offer(j);
                    }
                }
                while (!queue.isEmpty()){
                    Integer poll = queue.poll();
                    degrees[poll]--;
                    rest--;
                    //把相邻节点减一
                    for (Integer j : relations[poll]) {
                        degrees[j]--;
                    }
                }
            }
            return rest==0?0:2*(rest-1);
        }
    }
}
