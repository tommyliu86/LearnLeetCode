package com.lwf.offer.two;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/3/16 19:12
 */
public class LRUCacheTotal {
    /**
     * 使用双端链表+map
     */
    class LRUCache {
        class Node {
            public int key;
            public int val;
            public Node pre;
            public Node next;
        }

        Map<Integer, Node> map = new HashMap<>();
        int max = 0;
        Node head;
        Node tail;
        public LRUCache(int capacity) {
            max = capacity;
            head=new Node();
            tail=new Node();
            link(head,tail);
        }
        private void link(Node n1,Node n2){
            n1.next=n2;
            n2.pre=n1;
        }
        private void remove(Node node){
            node.pre.next=node.next;
            node.next.pre=node.pre;
        }
        private void insert(Node node){
            tail.pre.next=node;
            node.pre=tail.pre;

            node.next=tail;
            tail.pre=node;
        }
        public int get(int key) {
            if (map.containsKey(key)){
                Node node = map.get(key);
                remove(node);

                insert(node);
                return node.val;
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {

            if (map.containsKey(key)){
                map.get(key).val=value;
                get(key);
            }else{
                if (map.size()==max){
                    Node removed = head.next;
                    map.remove(removed.key);
                    remove(removed);
                }
                Node node = new Node();
                node.key=key;
                node.val=value;
                insert(node);
                map.put(key,node);
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
