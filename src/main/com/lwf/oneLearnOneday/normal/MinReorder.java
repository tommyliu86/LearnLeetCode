package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1466. 重新规划路线
 * @author liuwenfei
 * @date 2023/12/7 9:30
 */
public class MinReorder {
    /**
     * 广度优先遍历，因为构成的是一颗树，且题目保证了肯定没有环的存在，因此，我们可以获取每个节点的from和to数组，从0开始遍历可达节点，
     * 统计需要反向操作的数量即可。
     * 深度优先遍历，可以从0出发，深度遍历到所有的路径。
     */
    class Solution {
        public int minReorder(int n, int[][] connections) {
            List<Integer>[] from=new List[n];
            for (int i = 0; i < from.length; i++) {
                from[i]=new ArrayList<>();
            }
            List<Integer>[] to=new List[n];
            for (int i = 0; i < to.length; i++) {
                to[i]=new ArrayList<>();
            }
            for (int i = 0; i < connections.length; i++) {
                from[connections[i][0]].add(connections[i][1]);
                to[connections[i][1]].add(connections[i][0]);
            }
            int[] marks=new int[n];
            marks[0]=1;
            int count=0;
            Queue<Integer> queue=new LinkedList<>();
            queue.offer(0);
            while (!queue.isEmpty()){
                Integer poll = queue.poll();

                for (Integer integer : from[poll]) {
                    if (marks[integer]==1){
                        continue;
                    }
                    queue.offer(integer);
                    marks[integer]=1;
                    count++;
                }
                for (Integer integer : to[poll]) {
                    if (marks[integer]==1){
                        continue;
                    }
                    marks[integer]=1;
                    queue.offer(integer);
                }
            }
            return count;
        }
        int sum=0;
        public void dfs(List<Integer>[] from,List<Integer>[] to,int[] marks,int i){
            for (Integer integer : from[i]) {
                if (marks[integer]==1){
                    continue;
                }
                marks[integer]=1;
                sum++;
                dfs(from,to,marks,integer);
            }
            for (Integer integer : to[i]) {
                if (marks[integer]==1){
                    continue;
                }
                marks[integer]=1;
                dfs(from,to,marks,integer);
            }
        }
    }

    /**
     * 深度优先遍历
     */
    class Solution1 {
        public int minReorder(int n, int[][] connections) {
            List<Integer>[] from=new List[n];
            for (int i = 0; i < from.length; i++) {
                from[i]=new ArrayList<>();
            }
            List<Integer>[] to=new List[n];
            for (int i = 0; i < to.length; i++) {
                to[i]=new ArrayList<>();
            }
            for (int i = 0; i < connections.length; i++) {
                from[connections[i][0]].add(connections[i][1]);
                to[connections[i][1]].add(connections[i][0]);
            }
            int[] marks=new int[n];
            marks[0]=1;
            dfs(from,to,marks,0);
            return sum;
        }
        int sum=0;
        public void dfs(List<Integer>[] from,List<Integer>[] to,int[] marks,int i){
            for (Integer integer : from[i]) {
                if (marks[integer]==1){
                    continue;
                }
                marks[integer]=1;
                sum++;
                dfs(from,to,marks,integer);
            }
            for (Integer integer : to[i]) {
                if (marks[integer]==1){
                    continue;
                }
                marks[integer]=1;
                dfs(from,to,marks,integer);
            }
        }
    }
}
