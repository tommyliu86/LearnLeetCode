package com.lwf.arithmetic.level2.traceback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-01 20:49
 */
public class Permute {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> rtn = new ArrayList<>();
            recursive(nums, new ArrayList<Integer>(), new boolean[nums.length], rtn);
            return rtn;
        }

        public void recursive(int[] nums, List<Integer> list, boolean[] mark, List<List<Integer>> rtn) {
            if (list.size() == nums.length) {
                rtn.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < mark.length; i++) {
                if (!mark[i]) {
                    list.add(nums[i]);
                    mark[i] = true;
                    recursive(nums, list, mark, rtn);
                    list.remove(list.size() - 1);
                    mark[i] = false;
                }
            }
        }
    }
}
