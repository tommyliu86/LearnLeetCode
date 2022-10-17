package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2022/10/15 16:02
 */
public class BuildArray {
    class Solution {
        public List<String> buildArray(int[] target, int n) {
            List<String> ans = new ArrayList<>();
            int i = 1;
            int j = 0;
            while (i <= n && j < target.length) {
                int cur = target[j];
                while (i < cur) {
                    ans.add("Push");
                    ans.add("Pop");
                    i++;
                }
                //i==cur
                ans.add("Push");
                i++;
                j++;
            }
            //不需要补全
//            while (i<=n){
//                ans.add("Push");
//                ans.add("Pop");
//                i++;
//            }
            return ans;
        }
    }
}
