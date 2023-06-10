package com.lwf.oneLearnOneday.hard;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/6/9 8:49
 */
public class ModifiedGraphEdges {
    class Solution {
        int[][] points ;
        Boolean fastDeal =null;
        Map<Integer, List<Integer>> map = new HashMap<>();
        public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
             points = new int[n][n];

            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                points[edge[0]][edge[1]] =  edge[2];
                points[edge[1]][edge[0]] = edge[2];
                inMap(edge[0], edge[1], map);
                inMap(edge[1], edge[0], map);
            }
            List<Integer> ps=new ArrayList<>();

            dfs(ps,source,target,destination);
            if (fastDeal!=null&&fastDeal==false){
                return new int[0][0];
            }
            if (fastDeal!=null&&fastDeal==true){
                for (int[] edge : edges) {
                    if (edge[2]<0) {
                        edge[2]=target;
                    }

                }
                return edges;
            }
            for (int[] edge : edges) {

                edge[2]=getEdge(edge[0],edge[1],false);

                if (edge[2]<0){
                    edge[2]=1;
                }

            }
            return edges;
        }
        private void dealEdge(List<Integer> ps,int target){
            int[] edges =new int[ps.size()-1];
            int sum=0;
            List<Integer> negtive=new ArrayList<>();
            for (int i = 0; i < edges.length; i++) {
                edges[i]=getEdge( ps.get(i),ps.get(i+1),true);
                sum+=edges[i];
                if (edges[i]<0){
                    negtive.add(i);
                }
            }

            if (negtive.size()==0){
                if (sum<target){
                    fastDeal =false;
                    return;
                }
                if (sum==target){
                    fastDeal=true;
                    return;
                }
            }else{
                for (Integer i : negtive) {
                    int edge = getEdge(ps.get(i), ps.get(i + 1), false);
                    if (edge<0){
                        setEdge(ps.get(i), ps.get(i + 1),1);
                        sum+=2;
                    }else{
                        sum+=getEdge(ps.get(i),ps.get(i+1),false)+1;
                    }
                }
                if (sum<target){
                    Integer i = negtive.get(0);
                    setEdge(ps.get(i),ps.get(i+1) ,getEdge(ps.get(i), ps.get(i + 1), false)+ target-sum);
                }
            }
        }
        private void setEdge(int i,int j,int v){

            if ( i<j){
                int t=j;
                j=i;
                i=t;
            }
             points[i][j]=v;
        }
        private int getEdge(int i,int j,boolean ori){
            if (ori&& i>j){
                int t=j;
                j=i;
                i=t;
            }
            if (!ori&& i<j){
                int t=j;
                j=i;
                i=t;
            }
            return points[i][j];
        }
        public boolean dfs(List<Integer> ps,int i,int target,int dest){
            if (i== dest){
                ps.add(i);
                 dealEdge(ps, target);
                ps.remove(ps.size()-1);

                return  fastDeal==null;
            }
            if (!map.containsKey(i)){
                return true;
            }
            ps.add(i);
            for (Integer integer : map.get(i)) {
                if (ps.contains(integer)){
                    continue;
                }
                if(! dfs(ps,integer,target,dest)){
                    return false;
                }
            }
            ps.remove(ps.size()-1);
            return true;
        }

        public void inMap(Integer i1, Integer i2, Map<Integer, List<Integer>> map) {
            List<Integer> e0 = map.getOrDefault(i1, new ArrayList<>());
            e0.add(i2);
            map.put(i1, e0);
        }
    }
}
