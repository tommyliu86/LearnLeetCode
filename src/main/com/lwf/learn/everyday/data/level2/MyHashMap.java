package com.lwf.learn.everyday.data.level2;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-26 16:10
 */
public class MyHashMap {

    private LinkedList<pair>[] array;

    public MyHashMap() {
        array=new LinkedList[hash];
    }

    public void put(int key, int value) {
        int i = key & hash;
        if (array[i]==null){
            array[i]=new LinkedList<>();
            array[i].add(new pair(key,value));
        }else{
            LinkedList<pair> pairs = array[i];
            pair pair = new pair(key, value);
            if (pairs.contains(pair)) {
                pairs.remove(pair);
            }
            pairs.add(pair);
        }
    }

    public int get(int key) {
        int i = key & hash;
        if (array[i]==null|| !array[i].contains(new pair(key))) {
            return -1;
        }else{
            LinkedList<pair> pairs = array[i];
            for (pair pair : pairs) {
                if (pair.k==key) {
                    return pair.v;
                }
            }
            return -1;
        }
    }

    public void remove(int key) {
        int i = key & hash;
        if (array[i]!=null) {

            LinkedList<pair> pairs = array[i];
            pairs.remove(new pair(key));
        }
    }

    class pair {
        int k;
        int v;

        public pair() {

        }

        public pair(int key, int value) {
            k = key;
            v = value;
        }
        public pair(int key){
            k=key;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof pair){
                return this.k==((pair) obj).k;
            }else{
                return false;
            }
        }

        @Override
        public int hashCode() {
            return this.k;
        }
    }
    private static int hash=(int) Math.pow(2,9)-1;

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
