package com.lwf.learn.everyday.dp.level1.d2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-25 15:23
 */
public class DeleteAndEarn {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            Arrays.sort(nums);
            Map<Integer,Integer> map=new HashMap<>();
            int nochose=0;
            int chose=0;

            int rtn=0;
            for (int i = 0; i < nums.length; ) {
                int num = nums[i];
                int j=i+1;
                while (j<nums.length&& nums[j]==num){
                    j++;
                }
                map.put(num,map.getOrDefault(num,0)+num*(j-i));

                if (map.containsKey(num-1)){
                    int temp=chose;
                    chose=map.get(num)+nochose;
                    nochose=Math.max(nochose,temp);

                }else{
                    int temp=chose;
                    chose=Math.max(nochose,chose)+ map.get(num);
                    nochose=Math.max(nochose,temp);
                }
                rtn=Math.max(rtn,Math.max(nochose,chose));
                i=j;
            }
            return rtn;
        }
    }
}
