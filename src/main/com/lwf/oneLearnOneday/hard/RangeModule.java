package com.lwf.oneLearnOneday.hard;

import java.util.Map;
import java.util.TreeMap;

/**
 * 715. Range 模块
 * https://leetcode.cn/problems/range-module/?envType=daily-question&envId=2023-11-12
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-20 09:53
 */
public class RangeModule {
    /**
     * 有序集合，且需要可以查询 floor 和higher
     * 使用 treeMap 有序map进行区间拆分。。。
     */
    TreeMap<Integer,Integer> map;
    public RangeModule() {
        map=new TreeMap<>(Integer::compareTo);
    }

    public void addRange(int left, int right) {
        if (map.isEmpty()){
            map.put(left,right);
            return;
        }
        Map.Entry<Integer, Integer> leftEntry = map.floorEntry(left);
        Map.Entry<Integer, Integer> rightEntry = map.floorEntry(right);
        if (leftEntry!=null&&leftEntry==rightEntry){
            return;
        }
        if (leftEntry!=null&&leftEntry.getValue()>=left){
            left=leftEntry.getKey();

        }
        if (rightEntry!=null&&rightEntry.getValue()>=right){
            right=rightEntry.getValue();
        }
        Integer cursor=left;
        while (cursor!=null&&cursor<right){
            map.remove(cursor);
            cursor=map.higherKey(cursor);
        }

        map.put(left,right);

    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = map.higherEntry(left);
        if (entry == map.firstEntry()) {
            return false;
        }
        entry = entry != null ? map.lowerEntry(entry.getKey()) : map.lastEntry();
        return entry != null && right <= entry.getValue();
    }

    public void removeRange(int left, int right) {
        if (map.isEmpty()){

            return;
        }
        Map.Entry<Integer, Integer> leftEntry = map.floorEntry(left);
        if (leftEntry!=null&&leftEntry.getValue()<right){
            map.remove(leftEntry.getKey());
            map.put(leftEntry.getKey(),left);
        }

        Integer cursor=left;
        Integer pre=null;
        while (cursor!=null&&cursor<right){
            pre= map.remove(cursor);
            cursor=map.higherKey(cursor);
        }

        map.put(right,pre);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
