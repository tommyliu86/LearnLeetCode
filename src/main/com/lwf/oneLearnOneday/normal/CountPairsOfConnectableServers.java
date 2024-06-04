package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 3067. 在带权树网络中统计可连接服务器对数目
 *
 * @author: liuwenfei
 * @date: 2024/6/4-8:58
 */
public class CountPairsOfConnectableServers {
    /**
     * 深度遍历dfs
     */
    class Solution {
        public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
            //构建链接矩阵
            List<int[]>[] pairs=new List[edges.length+1];
            for (int i = 0; i < pairs.length; i++) {
                pairs[i]=new ArrayList<>();
            }
            for (int[] edge : edges) {
                pairs[edge[0]].add(new int[]{edge[1],edge[2]});
                pairs[edge[1]].add(new int[]{edge[0],edge[2]});
            }

            int[] ans=new int[pairs.length];

            for (int i = 0; i < pairs.length; i++) {
                if (pairs[i].size()<2){
                    continue;
                }
                List<int[]> list = pairs[i];
                List<Integer> counts=new ArrayList<>(list.size());
                for (int[] ints : list) {
                    counts.add(dfs(pairs,i,ints[0],ints[1] ,signalSpeed));
                }
                ans[i]=calc(counts);
            }
            return ans;

        }

        private int calc(List<Integer> counts) {
            int ans=0;
            for (int i = 0; i < counts.size()-1; i++) {
                for (int j = i+1; j < counts.size(); j++) {
                    ans+=counts.get(i)*counts.get(j);
                }
            }
            return ans;
        }

        public int dfs(List<int[]>[] pairs,int parent, int x,int l,int c){
            int ans=0;
            if (l%c==0) {
                ans++;
            }
            List<int[]> pair = pairs[x];
            for (int i = 0; i < pair.size(); i++) {
                int[] ints = pair.get(i);
                if (ints[0]==parent) {
                    continue;
                }
                ans+=dfs(pairs,x,ints[0],l+ints[1],c);
            }
            return ans;
        }
    }
}
