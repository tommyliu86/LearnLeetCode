package com.lwf.classic.two;

import java.util.*;

public class PermuteUnique {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();

            recurse(nums, new ArrayList<>(),new int[nums.length], ans);
            return ans;
        }

        public void recurse(int[] nums, List<Integer> list, int[] mark, List<List<Integer>> ans) {
            if (list.size() == nums.length) {
                ans.add(new ArrayList<>(list));
                return;
            }
            Set<Integer> set=new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (mark[i]==1||set.contains(nums[i])) {
                    continue;
                }

                set.add(nums[i]);

                mark[i]=1;
                list.add(nums[i]);
                recurse(nums, list,mark, ans);
                mark[i]=0;
                list.remove(list.size() - 1);
            }

        }
    }
}

