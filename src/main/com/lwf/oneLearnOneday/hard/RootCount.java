package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2581. 统计可能的树根数目
 *
 * @author: liuwenfei
 * @date: 2024/2/29-18:17
 */
public class RootCount {
    /**
     * 使用深度优先遍历可以获取到以某个节点为根的所有树形的有效边
     * 暴力思路是枚举所有的节点作为根
     * 如何优化？我们通过
     */
    class Solution {
        /**
         * * 需要记录在根节点是i时，guesses中的哪个是正确，哪个是失败的，当变为j时，i~j这个边：
         * * 1.不在guesses中，则j和i相同，
         * * 2.在guesses中，则判断是否是i中的，同时进行guesses边的是否正确的设置。
         * * 因此我们需要能够记录下之前的每个根节点时的guesses的边的情况
         * <p>
         * !!!!不需要这个记录，因为我们可以直接获取到i-j和j-i这两个边，然后我们只要判断这两个边哪个在guess中即可，这样我们就知道哪个是对的了！
         *
         * @param edges
         * @param guesses
         * @param k
         * @return
         */
        public int rootCount(int[][] edges, int[][] guesses, int k) {
            int n = edges.length + 1;
            List<Integer>[] nodes = new List[n];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 0; i < edges.length; i++) {
                nodes[edges[i][0]].add(edges[i][1]);
                nodes[edges[i][1]].add(edges[i][0]);
            }

            //guess中的节点和index的映射，用来快速定位到节点
            Set<Integer> gueMap = new HashSet<>();
            int[] counts = new int[n];
            for (int i = 0; i < guesses.length; i++) {
                int[] guess = guesses[i];
                gueMap.add(guess[0] * 1000_00 + guess[1]);
            }
            counts[0] = dfs(nodes, gueMap, 0, -1);

            for (int i = 1; i < n; i++) {
                //向后遍历每个根节点，然后找到每个根节点中的连接节点且小于i的作为父节点来进行count的计算
                List<Integer> node = nodes[i];
                for (int j = 0; j < node.size(); j++) {
                    if (node.get(j) < i) {

                        Integer parent = node.get(j);

                        counts[i] = counts[parent];

                        int key1 = parent * 1000_00 + i;
                        int key2 = i * 1000_00 + parent;
                        if (gueMap.contains(key1)) {
                            counts[i]--;
                        }
                        if (gueMap.contains(key2)) {
                            counts[i]++;
                        }
                    }
                }
            }
            int rtn = 0;
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] >= k)
                    rtn++;
            }
            return rtn;
        }

        public int dfs(List<Integer>[] nodes, Set<Integer> gueMap, int cur, int parent) {
            List<Integer> sub = nodes[cur];
            if (sub.size() == 0) {
                return 0;
            }
            int ans = 0;
            for (int i = 0; i < sub.size(); i++) {
                Integer subNode = sub.get(i);
                if (subNode == parent) {
                    continue;
                }
                int key = cur * 1000_00 + subNode;
                if (gueMap.contains(key)) {
                    ans++;
                }
                ans += dfs(nodes, gueMap, subNode, cur);
            }
            return ans;
        }

    }
}
