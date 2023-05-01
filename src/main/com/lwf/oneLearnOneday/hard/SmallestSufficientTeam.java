package com.lwf.oneLearnOneday.hard;

import java.util.*;

public class SmallestSufficientTeam {
    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        List<String> strings = new ArrayList<>(Arrays.asList("cpp", "python", "javascript", "kotlin", "ruby", "r", "c", "rust", "vb"));
        lists.add(strings);
        new Solution().smallestSufficientTeam(new String[]{"cpp", "python", "javascript", "kotlin", "ruby", "r", "c", "rust", "vb"},lists);
    }
static
    class Solution {
        public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
            int l = req_skills.length;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < l; i++) {
                map.put(req_skills[i], i);
            }
            int[] peops = new int[people.size()];
            for (int i = 0; i < people.size(); i++) {
                List<String> strings = people.get(i);
                for (int j = 0; j < strings.size(); j++) {
                    peops[i] |= 1 << map.get(strings.get(j));
                }
            }
            List<Integer>[] dp = new List[1 << l];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = new ArrayList<>();
            }
            for (int i = 0; i < peops.length; i++) {
                if (dp[peops[i]].size()==0) {
                    dp[peops[i]].add(i);
                }
            }
            if (dp[dp.length - 1].size() != 0) {
                List<Integer> ans = dp[dp.length - 1];
                int[] ans1 = new int[ans.size()];
                for (int i1 = 0; i1 < ans1.length; i1++) {
                    ans1[i1] = ans.get(i1);
                }
                return ans1;
            }
            //人数作为长度，每次判断是否满足dp[l-1]!=0
            for (int i = 1; i < peops.length; i++) {
                for (int j = 0; j < dp.length; j++) {
                    List<Integer> list = dp[j];
                    if (list.size() ==i){
                        for (int k = 0; k < peops.length; k++) {
                            if (!list.contains(k)) {
                                int i1 = j | peops[k];
                                if ( i1!=j&&dp[i1].size() == 0 ) {

                                    dp[i1].addAll(list);
                                    dp[i1].add(k);
                                }
                            }
                            if (dp[dp.length - 1].size() != 0) {
                                List<Integer> ans = dp[dp.length - 1];
                                int[] ans1 = new int[ans.size()];
                                for (int i1 = 0; i1 < ans1.length; i1++) {
                                    ans1[i1] = ans.get(i1);
                                }
                                return ans1;
                            }
                        }
                    }

                }
            }
            return new int[]{0};
        }

    }
}
