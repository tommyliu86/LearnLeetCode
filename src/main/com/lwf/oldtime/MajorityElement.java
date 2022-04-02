package com.lwf.oldtime;

import java.util.HashMap;

/**
 * author Administrator
 * time 2019-07-22
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                if(map.get(num)>=((nums.length&1)==0? nums.length/2-1:nums.length/2)){
                    return num;
                }
                map.put(num,map.get(num)+1);
            }else{
             if(map.size()>((nums.length&1)==0? nums.length/2-1:nums.length/2)){
                 return -1;
             }
             else{
                 map.put(num,1);
             }
            }
        }
        return -1;
    }
}
