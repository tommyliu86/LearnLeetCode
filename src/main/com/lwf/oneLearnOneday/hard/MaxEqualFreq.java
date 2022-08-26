package com.lwf.oneLearnOneday.hard;

import java.util.*;

public class MaxEqualFreq {

    /**
     * 直接使用map进行存储。。时间复杂度太高了
     */
    class Solution {
        public int maxEqualFreq(int[] nums) {
            if (nums.length == 1) {
                return 1;
            }
            int size = 1;
            //数量，这个数量的数字个数
            Map<Integer, Integer> mapCount = new HashMap<>();
            //num，num的数量
            Map<Integer, Integer> numMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                numMap.put(num, numMap.getOrDefault(num, 0) + 1);

                Integer mapKey = numMap.get(num);
                mapCount.put(mapKey, mapCount.getOrDefault(mapKey, 0) + 1);


                if (mapCount.containsKey(mapKey - 1)) {
                    Integer preCount = mapCount.get(mapKey - 1);
                    preCount -= 1;
                    if (preCount == 0) {
                        mapCount.remove(mapKey - 1);
                    } else {
                        mapCount.put(mapKey - 1, preCount);
                    }
                }
                if (numMap.size() == 1 || (mapCount.size() == 1 && mapKey == 1)) {
                    size = i + 1;
                } else if (mapCount.size() == 2) {
                    if (mapCount.containsKey(1) && mapCount.get(1) == 1) {
                        size = i + 1;
                    } else {
                        Set<Integer> keys = mapCount.keySet();
                        Integer max = keys.stream().max(Integer::compareTo).get();
                        Integer min = 0;
                        for (Integer key : keys) {
                            if (!key.equals(max)) {
                                min = key;
                            }
                        }
                        if (max - min == 1 && mapCount.get(max) == 1) {
                            size = i + 1;
                        }
                    }
                }

            }
            return size;
        }
    }
}