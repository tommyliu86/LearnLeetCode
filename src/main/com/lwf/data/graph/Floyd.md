# floyd 算法
> floyd算法用于求 图中两个点之间的最短路径，核心思路是通过状态转移方程，来进行
> 
>[宫水题解](https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/solutions/2526052/gong-shui-san-xie-han-gai-suo-you-cun-tu-svq7/?envType=daily-question&envId=2023-11-14)
> 
>[灵神题解](https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/solutions/2525946/dai-ni-fa-ming-floyd-suan-fa-cong-ji-yi-m8s51/?envType=daily-question&envId=2023-11-14)

# 思路
![floyd_img_5](floyd_img_5.png)

# 递归方程
定义 dfs(k,i,j) 表示从 i 到 j 的最短路长度，并且这条最短路的中间节点编号都 <=k。注意中间节点不包含 i 和 j。

根据上面的讨论：

1. 不选 k，那么中间节点的编号都 <=k-1，即 dfs(k,i,j)=dfs(k−1,i,j)。
2. 选 k，问题分解成从 i 到 k 的最短路，以及从 k 到 j 的最短路。由于这两条最短路的中间节点都不包含 k，所以中间节点的编号都 <=k-1，故得到 dfs(k,i,j)=dfs(k−1,i,k)+dfs(k−1,k,j)

这两种情况取最小值，就得到了 dfs(k,i,j)写成式子就是

dfs(k,i,j)=Math.min(dfs(k−1,i,j),dfs(k−1,i,k)+dfs(k−1,k,j))
递归边界：dfs(−1,i,j)=graph[i][j] 
k=−1 表示 i 和 j 之间没有任何中间节点，此时最短路长度只能是连接 i 和 j 的边的边权

递归入口：dfs(n−1,i,j)，表示从 i 到 j 的最短路长度。

递归写法
```java
public class Floyd {
    public int floyd(int[][] graph, int i, int j, int k) {
        if (k < 0) {
            return graph[i][j];
        }
        return Math.min(floyd(graph, i, j, k - 1), floyd(graph, i, k, k - 1) + floyd(graph, k, j, k - 1));
    }
}
```
递归+记忆化写法

```java
public class Floyd {
    //增加一个memory用来记忆
    public int floyd(int[][] graph,int i,int j,int k,int[][][] memory){
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
```

递归改为DP动态规划的递推写法
```java
public class Floyd {
    /**
     * 递推写法
     *
     * @param graph 表示原始的矩阵
     * @return 表示 i，j之间的最小路径
     */
    public int[][] floyd2(int[][] graph) {
        int n = graph.length;
        //其中的第一维表示的是可访问的元素最大值，这里的递推因为每次k变大之后，都会使用原来的k-1的值，因此我们使用三维数组来进行记忆化
        int[][][] minMatrix = new int[n + 1][n][n];
        minMatrix[0] = graph;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //把从顶向下变成了从低向上，变成了一个dp算法。
                    minMatrix[k + 1][i][j] = Math.min(minMatrix[k][i][j], minMatrix[k][i][k] + minMatrix[k][k][j]);
                }
            }
        }
        return minMatrix[n - 1];
    }
}
```