package com.lwf.classic.two;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    /**
     * 使用递归，进行遍历，
     * 因为数据量小，因此可以直接进行递归
     */
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans=new ArrayList<>();
            recurse(nums,new ArrayList<>(),ans);
            return ans;
        }
        public void recurse(int[] nums,List<Integer> list,List<List<Integer>> ans){
            if (list.size()==nums.length){
                ans.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])){
                    continue;
                }
                list.add(nums[i]);
                recurse(nums,list,ans);
                list.remove(list.size()-1);
            }
        }
    }
}
