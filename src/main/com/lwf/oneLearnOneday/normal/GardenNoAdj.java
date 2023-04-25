package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/4/15 9:54
 */
public class GardenNoAdj {
    /**
     * map存储所有相邻，然后直接选择即可，
     */
    class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();

        public int[] gardenNoAdj(int n, int[][] paths) {
            int[] ans = new int[n];

            for (int i = 0; i < paths.length; i++) {
                int[] path = paths[i];
                put(path[0], path[1]);
            }
            for (int i = 0; i < ans.length; i++) {
                if (!map.containsKey(i + 1)) {
                    ans[i] = 1;
                } else {
                    List<Integer> integers = map.get(i + 1);
                    int mark = 0;
                    for (int j = 0; j < integers.size(); j++) {
                        Integer index = integers.get(j);
                        mark |= ans[index - 1] == 0 ? 0 : (1 << ans[index - 1]);
                    }
                    for (int j = 1; j <= 4; j++) {
                        if ((mark & (1 << j)) == 0) {
                            ans[i] = j;
                            break;
                        }
                    }
                }
            }
            return ans;

        }

        public void put(int a, int b) {
            List<Integer> list = map.getOrDefault(a, new ArrayList<>());
            list.add(b);
            map.put(a, list);
            List<Integer> listb = map.getOrDefault(b, new ArrayList<>());
            listb.add(a);
            map.put(b, listb);
        }
    }
}
