package com.lwf.TOP100.normal;

import java.util.*;

/**
 * author Administrator
 * time 2019-11-07-22:49
 */
public class LRUCache {
    /**
     * ["LRUCache","put","put","get","put","get","put","get","get","get"]
     * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
     * <p>
     * ["LRUCache","put","get","put","get","get"]
     * [[1],[2,1],[2],[3,2],[2],[3]]
     *
     * @param args
     */
    public static void main(String[] args) {
        LRUCache1 lruCache1 = new LRUCache1(2);
        lruCache1.put(1, 1);
        lruCache1.put(2, 2);
        lruCache1.get(1);
        lruCache1.put(3, 3);
        lruCache1.get(1);
        lruCache1.put(4, 4);
        lruCache1.get(1);
        lruCache1.get(3);
        lruCache1.get(4);

        LRUCache1 lruCache2 = new LRUCache1(1);
        lruCache2.put(2, 1);

        lruCache2.get(2);
        lruCache2.put(3, 3);
        lruCache2.get(2);


        lruCache2.get(3);
        lruCache2.get(4);

    }

    Queue<Integer> keyQueue = new LinkedList<>();
    Integer capacity;
    Map<Integer, Integer> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            keyQueue.remove(key);
            keyQueue.add(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {

            keyQueue.remove(key);

        } else if (keyQueue.size() >= capacity) {
            int keyNeedRemove = keyQueue.poll();
            map.remove(keyNeedRemove);
        }

        keyQueue.add(key);
        map.put(key, value);
    }

}

class LRUCache1 {
    DNode head;
    DNode tail;

    class DNode {
        public int val;
        public int key;
        public DNode pre;
        public DNode post;

        public DNode(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

    private void moveToTail(DNode cur) {
        //remove
        DNode pr = cur.pre;
        DNode po = cur.post;
        if (pr != null) { //pre!=null means cur!=head
            pr.post = po;
        } else { //cur==head
            head = head.post;
        }
        if (po != null) { //post!=null means cur!=tail
            po.pre = pr;
        } else { //cur==tail
            tail = tail.pre;
        }
        cur.post = null;
        cur.pre = null;
        //add to tail

        if (tail != null) { //tail!=null means linkedlist !=null,then add cur to tail

            tail.post = cur;
            cur.pre = tail;
            tail = cur;
        } else { //tail==null means head==tail==null;
            head = tail = cur;
        }

    }

    Map<Integer, DNode> map;
    Integer capacity;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            moveToTail(map.get(key));
            return map.get(key).val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) { //put is refresh key,move to tail
            DNode cur = map.get(key);
            if (cur.val != value) {
                cur.val = value;
            }
            moveToTail(cur);
        } else {

            if (map.size() >= capacity) {
                map.remove(head.key);
                head = head.post;
                if (head != null) { //if capacity=1 then head=head.post means head=null.
                    head.pre = null;
                }
            }
            DNode cur = new DNode(value, key);
            if (map.size() == 0) { //means head=tail=null.need init
                head = tail = cur;
            } else {
                tail.post = cur;
                cur.pre = tail;
                tail = cur;
            }
            map.put(key, cur);
        }
    }

}
