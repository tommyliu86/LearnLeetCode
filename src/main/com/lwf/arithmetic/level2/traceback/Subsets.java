package com.lwf.arithmetic.level2.traceback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-03 19:43
 */
public class Subsets {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            recursive(nums,0,new ArrayList<Integer>());
            return rtn;
        }
        List<List<Integer>> rtn=new ArrayList<>();
        public void recursive(int[] nums,int i,List<Integer> list){
            if (i==nums.length){
                rtn.add(new ArrayList<>(list));
                return;
            }
            recursive(nums,i+1,list);
            list.add(nums[i]);
            recursive(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }
}
