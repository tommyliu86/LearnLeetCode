package com.lwf.learn.everyday.data.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-25 18:27
 */
public class ThreeSum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> rtn = new ArrayList<>();
            for (int i = 0; i < nums.length - 2; ) {

                if (nums[i] > 0) {
                    break;
                }
                while (i > 0 && i < nums.length && nums[i - 1] == nums[i]) {
                    i++;
                }
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    while (j > i + 1 && j < k && nums[j - 1] == nums[j]) {
                        j++;
                    }
                    while (k < nums.length - 1 && j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                    if (j<k){

                        if (nums[j] + nums[k] + nums[i] == 0) {

                            rtn.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                            j++;
                            k--;
                        } else if (nums[j] + nums[k] + nums[i] > 0) {
                            k--;
                        } else {
                            j++;
                        }
                    }
                }
                i++;
            }
            return rtn;
        }
    }
}
