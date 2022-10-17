package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2022/10/17 9:10
 */
public class TotalFruit {
    /**
     * 使用计数器
     */
    class Solution {
        public int totalFruit(int[] fruits) {
            int start=0;
            int end=0;
            int max=0;
            Map<Integer,Integer> counts=new HashMap<>();
            while (end<fruits.length){
                counts.put(fruits[end],counts.getOrDefault(fruits[end],0)+1);
                while (counts.size()>2){
                    int fruit = fruits[start];
                    int remain = counts.get(fruit) - 1;
                    if (remain==0){
                        counts.remove(fruit);
                    }else{
                        counts.put(fruit,remain);
                    }
                    start++;
                }
                max=Math.max(end-start+1,max);
                end++;
            }
            return max;
        }
    }

    /**
     * 直接使用map记录index
     */
    class Solution1 {
        public int totalFruit(int[] fruits) {

            int start = 0;
            int end = 0;
            Map<Integer, List<Integer>> indexes = new HashMap<>();
            int max = 0;
            while (end < fruits.length) {
                List<Integer> orDefault = indexes.getOrDefault(fruits[end], new ArrayList<>());
                orDefault.add(end);
                indexes.put(fruits[end], orDefault);
                while (indexes.size() > 2) {
                    int fruit = fruits[start];
                    List<Integer> integers = indexes.get(fruit);
                    integers.remove(Integer.valueOf(start));
                    if (integers.size() == 0) {
                        indexes.remove(fruit);
                    }
                    start++;
                }
                max = Math.max(end - start + 1, max);
                end++;
            }
            return max;
        }
    }
}
