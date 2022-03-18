package com.lwf.TOP100.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *https://leetcode-cn.com/problems/count-nodes-with-the-highest-score/submissions/
 * 2049. 统计最高分的节点数目
 * @author: liuwenfei14
 * @date: 2022-03-18 14:03
 */
public class CountHighestScoreNodes {
    /**
     * max需要使用long，10^5次方的长度，多次乘法可能会超过int.max_value
     * @param parents
     * @return
     */
    public int countHighestScoreNodes(int[] parents) {

         children=new List[parents.length];
         len=parents.length;

        for (int i = 0; i < children.length; i++) {
            children[i]=new ArrayList<>();
        }
        for (int i = 0; i < parents.length; i++) {
            if (parents[i]!=-1){
                children[parents[i]].add(i);
            }
        }
        dfs(0);
        return count;
    }
    List<Integer> [] children;
    long max=0;
    int count =0;
    int len;
    public int dfs(int node) {
        long score = 1;
        int size = len - 1;
        for (int c : children[node]) {
            int t = dfs(c);
            score *= t;
            size -= t;
        }
        if (node != 0) {
            score *= size;
        }
        if (score == max) {
            count++;
        } else if (score > max) {
            max = score;
            count = 1;
        }
        return len - size;
    }



}
