package com.lwf.learn.everyday.arith.second.day9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-21 09:18
 */
public class Subsets {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> rtn=new ArrayList<>();
            recursive(nums,0,new ArrayList<>(),rtn);
            return rtn;
        }
        public  void recursive(int[] nums,int index, List<Integer> list,List<List<Integer>> rtn){
            if (index==nums.length){
                rtn.add(new ArrayList<>(list));
                return;
            }
            recursive(nums,index+1,list,rtn);
            list.add(nums[index]);
            recursive(nums,index+1,list,rtn);
            list.remove(list.size()-1);
        }
    }
}
