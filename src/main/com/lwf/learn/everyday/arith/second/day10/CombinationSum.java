package com.lwf.learn.everyday.arith.second.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-22 14:13
 */
public class CombinationSum {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> rtn=new ArrayList<>();
            recursive(candidates, target,0,new ArrayList<Integer>(),rtn);
            return rtn;
        }
        private void recursive(int[] candi,int target,int index,List<Integer> list,List<List<Integer>> rtn){
            if (index>=candi.length){
                return;
            }
            if ( candi[index]>target){
                return;
            }else if(candi[index]==target){
                list.add(candi[index]);
                rtn.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                return;
            }else{
                recursive(candi,target,index+1,list,rtn);
                list.add(candi[index]);
                recursive(candi,target-candi[index],index,list,rtn);
                list.remove(list.size()-1);
                return;
            }
        }
    }
}
