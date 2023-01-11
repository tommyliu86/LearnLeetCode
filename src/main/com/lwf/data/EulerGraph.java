package com.lwf.data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2023/1/11 9:50
 */
public class EulerGraph {
    /**
     * 欧拉回路：通过图中所有边一次且仅一次行遍所有顶点的回路称为欧拉回路
     * 欧拉回路要求所有的点的入度和出度相同，
     */

    /**
     * https://leetcode.cn/problems/cracking-the-safe/solution/by-lcbin-23gq/
     */
     class CrackSafe{
        class Solution {
            StringBuilder sb = new StringBuilder();
            int n, k, mod;
            //判断每条边是否访问过,这里面放入的是节点+边，这样就可以记录遍历的边是否走过了
            Set<Integer> vis = new HashSet<>();
            public String crackSafe(int N, int K) {
                n = N; k = K; mod = (int)Math.pow(10, n - 1);
                dfs(0); //从0点出发
                //因为直接使用的integer作为节点，因此到最后是没有补零的，需要把最后一个全部为0的补上
                sb.append("0".repeat(n - 1));
                return sb.toString();
            }

            /**
             * u 是一个节点，这个节点的值不管是多少，它的位数都是n-1！
             * @param u
             */
            void dfs(int u) {
                for (int i = 0; i < k; i++) { //对于每个点循环k条边即可
                    int v = u * 10 + i; //即边的编号
                    if (vis.contains(v)) continue;
                    vis.add(v);    //标记该边已经访问
                    //除余用来进行去除最高位的数字！小技巧
                    dfs(v % mod); //去掉第一位为结点编号
                    sb.append(i); //添加最后一个数字
                }
            }
        }
    }
}
