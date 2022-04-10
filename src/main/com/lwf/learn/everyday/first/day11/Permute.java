package com.lwf.learn.everyday.first.day11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-10 10:59
 */
public class Permute {
    /**
     * 递归构建，使用额外数组indexes保存数组的下标，来标记数组中哪个元素被使用过了。
     */
    class Solution {
        public List<List<Integer>> permute(int[] nums) {

            boolean[] indexes = new boolean[nums.length];
            recursive(indexes, nums, new ArrayList<>());
            return rtn;
        }

        List<List<Integer>> rtn = new LinkedList<>();

        private void recursive(boolean[] indexes, int[] nums, List<Integer> mark) {
            if (mark.size() == nums.length) {
                rtn.add(new ArrayList<>(mark));
                return;
            }
            for (int i = 0; i < indexes.length; i++) {
                if (indexes[i]) {
                    continue;
                }
                indexes[i] = true;
                mark.add(nums[i]);
                recursive(indexes, nums, mark);
                indexes[i] = false;
                mark.remove(mark.size() - 1);
            }
        }
    }
}
