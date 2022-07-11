package com.lwf.oneLearnOneday.normal;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {

    TreeMap<Integer,Integer> map = new TreeMap<>(Integer::compareTo);

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        if (map.isEmpty()){
            map.put(start,end);
        }else{
            Map.Entry<Integer, Integer> sEntry = map.floorEntry(start);
            if (sEntry!=null&&sEntry.getValue()>start){
                return false;
            }
            Map.Entry<Integer, Integer> eEntry = map.ceilingEntry(start);
            if (eEntry!=null&&eEntry.getKey()<end){
                return false;
            }
            map.put(start,end);
        }
            return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */