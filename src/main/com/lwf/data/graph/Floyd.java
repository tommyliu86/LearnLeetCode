package com.lwf.data.graph;

/**
 * @author liuwenfei
 * @date 2023/11/16 14:41
 */
public class Floyd {

    /**
     * floyd 算法通过 递归、递推，来直接计算指定的两个点之间的最短边，其核心思想是dp的状态转移方程，通过枚举两个点之间的剩余所有点，
     * 从大到小把问题拆分成更小的子问题，floyd(k,i,j)=math.min(floyd(k-1,i,j),floyd(k-1,i,k)+floyd(k-1,k,j)
     * 思路：假设 （i，j）之外剩余的点的集合，最大点是k，则我们可以有：
     * 1. 最短路径通过点k，则这条路径的最短 是floyd（k-1，i，k）+floyd（k-1，k，j） 此时拆分成了两个子问题
     * 2. 最短路径不通过k，则剩余点集合 去除了k，最大值变成了k-1，因此最短路径变成了 floyd（k-1，i，j）
     *
     * @param graph 两个点之间的邻接矩阵表示
     * @param i 点i
     * @param j 点j
     * @param k  剩余集合中的最大值
     * @return 返回计算到的i到j的最短路径
     */
    public int floyd(int[][] graph, int i, int j,int k) {
        if(k<0){
            return graph[i][j];
        }
        return Math.min(floyd(graph,i,j,k-1),floyd(graph,i,k,k-1)+floyd(graph,k,j,k-1));
    }

    /**
     * 递归+记忆化
     * @param graph
     * @param i
     * @param j
     * @param k
     * @param memory
     * @return
     */
    public int floyd1(int[][] graph,int i,int j,int k,int[][][] memory){
        if (k<0){
            return graph[i][j];
        }
        if (memory[i][j][k]>0){
            return memory[i][j][k];
        }
        int min = Math.min(floyd(graph, i, j, k - 1), floyd(graph, i, k, k - 1) + floyd(graph, k, j, k - 1));
        memory[i][j][k]=min;
        return min;
    }
}
