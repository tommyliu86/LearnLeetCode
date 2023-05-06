package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/5/6 10:52
 */
public class MinNumberOfFrogs {
    /**
     * 使用计数数组记录每个字符的数量，只要字符是按照顺序增加的，表示符合要求，
     * 同时记录 头和尾字符的差，头表示有一个青蛙开始叫，尾表示一个青蛙结束，头和尾的差就表示同时几个青蛙叫
     */
    class Solution {
        public int minNumberOfFrogs(String croakOfFrogs) {
            if (croakOfFrogs.length()%5!=0) return -1;
            int[] counts=new int[5];
            String name="croak";
            Map<Character,Integer> map=new HashMap<>();
            for (int i = 0; i < 5; i++) {
                map.put(name.charAt(i),i);
            }
            int max=0;
            for (int i = 0; i < croakOfFrogs.length(); i++) {
                Integer indez = map.get(croakOfFrogs.charAt(i));
                counts[indez]++;
                if (indez!=0&& counts[indez]>counts[indez-1]){
                    return -1;
                }
                max=Math.max( counts[4]-counts[0],max);
            }
            if (counts[4]-counts[0]!=0) return -1;
            return max;


        }
    }
}
