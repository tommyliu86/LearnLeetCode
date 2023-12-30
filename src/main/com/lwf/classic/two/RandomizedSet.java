package com.lwf.classic.two;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/3/16 18:52
 */

/**
 * 1.直接利用list+hash进行操作，利用hash存储值对应的index，避免寻找index的损失
 * 2.
 */
public class RandomizedSet {

    Map<Integer,Integer> map;
    List<Integer> list;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        random = new Random();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            Integer index = map.remove(val);
            list.set(index,list.get(list.size()-1));
            if (map.containsKey(list.get(list.size()-1))){
                map.put(list.get(list.size()-1),index);
            }
            list.remove(list.size()-1);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int i = random.nextInt(list.size());
        return list.get(i);
    }


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

    /**
     * 1.直接利用list+set进行操作，这里会有list.remove的损失
     * 2.
     */
    public class RandomizedSet1 {

        Set<Integer> set;
        List<Integer> list;
        Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet1() {
            set = new HashSet<>();
            random = new Random();
            list = new ArrayList<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (set.contains(val)) {
                return false;
            }
            set.add(val);
            list.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (set.contains(val)) {
                set.remove(val);
                list.remove((Object) val);
                return true;
            }
            return false;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int i = random.nextInt(set.size());
            return list.get(i);
        }


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
    }
}