package com.lwf.oneLearnOneday.hard;

import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-06 10:08
 */
public class MyCalendarThree {
    TreeMap<Integer,Integer> treeMap=new TreeMap<>();
    public MyCalendarThree() {

    }

    public int book(int start, int end) {
        treeMap.put(start,treeMap.getOrDefault(start,0)+1);
        treeMap.put(end,treeMap.getOrDefault(end,0)-1);
        int sum=0;
        int max=0;
        for (Integer value : treeMap.values()) {
            sum+=value;
            max=Math.max(max,sum);
        }
        return max;

    }
}
