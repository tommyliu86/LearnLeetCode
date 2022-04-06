package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-06 09:53
 */
public class FindMinHeightTrees {
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> rtn=new ArrayList<>();
            if (n==1){
                rtn.add(0);
                return  rtn;
            }
            //1. 先找到所有节点的相连节点
            List<Integer>[] neighber=new List[n];
            for (int i = 0; i < neighber.length; i++) {
                neighber[i]=new ArrayList<>();
            }
            for (int[] edge : edges) {
                neighber[edge[0]].add(edge[1]);
                neighber[edge[1]].add(edge[0]);
            }
            int[] parent=new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i]=-1;
            }
            int left = findIndex(0, neighber, parent);
            int right = findIndex(left, neighber, parent);

            List<Integer> path=new ArrayList<>();
            parent[left]=-1;
            while (right!=-1){
                path.add(right);
                right=parent[right];
            }
            int size = path.size();
            if (size%2==0){
                rtn.add(path.get(size/2-1));
                rtn.add(path.get(size/2));
            }else{
                rtn.add(path.get(size/2));
            }
            return rtn;

        }

        /**
         * 广度优先算法遍历 树的节点。
         * @param rootIndex
         * @param neighber
         * @return
         */
        private int findIndex(int rootIndex,List<Integer>[] neighber, int[] parent){
            int[] visited=new int[neighber.length];
            Queue<Integer> queue=new LinkedList<>();
            visited[rootIndex]=1;
            queue.add(rootIndex);

            int lastIndex=rootIndex;
            while (!queue.isEmpty()){
                Integer curr = queue.poll();
                lastIndex=curr;
                for (Integer i : neighber[curr]) {
                    if (visited[i]!=1){
                        //必须放里面，不然每次会遍历到所有相关节点。
                        parent[i]=curr;
                        visited[i]=1;
                        queue.add(i);
                    }
                }
            }
            return lastIndex;

        }

    }
}
