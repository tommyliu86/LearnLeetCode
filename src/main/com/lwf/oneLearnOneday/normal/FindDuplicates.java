package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 数组的重复、缺失数字问题，一般都可以借助数组index 和元素之间的对应关系来进行空间复杂度O{1}的解法
 * @author: liuwenfei14
 * @date: 2022-05-08 13:49
 */
public class FindDuplicates {
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> rtn=new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs( nums[i])-1;
                if (nums[index]>0) {
                    nums[index]*=-1;
                }else{
                    rtn.add(index+1);
                }
            }
            return rtn;
        }
    }
}
