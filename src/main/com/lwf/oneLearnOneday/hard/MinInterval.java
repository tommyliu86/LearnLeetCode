package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuwenfei
 * @date 2023/7/18 8:43
 */
public class MinInterval {
    /**
     * 并查集
     * 换个角度，对每个区间，去回答包含这个区间的询问。
     *
     * 按照区间长度从小到大排序，遍历每个区间，我们可以直接回答在该区间内的尚未被回答的询问，这是因为区间是按长度从小到大排序的，这些未被回答的询问所需要找的最小区间就是当前区间。
     *
     * 由于一个区间内可能存在已经被回答过的询问，所以我们需要跳过这些询问，这可以用并查集来维护，当我们回答一个区间时，将区间所有元素指向其下一个元素，这样当我们用并查集查询到一个回答完毕的区间的左端点时，自然就跳到了区间的右端点的右侧。
     *
     * 作者：endlesscheng
     * 链接：https://leetcode.cn/problems/minimum-interval-to-include-each-query/solution/an-qu-jian-chang-du-pai-xu-chi-xian-bing-6jzs/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int[] minInterval(int[][] intervals, int[] queries) {
            // 按照区间长度由小到大排序，这样每次回答的时候用的就是 长度最小的区间
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[1] - o[0]));

            int m = queries.length;
            // pos, i
            int[][] qs = new int[m][2];
            for (int i = 0; i < m; i++) {
                qs[i] = new int[]{queries[i], i};
            }
            // 离线：按查询位置排序
            Arrays.sort(qs, Comparator.comparingInt(o -> o[0]));

            DSU dsu = new DSU(m + 1);
            int[] ans = new int[m];
            Arrays.fill(ans, -1);
            for (int[] interval : intervals) {
                int l = interval[0], r = interval[1];

                // 二分找大于等于区间左端点的最小询问
                int left = 0;
                int right = m;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (qs[mid][0] >= l) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                //并查集来简化查询
                for (int i = dsu.find(left); i < m && qs[i][0] <= r; i = dsu.find(i + 1)) {
                    ans[qs[i][1]] = r - l + 1;
                    dsu.fa[i] = i + 1;
                }
            }
            return ans;
        }

        /**
         * 并查集 下标index如果查找过了，就指向下一个index，这样 find(i)时，获取的就是比i大的最近的一个没有查找过的，通过这个来避免每次都遍历一遍！
         */
        private  class DSU {
            int[] fa;

            public DSU(int n) {
                fa = new int[n];
                for (int i = 0; i < n; i++) {
                    fa[i] = i;
                }
            }

            int find(int x) {
                if (x != fa[x]) {
                    fa[x] = find(fa[x]);
                }
                return fa[x];
            }
        }
    }

    /**
     * 暴力解题，直接遍历 超时
     */
    class Solution1 {
        public int[] minInterval(int[][] intervals, int[] queries) {
            int[] mins = new int[10000000];
            Arrays.fill(mins, -1);
            for (int i = 0; i < intervals.length; i++) {
                for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
                    if (mins[j] == -1) {
                        mins[j] = intervals[i][1] - intervals[i][0] + 1;
                    } else {

                        mins[j] = Math.min(mins[j], intervals[i][1] - intervals[i][0] + 1);
                    }
                }
            }
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                ans[i] = mins[queries[i]];
            }
            return ans;
        }
    }
}
