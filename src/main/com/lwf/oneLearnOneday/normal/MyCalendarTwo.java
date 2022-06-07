package com.lwf.oneLearnOneday.normal;

import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-06 09:48
 */
public class MyCalendarTwo {

    TreeMap<Integer,Integer> treeMap=new TreeMap<>();
    public MyCalendarTwo() {

    }

    public boolean book(int start, int end) {
        treeMap.put(start,treeMap.getOrDefault(start,0)+1);
        treeMap.put(end,treeMap.getOrDefault(end,0)-1);
        int sum=0;
        for (Integer value : treeMap.values()) {
            sum+=value;
            if (sum>=3){
                treeMap.put(start,treeMap.get(start)-1);
                treeMap.put(end,treeMap.get(end)+1);
                return false;
            }
        }
        return true;

    }


/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
}
