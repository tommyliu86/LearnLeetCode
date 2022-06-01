package com.lwf.learn.everyday.coding.level2;

import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-01 22:00
 */
public class MyCalendar {
    TreeMap<Integer,Integer> treeMap;
    public MyCalendar() {
        treeMap=new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer pre = treeMap.floorKey(start);
        Integer post = treeMap.ceilingKey(start);
        if ((pre==null||treeMap.get(pre)<=start)&&(post==null||post>=end)){
            treeMap.put(start,end);
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */