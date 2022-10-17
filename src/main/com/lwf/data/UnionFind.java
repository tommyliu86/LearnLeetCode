package com.lwf.data;

/**
 * @author liuwenfei
 * @date 2022/10/17 8:44
 */
public class UnionFind {
    /**
     * 并查集
     * <p>
     * 并查集是一种树形的数据结构，顾名思义，它用于处理一些不交集的合并及查询问题。 它支持两种操作：
     * <p>
     * 查找（Find）：确定某个元素处于哪个子集，单次操作时间复杂度 O(\alpha(n))O(α(n))
     * 合并（Union）：将两个子集合并成一个集合，单次操作时间复杂度 O(\alpha(n))O(α(n))
     * 其中 \alphaα 为阿克曼函数的反函数，其增长极其缓慢，也就是说其单次操作的平均运行时间可以认为是一个很小的常数。
     * <p>
     * 以下是并查集的常用模板，需要熟练掌握。其中：
     * <p>
     * n 表示节点数
     * p 存储每个点的父节点，初始时每个点的父节点都是自己
     * size 只有当节点是祖宗节点时才有意义，表示祖宗节点所在集合中，点的数量
     * find(x) 函数用于查找 xx 所在集合的祖宗节点
     * union(a, b) 函数用于合并 aa 和 bb 所在的集合
     * <p>
     * 作者：lcbin
     * 链接：https://leetcode.cn/problems/possible-bipartition/solution/by-lcbin-rgi1/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public class Solution {
        int[] p;
        int[] size;

        Solution(int n) {
            p = new int[n];
            size = new int[n];
            for (int i = 0; i < n; ++i) {
                p[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (p[x] != x) {
                // 路径压缩 查找到根之后，把根赋值给所有的节点，让所有子节点直接指向自己的根
                p[x] = find(p[x]);
            }
            return p[x];
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) {
                return;
            }
            p[pa] = pb;
            size[pb] += size[pa];
        }

    }
}
