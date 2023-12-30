package com.lwf.classic.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LCR 082. 组合总和 II
 */
public class CombinationSum2 {
    /**
     * 递归和遍历，不能重复，则直接向后取值即可,
     *
     */
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            recurse(candidates, 0, new ArrayList<>(), ans, target);
            return ans;
        }

        public void recurse(int[] can, int i, List<Integer> list, List<List<Integer>> ans, int t) {

            if (t == 0) {

                ans.add(new ArrayList<>(list));
                return;
            }
            if (i == can.length) {
                return;
            }
            if (can[i] > t) {
                return;
            }
            //这里考虑重复数字的问题，主要的时间复杂度在这里，如果不进行数字重复取值判断，则需要在添加到ans中
            //的时候进行去重判断，这样会极大的增加时间复杂度，因此，我们进行取值的判断
            //在取当前i时，后续的值可以任意取值，但如果不取当前i，则我们应该对当前i的所有数字都不再取值。这样
            //就可以实现剪枝

            list.add(can[i]);
            recurse(can, i + 1, list, ans, t - can[i]);
            list.remove(list.size() - 1);
            int next=i+1;
            while (next<can.length&& can[next]==can[i]){
                next++;
            }
            recurse(can, next, list, ans, t);

        }
    }
    class Solution1 {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            recurse(candidates, 0, new ArrayList<>(), ans, target);
            return ans;
        }

        public void recurse(int[] can, int i, List<Integer> list, List<List<Integer>> ans, int t) {

            if (t == 0) {
                //如果有这个判断，则会极大的增加时间复杂度。
                if (ans.contains(list)) {
                    return;
                }
                ans.add(new ArrayList<>(list));
                return;
            }
            if (i == can.length) {
                return;
            }
            if (can[i] > t) {
                return;
            }
            //这里考虑重复数字的问题，主要的时间复杂度在这里，
            list.add(can[i]);
            recurse(can, i + 1, list, ans, t - can[i]);
            list.remove(list.size() - 1);
            recurse(can, i + 1, list, ans, t);

        }
    }
}
