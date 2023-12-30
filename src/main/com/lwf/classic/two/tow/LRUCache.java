package com.lwf.classic.two.tow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/4/15 10:17
 */
public class LRUCache {
    class Node{
        Node pre;
        Node next;
        int key;
        int val;
    }
    Node head;
    Node tail;
    Map<Integer,Node> map=new HashMap<>();
    int size;
    public LRUCache(int capacity) {
        size=capacity;
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.pre=head;
    }
    public void remove(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
        node.pre=null;
        node.next=null;
    }
    public void add(Node node){
        head.next.pre=node;
        node.next=head.next;
        head.next=node;
        node.pre=head;
    }
    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.val;
        }else{
            return -1;
        }
    }

    /**
     * put时，先判断是否存在key，
     * @param key
     * @param value
     */
    public void put(int key, int value) {

        if (map.containsKey(key)){
            get(key);
            Node node = map.get(key);
            node.val=value;
        }else{
            if (map.size()==size){
                Node t = tail.pre;
                remove(t);
                map.remove(t.key);

            }
            Node node = new Node();
            node.key=key;
            node.val=value;
            add(node);
            map.put(key,node);
        }
    }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
