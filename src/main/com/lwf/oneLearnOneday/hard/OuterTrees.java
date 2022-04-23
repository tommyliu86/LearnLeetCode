package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 不想做了。。下次再做这个i
 * @author: liuwenfei14
 * @date: 2022-04-23 09:08
 */
public class OuterTrees {
    class Solution {
        public int[][] outerTrees(int[][] trees) {
            int[][] rtn = new int[trees.length][2];
            Arrays.sort(trees, (a, b) -> a[0] == b[0] ? (a[1] - b[1]) : (a[0] - b[0]));

            boolean[] mark = new boolean[trees.length];
            List<int[]> list = new ArrayList<>();
            list.add(trees[0]);
            mark[0] = true;
            int[] pre = trees[0];
            int count = 1;
            while (count < trees.length && (count == 1 || pre != trees[0])) {
                int cur=-1;
                for (int i = 0; i < mark.length; i++) {
                    if (mark[i]){
                        continue;
                    }
                    if (cur==-1){
                        cur=i;
                    }else{
//                        if (cross(pre,trees[cur],trees[i]))
                    }

                }
            }
            return list.toArray(new int[list.size()][2]);
        }

        public int cross(int[] p, int[] q, int[] r) {
            return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
        }


    }
}
