package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2127. 参加会议的最多员工数
 * https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/description/?envType=daily-question&envId=2023-11-01
 *
 * @author liuwenfei
 * @date 2023/11/1 9:10
 */
public class MaximumInvitations {

    /**
     * 拓扑排序
     * 拓扑排序 中
     * 1. 需要考虑 入度 和出度，
     * 2. 需要有点和指向的点 或者说 要是有向图
     * 3. 计算入度和出度，一般做法是从叶子节点，也就是入度为0的点，进行反向的遍历，当去掉叶子节点后，如果入度也变为0，则会成为新的叶子节点，就可以使用深度遍历继续进行
     * <p>
     * <p>
     * 内向基环树：从 iii 向 favorite[i]\textit{favorite}[i]favorite[i] 连边，可以得到一张有向图。由于每个大小为 kkk 的连通块都有 kkk 个点和 kkk 条边，所以每个连通块必定有且仅有一个环，且由于每个点的出度均为 111，这样的有向图又叫做内向基环树 (pseudotree)，由基环树组成的森林叫基环树森林 (pseudoforest)。
     * 灵神解题
     * https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/solutions/1187830/nei-xiang-ji-huan-shu-tuo-bu-pai-xu-fen-c1i1b/
     */
    class Solution {
        public int maximumInvitations(int[] favorite) {
            //入度记录
            int[] degrees = new int[favorite.length];

            for (int i = 0; i < favorite.length; i++) {
                degrees[favorite[i]]++;
            }
            //遍历记录叶子节点，也就是入度为0的，进行剪枝
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < degrees.length; i++) {
                if (degrees[i] == 0) {
                    queue.offer(i);
                }
            }
            //记录反向，喜欢当前的人的
            List<Integer>[] fav = new List[favorite.length];
            for (int i = 0; i < fav.length; i++) {
                fav[i] = new ArrayList<>();
            }
            //反向记录喜欢人的可以放在这里，因为只有剪枝掉的需要记录，
            while (!queue.isEmpty()) {
                Integer i = queue.poll();

                fav[favorite[i]].add(i);
                degrees[favorite[i]]--;
                //剪枝之后变成叶子节点，则表示这个节点也不在环上
                if (degrees[favorite[i]] == 0) {
                    queue.offer(favorite[i]);
                }
            }
            //此时在degrees中记录的就是所有的环上的节点，
            int max = 0, sum = 0;
            for (int i = 0; i < degrees.length; i++) {
                if (degrees[i] != 0) {
                    degrees[i] = 0;
                    int cursor = favorite[i];
                    int l = 1;
                    while (cursor != i) {
                        l++;
                        degrees[cursor] = 0;
                        cursor = favorite[cursor];
                    }
                    if (l > 2) {
                        max = Math.max(max, l);
                    } else {
                        //注意这里不能使用cursor，因为cursor遍历完成后会==i
                        sum += dfs(i, fav) + dfs(favorite[i], fav);
                    }
                }
            }
            return Math.max(max, sum);
        }

        /**
         * 递归获取深度
         *
         * @param i
         * @param fav
         * @return
         */
        public int dfs(int i, List<Integer>[] fav) {
            int ans = 0;
            for (int j = 0; j < fav[i].size(); j++) {
                ans = Math.max(ans, dfs(fav[i].get(j), fav));
            }
            return ans + 1;
        }
    }
}
