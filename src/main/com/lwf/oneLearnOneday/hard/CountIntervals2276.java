package com.lwf.oneLearnOneday.hard;

import java.util.Map;
import java.util.TreeMap;

/**
 * 2276. 统计区间中的整数数目
 * @author liuwenfei
 * @date 2023/12/18 19:48
 */
public class CountIntervals2276 {
    /**
     * 有序集合，
     * 有序集合的合并操作方法，通过记录每次合并的left和right进行遍历
     */
    class CountIntervals {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int count=0;
        public CountIntervals() {

        }

        public void add(int left, int right) {

            Map.Entry<Integer, Integer> end = map.floorEntry(right);
            while (end!=null&& end.getValue()>=left){
                //计算合并后的区间
                left=Math.min(left,end.getKey());
                right=Math.max(right,end.getValue());
                //计算区间的长度，我们直接先减去所有的合并区间段，最后再加上整个合并后的段即可
                count-=end.getValue()-end.getKey()+1;
                map.remove(end.getKey());
                end=map.floorEntry(right);
            }
            count+=right-left+1;
            map.put(left,right);
        }

        public int count() {
            return count;
        }
    }

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */
}
