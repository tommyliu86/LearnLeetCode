package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

public class IntersectionSizeTwo {
    /**
     * 贪心枚举所有情况
     * 1.按照first排序，按照倒序取节点对比
     * 2. 1.区间 pre，cur  存在 pre（0）<cur(0)成立，因此比较cur（0）和pre(0)\pre(1)区间的关系，
     * 这里需要先决定如何取交集，我们从后向前遍历，优先使用cur节点的头节点作为交集字段，这样的话，可以通过两个区间
     * 是否有重合来知道获取的这两个值是否在pre中存在。有如下关系：我们设取值 i=cur【0】，j=cur【0】+1
     * 后面比较时，就不应该再比较区间相交情况了。需要使用交集中的值，也就是i，j和pre[1]的情况，来看pre区间是否包含了i，j
     * 1.pre(1)<i， 表示cur和pre无交集，这时 i=pre【0】，j=pre【0】+1，然后比较下一个的情况
     *
     * 2.pre(1)>=j，表示pre已经完全包含了交集中的两个节点。
     * 3.pre(1)>=i and pre[1]<j,这种情况表示 pre区间包含了一个交集中的节点。因此需要在当前区间加一个值到交集中。
     *
     */
    class Solution {
        public int intersectionSizeTwo(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(b[1], a[1]);
                }else{
                    return Integer.compare(a[0],b[0]);
                }
            });
            int n=intervals.length;
           int rtn=2;
           int pre=intervals[n-1][0];
           int cur=intervals[n-1][0]+1;
            for (int i = n - 2; i >= 0; i--) {
                int[] node = intervals[i];
                if (node[1]>=cur){ //完全重合
                    continue;
                }else if (node[1]<pre){ //完全不重合
                    pre=node[0];
                    cur=node[0]+1;
                    rtn+=2;
                }else{ //node[1]>=pre 表示pre已经重合，这时只需要在node的区间中选择一个添加到交集中，这里都选择头节点
                    cur=pre;
                    pre=node[0];
                    rtn++;
                }
            }
            return rtn;
        }
    }
}
