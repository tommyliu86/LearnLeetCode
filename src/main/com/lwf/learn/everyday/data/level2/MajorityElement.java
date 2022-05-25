package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-25 18:23
 */
public class MajorityElement {
    class Solution {
        public int majorityElement(int[] nums) {
            int count=0;
            int num=nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (count==0){
                    count++;
                    num=nums[i];
                }else{

                    if (nums[i]==num){
                        count++;
                    }else{
                        count--;
                    }
                }
            }
            return num;
        }
    }
}
