package com.lwf.offer.two;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author liuwenfei
 * @date 2023/6/26 8:51
 */
public class MyCalendar {


    TreeMap<Integer, Integer> map = new TreeMap<>(Integer::compareTo);

    public MyCalendar() {
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> startEntry = map.floorEntry(start);
        Map.Entry<Integer, Integer> endEntry = map.lowerEntry(end);
        if ((startEntry!=null&&startEntry.getValue()>start)
            ||(endEntry!=null&&endEntry.getValue()>start)){
            return false;
        }
        map.put(start,end);
        return true;
    }

}
