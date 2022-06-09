package com.lwf.learn.everyday.dp.level1.d2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-09 11:15
 */
public class LengthOfLIS {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            List<Integer> list=new ArrayList<>();
            list.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                int index = half(list, 0, list.size() - 1, num);
                if (list.get(index)>num){
                    list.set(index,num);
                }else if (list.get(index)==num){
                    continue;
                }else{
                    if (index==list.size()-1){
                        list.add(num);
                    }else{
                        list.set(index+1,num);
                    }
                }
            }
            return list.size();
        }
        public int half(List<Integer> list,int l,int r,int t){
            if (l>=r){
                return l;
            }
            int m=(l+r)/2;
            if (list.get(m)==t){
                return m;
            }else if (list.get(m)>t){
                return half(list,l,m-1,t);
            }else{
                return half(list,m+1,r,t);
            }
        }
    }
}
