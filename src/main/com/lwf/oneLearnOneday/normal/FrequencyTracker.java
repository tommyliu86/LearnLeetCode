package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * 2671. 频率跟踪器
 *
 * @author: liuwenfei
 * @date: 2024/3/21-20:28
 */
public class FrequencyTracker {
    /**
     * 使用双哈希表进行数据变化的存储
     */

    Map<Integer,Integer> counts=new HashMap<>();
    Map<Integer,Integer> sums=new HashMap<>();
    public FrequencyTracker() {

    }

    public void add(int number) {
        Integer cur = counts.compute(number, (k, v) -> v == null ? 1 : v + 1);
        sums.compute(cur,(k,v)->v==null?1:v+1);
        sums.computeIfPresent(cur-1,(k,v)->v-1);
    }

    public void deleteOne(int number) {
        if (counts.getOrDefault(number,0)==0){
            return;
        }
        Integer cur = counts.compute(number, (k, v) ->  v - 1);
        sums.computeIfPresent(cur+1,(k,v)->v-1);
        if (cur==0){
            return;
        }
        sums.computeIfPresent(cur,(k,v)->v+1);

    }

    public boolean hasFrequency(int frequency) {
        return  sums.getOrDefault(frequency,0)!=0;
    }


/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
}
