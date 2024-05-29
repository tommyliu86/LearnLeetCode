package com.lwf.oneLearnOneday.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2951. 找出峰值
 *
 * @author: liuwenfei
 * @date: 2024/5/28-8:44
 */
public class FindPeaks {
    class Solution {
        public List<Integer> findPeaks(int[] mountain) {
            List<Integer> ans=new ArrayList<>();
            for (int i = 1; i < mountain.length-1; i++) {
                if (mountain[i]>mountain[i-1]&&mountain[i]>mountain[i+1]) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
}
