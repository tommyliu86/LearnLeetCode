package com.lwf.oneLearnOneday.hard;

/**
 * 2127. 参加会议的最多员工数
 * https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/description/?envType=daily-question&envId=2023-11-01
 * @author liuwenfei
 * @date 2023/11/1 9:10
 */
public class MaximumInvitations {
    /**
     * 拓扑排序
     * 拓扑排序 中 1. 需要考虑 入度 和出度， 2. 需要有点和指向的点 或者说 要是有向图
     * 内向基环树：从 iii 向 favorite[i]\textit{favorite}[i]favorite[i] 连边，可以得到一张有向图。由于每个大小为 kkk 的连通块都有 kkk 个点和 kkk 条边，所以每个连通块必定有且仅有一个环，且由于每个点的出度均为 111，这样的有向图又叫做内向基环树 (pseudotree)，由基环树组成的森林叫基环树森林 (pseudoforest)。
     * 灵神解题
     * https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/solutions/1187830/nei-xiang-ji-huan-shu-tuo-bu-pai-xu-fen-c1i1b/
     */
    class Solution {
        public int maximumInvitations(int[] favorite) {

        }
    }
}
