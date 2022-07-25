package com.lwf.game.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NumberContainers {
        Map<Integer,Integer> index2v;
        Map<Integer, PriorityQueue<Integer>> v2Index;

        public NumberContainers() {
            index2v=new HashMap<>();
            v2Index=new HashMap<>();
        }

        public void change(int index, int number) {
            if (index2v.containsKey(index)){
                Integer value = index2v.get(index);
                if (value!=number){
                    PriorityQueue<Integer> integers = v2Index.get(value);
                    integers.remove(index);

                    v2Index.put(value,integers);
                    index2v.put(index,number);
                    PriorityQueue<Integer> orDefault = v2Index.getOrDefault(number, new PriorityQueue<Integer>(Integer::compareTo));
                    orDefault.add(index);
                    v2Index.put(number,orDefault);
                }
            }else{
                index2v.put(index,number);
                PriorityQueue<Integer> orDefault = v2Index.getOrDefault(number, new PriorityQueue<Integer>(Integer::compareTo));
                orDefault.add(index);
                v2Index.put(number,orDefault);
            }
        }

        public int find(int number) {
            if (v2Index.containsKey(number)) {
                PriorityQueue<Integer> integers = v2Index.get(number);
                if (integers.isEmpty()){
                    return -1;
                }
                return integers.peek();
            }
            return -1;
        }


/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
}
