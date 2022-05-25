package com.lwf.learn.everyday.arith.second.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-21 09:52
 */
public class SubsetsWithDup {
    /**
     * 排序后判断不可行，剪枝和后退逻辑乱了。
     * 重复元素的选择逻辑是：如果选择了第一个重复元素，则必须后续都选择，否则会出现重复组合的情况，
     * 因此，根据当前index==index-1 && list.last==index 可以判断当前重复元素是否应该选择，
     * 应该选择的话就只有一个分叉，否则是正常的两个分叉的递归。
     *
     */
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> rtn = new ArrayList<>();
            recursive(nums, 0, new ArrayList<>(), rtn);
            return rtn;
        }


        public void recursive(int[] nums, int index, List<Integer> list, List<List<Integer>> rtn) {
            if (index == nums.length) {
                rtn.add(new ArrayList<>(list));
                return;
            }

            if (list.size() != 0 && index != 0 && nums[index] == nums[index - 1] && list.get(list.size() - 1) == nums[index]) {
                list.add(nums[index]);
                recursive(nums, index + 1, list, rtn);
                list.remove(list.size() - 1);
            } else {
                recursive(nums, index + 1, list, rtn);
                list.add(nums[index]);
                recursive(nums, index + 1, list, rtn);
                list.remove(list.size() - 1);
            }
        }
    }
}
