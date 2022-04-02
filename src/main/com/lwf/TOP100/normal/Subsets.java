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
        //当前节点仅有添加和不添加两种情况，
        // 第一个选择不添加，进行递归
        backTracking(nums,tags,index+1,lists);
        //第二个选择添加，添加后则需要把列表加入到子集结果中，然后递归
        tags.add(nums[index]);
        lists.add(new ArrayList<>(tags));
        backTracking(nums,tags,index+1,lists);
        //递归完成后需要移除当前tags添加进去的值，保证不改变上层的使用。
        tags.remove(tags.size()-1);
    }

}
