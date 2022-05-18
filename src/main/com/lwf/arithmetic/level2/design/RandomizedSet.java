package com.lwf.arithmetic.level2.design;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-13 14:58
 */
public class RandomizedSet {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random random = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {

            Integer remove = map.get(val);
            Integer integer = list.get(list.size() - 1);
            list.set(remove, integer);
            map.put(integer,remove);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}
