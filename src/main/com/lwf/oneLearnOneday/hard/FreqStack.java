package com.lwf.oneLearnOneday.hard;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2022/11/30 9:16
 */
public class FreqStack {


    //all var
    int i = 0;
    int step=100000;
    // var -index list
    Map<Integer, Integer> indexes = new HashMap<>();
    // count+index - var
    TreeMap<Integer,Integer> counts=new TreeMap<>();

    public FreqStack() {

    }

    public void push(int val) {
        int count= indexes.getOrDefault(val, 0);

        indexes.put(val,count+1);
        counts.put((count+1)*step+i,val);
        i++;

    }

    public int pop() {
        Map.Entry<Integer, Integer> firstEntry = counts.pollLastEntry();
        int integers = indexes.get(firstEntry.getValue());
        indexes.put(firstEntry.getValue(),integers-1);
        return firstEntry.getValue();
    }


    /**
     * Your FreqStack object will be instantiated and called as such:
     * FreqStack obj = new FreqStack();
     * obj.push(val);
     * int param_2 = obj.pop();
     */

    public static class FreqStack1 {

        //all var
        int[] queue = new int[2 * 10000];
        int i = 0;
        // var -index list
        Map<Integer, Integer> indexes = new HashMap<>();
        // var -count -max index 优先队列只在元素放入的时候进行排序，因此不能作为动态变化使用
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[2], b[2]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        public void push(int val) {
            queue[i] = val;

            indexes.put(val, indexes.getOrDefault(val, 0) + 1);
            priorityQueue.add(new int[]{val, indexes.get(val), i});
            i++;
        }

        public int pop() {
            int[] last = priorityQueue.poll();
            indexes.put(last[0], indexes.get(last[0]) - 1);
            return last[0];
        }


/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
    }
}


