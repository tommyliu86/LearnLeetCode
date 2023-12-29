package com.lwf.offer.two;

import java.util.ArrayList;
import java.util.List;

/**
 * LCR 079. 子集
 * @author liuwenfei
 * @date 2023/12/29 9:27
 */
public class Subsets {
    /**
     * 递归，直接递归进行计算即可
     */
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            recurse(nums,0,new ArrayList<>());
            return ans;
        }
        List<List<Integer>> ans=new ArrayList<>();
        public void recurse(int[] nums,int i,List<Integer> list){
            if (i==nums.length){
                ans.add(new ArrayList<>(list));
                return;
            }
            recurse(nums,i+1,list);
            list.add(nums[i]);
            recurse(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }
}
