package com.lwf.TOP100.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author Administrator
 * time 2019-10-09-22:35
 * {@link 46.md}
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int first=nums[0];
        int[] target=new int[nums.length];
        backTracking(lists,target,nums,0,first);
        return lists;
    }
    void backTracking(List<List<Integer>> lists,int[] target,int[] nums,int level,int first){
        if (level<nums.length-1){
            for (int i = 0; i < nums.length; i++) {

                if ((i!=0&&nums[i]!=first)||(i==0&&nums[i]==first)){
                    target[level]=nums[i];
                    nums[i]=(i==0?(first-1):first);
                    backTracking(lists,target,nums,level+1,first);
                    nums[i]=target[level];
                }
            }
        }
        else{
            for (int i = 0; i < nums.length; i++) {
                if ((i!=0&&nums[i]!=first)||(i==0&&nums[i]==first)){
                    target[level]=nums[i];
                    break;
                }
            }
            lists.add(trans(target));
        }

    }
    List<Integer> trans(int[] ints){
        ArrayList<Integer> list=new ArrayList<>();
        for (int anInt : ints) {
            list.add(anInt);
        }
        return list;
    }
}
