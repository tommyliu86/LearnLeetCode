package com.lwf.TOP100.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * author Administrator
 * time 2019-10-23-22:17
 * {@link md/normal/78.md}
 */
public class Subsets {
    /**
     * 回溯算法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> lists=new LinkedList<>();
        lists.add(new ArrayList<>());
        backTracking(nums,new LinkedList<Integer>(),0,lists);
        return lists;
    }
    void backTracking(int[] nums,List<Integer> tags,int index,List<List<Integer>> lists){
        if (index>=nums.length) return;
        backTracking(nums,tags,index+1,lists);
        tags.add(nums[index]);
        lists.add(new ArrayList<>(tags));
        backTracking(nums,tags,index+1,lists);
        tags.remove(tags.size()-1);
    }
}
