package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-13 09:09
 */
public class RandomizedSet {
    public static void main(String[] args) {
        List<Integer> va=new LinkedList<>();
        va.add(1);
        System.out.println(va.get(0));
        va.add(2);
        va.set(0,2);
        System.out.println(va.get(0));
        System.out.println(va.get(1));
        System.out.println(va.get(2));
    }

    HashMap<Integer, Integer> map;
    List<Integer> vals;

    public RandomizedSet() {
        map = new HashMap<>();
        vals = new LinkedList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, vals.size());
        vals.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Integer index = map.get(val);


        Integer last = vals.get(vals.size() - 1);
        vals.set(index, last);
        map.put(last,index);
        vals.remove(vals.size() - 1);

        map.remove(val);
        return true;
    }

    /**
     * random 要固定，不然会random的值不变了
     *
     */
    Random random = new Random();
    public int getRandom() {

        return vals.get(random.nextInt(vals.size() ));
    }


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
