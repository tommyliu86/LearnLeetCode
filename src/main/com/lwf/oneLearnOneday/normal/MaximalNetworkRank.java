package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/3/15 19:11
 */
public class MaximalNetworkRank {
    /**
     * 优化失败。。。
     */
    class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            int[][] marks=new int[n][n];
            int[] counts=new int[n];
            for (int i = 0; i < roads.length; i++) {
                marks[roads[i][0]][roads[i][1]]=1;
                marks[roads[i][1]][roads[i][0]]=1;
                counts[roads[i][0]]++;
                counts[roads[i][1]]++;
            }
            Integer[] indexs=new Integer[n];
            for (int i = 0; i < indexs.length; i++) {
                indexs[i]=i;
            }
            Arrays.sort(indexs, Comparator.comparingInt(a -> counts[a]));
            Arrays.sort(counts);
            int max=counts[n-1];
            List<Integer> first=new ArrayList<>();
            List<Integer> second=new ArrayList<>();
            int fir=max,seco=max;
            boolean sec=true;
            for (int i = counts.length - 1; i >= 0; i--) {
                if (counts[i]==max) {
                    if (sec){
                        first.add(indexs[ i]);
                    }else{
                        second.add(indexs[ i]);
                    }
                }else{
                    if (first.size()>1)break;
                    if (sec==false){
                        break;
                    }else{
                        sec=false;
                        max=counts[i];
                        seco=counts[i];
                        second.add(indexs[ i]);
                    }
                }
            }
            int ans=0;
            if (first.size()>1){
                for (int i = 0; i < first.size(); i++) {
                    for (int j = i+1; j <first.size(); j++) {
                        if (marks[first.get( i)][first.get( j)]==0){
                            return fir*2;
                        }
                    }
                }
                return fir*2-1;
            }else{
                Integer findex = first.get(0);
                for (int i = 0; i < second.size(); i++) {
                    if (marks[findex][second.get(i)]==0){
                        return fir+seco;
                    }
                }
                return fir+seco-1;
            }
        }
    }
    /**
     * 暴力循环
     */
    class Solution1 {
        public int maximalNetworkRank(int n, int[][] roads) {
            int[][] marks=new int[n][n];
            int[] counts=new int[n];
            for (int i = 0; i < roads.length; i++) {
                marks[roads[i][0]][roads[i][1]]=1;
                marks[roads[i][1]][roads[i][0]]=1;
                counts[roads[i][0]]++;
                counts[roads[i][1]]++;
            }

            int max=0;
            for (int i = 0; i < counts.length-1; i++) {
                for (int j = i+1; j < counts.length; j++) {
                    max=Math.max(max,counts[i]+counts[j]-marks[i][j]);
                }
            }
            return max;
        }
    }
}
