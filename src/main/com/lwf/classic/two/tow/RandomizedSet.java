package com.lwf.classic.two.tow;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/4/14 9:23
 */
public class RandomizedSet {
    /**
     * 使用数组来作为  index -value的存储，这样可以实现random，同时，在移除时，也可以直接使用末尾元素代替remove的元素，然后直接cursor移动即可！
     */
    Map<Integer,Integer> map=new HashMap<>();
        Random random=new Random();
        int[] vals=new int[2*100000];
        int i=0;
        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)){
                return false;
            }
            map.put(val,i);
            vals[i++]=val;
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)||i==0){
                return false;
            }
            Integer index = map.get(val);
            if (index==i-1){
                map.remove(val);
                i--;
            }else{
                Integer lastVal = vals[i-1];
                vals[index]=lastVal;
                map.put(lastVal,index);
                map.remove(val);
                i--;
            }
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int index = random.nextInt(i);
            return vals[index];
        }


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
