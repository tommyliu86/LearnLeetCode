package com.lwf.learn.everyday.arith.second.day8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-20 10:39
 */
public class AllPathsSourceTarget {

    /**
     * 递归，深度优先遍历
     */
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            recursive(graph,0,new ArrayList<>());
            return rtn;
        }
        List<List<Integer>> rtn=new ArrayList<>();
        public void recursive(int[][] graph,int i,List<Integer> list){
            list.add(i);
            if (i==graph.length-1){
                rtn.add(new ArrayList<>(list));

            }else{
                int[] ints = graph[i];
                for (int j = 0; j < ints.length; j++) {
                    recursive(graph,ints[j],list);
                }
            }
            list.remove(list.size()-1);
        }
    }
}
