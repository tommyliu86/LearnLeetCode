package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/2/2 10:47
 */
public class ShortestAlternatingPaths {
    class Solution {
        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            int[] ans=new int[n];
            Arrays.fill(ans,-1);
            ans[0]=0;
            Map<Integer,Set<Integer>> red=getMap(redEdges);
            Map<Integer,Set<Integer>> blue=getMap(blueEdges);

            bfs(ans,red,blue,true);
            bfs(ans,red,blue,false);
            return ans;
        }
        private void bfs(int[] ans,Map<Integer,Set<Integer>> red,Map<Integer,Set<Integer>>blue,boolean isRed){
            Queue<Integer> queue=new LinkedList<>();
            int step=0;
            int[] markRed=new int[ans.length];
            int[] markBlue=new int[ans.length];
            queue.offer(0);
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = queue.poll();
                    ans[poll]=ans[poll]==-1? step:Math.min(ans[poll],step);
                    //红绿判断
                    Set<Integer> integers;
                    if ((step%2==0&&isRed)||(step%2==1&&!isRed)){
                        integers = red.get(poll);
                        if (integers!=null){

                            for (Integer integer : integers) {
                                if (markBlue[integer]==0){
                                    queue.offer(integer);
                                    markBlue[integer]=1;
                                }
                            }
                        }
                    }else{
                        integers=blue.get(poll);
                        if (integers!=null){

                            for (Integer integer : integers) {
                                if (markRed[integer]==0){
                                    queue.offer(integer);
                                    markRed[integer]=1;
                                }
                            }
                        }
                    }
                }
                step++;
            }
        }
        private Map<Integer,Set<Integer>> getMap(int[][] ints){
            Map<Integer,Set<Integer>> map=new HashMap<>();
            for (int i = 0; i < ints.length; i++) {
                int[] redEdge = ints[i];
                Set<Integer> set = map.getOrDefault(redEdge[0], new HashSet<>());
                set.add(redEdge[1]);
                map.put(redEdge[0],set);
            }
            return map;
        }
    }
}
