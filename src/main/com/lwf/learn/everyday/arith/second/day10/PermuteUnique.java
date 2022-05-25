package com.lwf.learn.everyday.arith.second.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-22 10:43
 */
public class PermuteUnique {
    class Solution {
        /**
         * 全排列2
         * 其中有重复数字,在递归的选择时，进行过滤，每一个位置上一个相同数字只应该选择一次
         * @param nums
         * @return
         */
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            boolean[] chosen=new boolean[nums.length];
            List<List<Integer>> rtn=new ArrayList<>();
            rec(nums,chosen,new ArrayList<Integer>(),rtn);
            return rtn;
        }
        private void rec(int[] nums,boolean[] chosen,List<Integer> list,List<List<Integer>> rtn){
            if (list.size()==nums.length){
                rtn.add(new ArrayList<>(list));
                return;
            }
            int pre=nums[0]-1;
            for (int i = 0; i < chosen.length; i++) {

                if (!chosen[i]&&pre!=nums[i]){
                    list.add(nums[i]);
                    chosen[i]=true;
                    rec(nums,chosen,list,rtn);
                    chosen[i]=false;
                    list.remove(list.size()-1);
                    pre=nums[i];
                }
            }
        }
        /**
         * 全排列
         * 不包含重复数字的nums，
         * @param nums
         * @return
         */
        public List<List<Integer>> permute(int[] nums) {
            boolean[] chosen=new boolean[nums.length];
            List<List<Integer>> rtn=new ArrayList<>();
            recursive(nums,chosen,new ArrayList<Integer>(),rtn);
            return  rtn;

        }
        private void recursive(int[] nums,boolean[] chosen,List<Integer> list,List<List<Integer>> rtn){
            if (list.size()==nums.length){
                rtn.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < chosen.length; i++) {
                if (!chosen[i]){
                    list.add(nums[i]);
                    chosen[i]=true;
                    recursive(nums,chosen,list, rtn);
                    list.remove(list.size()-1);
                    chosen[i]=false;
                }
            }
        }
    }


    }

