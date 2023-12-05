package com.lwf.oneLearnOneday.normal;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * 2336. 无限集中的最小数字
 *
 * @author liuwenfei
 * @date 2023/12/1 11:22
 */
public class SmallestInfiniteSet1 {
    /**
     * 基于暴力做法，可以考虑到，每次pop，都是最小值，而每次添加，如果不是移除的数据则不会添加进来，
     * 因此我们可以把数据分成两部分，一部分是可能添加进来的部分，一部分是肯定没变化的部分。
     */
    class SmallestInfiniteSet {
        int pre=1;
        //存储pre之前的数据
        TreeSet<Integer> set=new TreeSet<>(Integer::compareTo);
        public SmallestInfiniteSet() {

        }

        public int popSmallest() {
            if (!set.isEmpty()){
               return  set.pollFirst();
            }
            return pre++;
        }

        public void addBack(int num) {
            if (num<pre){
                set.add(num);
            }
        }
    }

    /**
     * 暴力做法，直接使用一个优先队列维护所有的元素
     */
    public class SmallestInfiniteSet2 {
        PriorityQueue<Integer> queue;
        Set<Integer> set = new HashSet<>();

        public SmallestInfiniteSet2() {
            queue = new PriorityQueue<>(Integer::compareTo);
            for (int i = 1; i < 1001; i++) {
                queue.add(i);
            }
        }

        public int popSmallest() {
            Integer poll = queue.poll();

            set.add(poll);
            return poll;

        }

        public void addBack(int num) {
            if (set.contains(num)) {
                set.remove(num);
                queue.add(num);
            }
        }
    }

}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

