package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/12/14 9:10
 */
public class DistanceLimitedPathsExist {
    /**
     * 离线查询 为核心思路，也就是把查询的limit从小到大排序，每次查询的limit是指定的，对于edeg的处理不要一次全部处理完，而是根据每次查询的limit
     * 把小于limit的edge进行构建，如果当前的edges中，要查询的两个点有链接，则表示成立。否则为false，大于limit的边没必要考虑！
     * 并查集  为辅助工具
     */
    class Solution {
        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
            //edge排序
            Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
            //queries的index，使用index排序来做映射，方便查询
            Integer[] indexes=new Integer[queries.length];
            for (int i = 0; i < indexes.length; i++) {
                indexes[i]=i;
            }
            Arrays.sort(indexes, (a, b) -> queries[a][2] - queries[ b][2]);
            //并查集
            int[] parents=new int[n];
            for (int i = 0; i < parents.length; i++) {
                parents[i]=i;
            }

            boolean[] ans=new boolean[queries.length];
            int eI=0;

            for (int i = 0; i < ans.length; i++) {
                int[] query = queries[indexes[i]];
                while (eI<edgeList.length&& edgeList[eI][2]<query[2]){
                    int[] ints = edgeList[eI];
                    merge(parents,ints[0],ints[1]);
                    eI++;
                }
                if (find(parents,query[0])==find(parents,query[1])){
                    ans[indexes[i]]=true;
                }
            }
            return ans;
        }
        //并查集的find，在查找过程中把所有路线上的点都指向parent
        public int find(int[] parents, int x) {
            if (parents[x] == x) {
                return x;
            }
            return parents[x] = find(parents, parents[x]);
        }
        //并查集的并，把两个点的parent合并。
        public void merge(int[] parents, int x, int y) {
            x = find(parents, x);
            y = find(parents, y);
            parents[y] = x;
        }
    }
    /**
     * 并查集如何应用？？？
     */
    class Solution1 {
        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
            Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);

            Integer[] index = new Integer[queries.length];
            for (int i = 0; i < queries.length; i++) {
                index[i] = i;
            }
            Arrays.sort(index, (a, b) -> queries[a][2] - queries[b][2]);

            int[] uf = new int[n];
            for (int i = 0; i < n; i++) {
                uf[i] = i;
            }
            boolean[] res = new boolean[queries.length];
            int k = 0;
            for (int i : index) {
                while (k < edgeList.length && edgeList[k][2] < queries[i][2]) {
                    merge(uf, edgeList[k][0], edgeList[k][1]);
                    k++;
                }
                res[i] = find(uf, queries[i][0]) == find(uf, queries[i][1]);
            }
            return res;
        }

        public int find(int[] uf, int x) {
            if (uf[x] == x) {
                return x;
            }
            return uf[x] = find(uf, uf[x]);
        }

        public void merge(int[] uf, int x, int y) {
            x = find(uf, x);
            y = find(uf, y);
            uf[y] = x;
        }
    }



    class Solution2 {
        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
            int[][] edges=new int[n][n];
            int[] parents=new int[n];
            for (int i = 0; i < parents.length; i++) {
                parents[i]=i;
            }
            for (int i = 0; i < edgeList.length; i++) {
                int[] cur = edgeList[i];
                int parent=Math.min( cur[0],cur[1]);
                int son=Math.max(cur[0],cur[1]);
                parents[son]=parent;


                int min = edges[parent][son]==0?cur[2]: Math.min(edges[parent][son], cur[2]);
                edges[parent][son]= min;
                edges[son][parent]=min;

                int next=parent;

                while (parents[next]!=next){
                    int nnext=parents[next];
                    int curM=edges[nnext] [next];
                    if (curM>min){
                        edges[son][nnext]=min;
                        edges[nnext][son]=min;
                        next=nnext;
                    }else{
                        break;
                    }
                }

            }
            boolean[] ans=new boolean[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                ans[i]=edges[query[0]][query[1]]<query[2];
            }
            return ans;
        }
    }
}
