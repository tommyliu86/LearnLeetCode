package com.lwf.learn.everyday.arith.first.d2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-23 15:29
 */
public class Permute {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> rtn=new ArrayList<>();
            recursive(nums,new boolean[nums.length],new ArrayList<>(),rtn);
            return  rtn;
        }
        public void recursive(int[] nums,boolean[] marks,List<Integer> list,List<List<Integer>> rtn){
            if (list.size()==nums.length){
                rtn.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (marks[i]){
                    continue;
                }
                marks[i]=true;
                list.add(nums[i]);
                recursive(nums,marks,list,rtn);
                marks[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
}
