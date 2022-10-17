package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2022/10/16 20:56
 */
public class PossibleBipartition {
    /**
     * dfs 深度遍历，每次检查下一个元素和它的后续。同时做mark标记当前的分组
     */
    class Solution {
        public boolean possibleBipartition(int n, int[][] dislikes) {
            List<Integer>[] dis=new List[n+1];
            for (int i = 0; i < dis.length; i++) {
                dis[i]=new ArrayList<>();
            }
            for (int i = 0; i < dislikes.length; i++) {
                dis[dislikes[i][0]].add(dislikes[i][1]);
                dis[dislikes[i][1]].add(dislikes[i][0]);
            }
            int[] mark=new int[n+1];
            for (int i = 1; i < mark.length; i++) {
                if (mark[i]!=0) {
                    continue;
                }
                mark[i]=1;
                if (!dfs(i,dis,mark)){
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(int i, List<Integer>[] dis, int[] mark) {
            List<Integer> dislikes = dis[i];
            for (Integer dislike : dislikes) {
                if (mark[dislike]!=0&&mark[dislike]==mark[i]){
                    return false;
                }
                if (mark[dislike]==0){
                    mark[dislike]=-1*mark[i];
                    if (!dfs(dislike, dis, mark)){
                        return false;
                    }
                }
            }
            return true;
        }
    }
    /**
     * bfs 广度遍历
     */
    class Solution2 {
        public boolean possibleBipartition(int n, int[][] dislikes) {
            List<Integer>[] marks=new List[n+1];
            for (int i = 0; i < marks.length; i++) {
                marks[i]=new ArrayList<>();
            }
            for (int i = 0; i < dislikes.length; i++) {
                marks[dislikes[i][0]].add(dislikes[i][1]);
                marks[dislikes[i][1]].add(dislikes[i][0]);
            }
            int[] used=new int[n+1];
            for (int i = 1; i < marks.length; i++) {
                if (used[i]!=0){
                    continue;
                }
                used[i]=1;
                Queue<Integer> reds=new LinkedList<>();
                reds.add(i);
                while (!reds.isEmpty()){
                    int size = reds.size();
                    for (int j = 0; j<size; j++) {
                        Integer poll = reds.poll();
                        List<Integer> blues = marks[poll];
                        for (int k = 0; k < blues.size(); k++) {
                            if (used[blues.get(k)]==1) {
                                return false;
                            }
                            used[blues.get(k)]=-1;
                            List<Integer> subRed = marks[blues.get(k)];
                            for (Integer integer : subRed) {
                                if (used[integer]==-1) {
                                    return false;
                                }
                                if (used[integer]==0){
                                    reds.offer(integer);
                                    used[integer]=1;
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
    class Solution1 {
        public boolean possibleBipartition(int n, int[][] dislikes) {
            int[] marks=new int[n+1];
            for (int i = 0; i < dislikes.length; i++) {
                int[] dislike = dislikes[i];
                int i1 = dislike[0];
                int i2 = dislike[1];
                if (marks[i1]==0){
                    marks[i1]=(marks[i2]==0?0:(marks[i2]==1?2:1));
                }
                if (marks[i2]==0){
                    marks[i2]=(marks[i1]==0?0:(marks[i1]==1?2:1));
                }
                if (marks[i1]==marks[i2]&&marks[i1]!=0) {
                    return false;
                }
            }
            return true;
        }
    }
}
