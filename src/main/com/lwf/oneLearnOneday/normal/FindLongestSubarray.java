package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FindLongestSubarray {
    /**
     * 变换为+1-1的前缀和
     */
    class Solution {
        public String[] findLongestSubarray(String[] array) {
           int sums=0;
            Map<Integer,Integer> index=new HashMap<>();
            index.put(0,0);
            int [] is=new int[2];
            for (int i = 0; i < array.length; i++) {
                if (Character.isLetter(  array[i].charAt(0))) {
                    sums++;
                }else{
                    sums--;
                }
                if (index.containsKey(sums)){
                    Integer k = index.get(sums);
                    if (i+1-k>is[1]-is[0]){
                        is[0]=k;
                        is[1]=i+1;
                    }
                } else{
                    index.put(sums,i+1);
                }
            }

           return Arrays.copyOfRange(array,is[0],is[1]+1);

        }
    }
}
