package com.lwf.TOP100.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * https://leetcode-cn.com/problems/all-oone-data-structure/
 * 432. 全 O(1) 的数据结构
 * @author: liuwenfei14
 * @date: 2022-03-17 15:26
 */
public class AllOne {
    public class Node{
         Node pre;
         Node next;
         int count;
         Set<String> keys;
         public Node(){
             this.count=0;
             this.keys=new HashSet<>();
         }
        public Node(String key,int count){
            this.keys=new HashSet<>();
            this.keys.add(key);
            this.count=count;
        }
        public void add(Node node){
            node.pre=this;
            node.next=this.next;
            this.next.pre=node;
            this.next=node;
        }
        public void remove(){
            this.pre.next=this.next;
            this.next.pre=this.pre;
        }
    }
    private Map<String,Node> map=new HashMap<>();
    private Node root;
    public AllOne() {
        root=new Node();
        root.pre=root;
        root.next=root;
    }

    public void inc(String key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            if (node.keys.size()>1) {
                node.keys.remove(key);
                if (node.next.count==node.count+1) {
                    node.next.keys.add(key);
                }else{
                    Node node1 = new Node(key, node.count+1);
                    node.add(node1);
                }
                map.put(key,node.next);

            }else{
                if (node.next.count==node.count+1) {
                    node.next.keys.add(key);
                    map.put(key,node.next);
                    node.remove();
                }else{

                    node.count+=1;
                }
            }


        }else {
            if (root.next.count==1) {
                root.next.keys.add(key);
                map.put(key,root.next);
            }else{
                Node node = new Node(key, 1);
                root.add(node);
                map.put(key,node);
            }
        }
    }

    public void dec(String key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            if (node.count==1){
                if (node.keys.size()>1) {
                    node.keys.remove(key);

                }else{
                    node.remove();
                }
                map.remove(key);
            }else{

                if (node.keys.size()>1) {
                    node.keys.remove(key);
                    if (node.pre.count==node.count-1) {
                        node.pre.keys.add(key);
                        map.put(key,node.pre);

                    }else{
                        Node node1 = new Node(key, node.count - 1);
                        node.pre.add(node1);
                        map.put(key,node1);
                    }
                }else{
                    if (node.pre.count==node.count-1) {
                        node.pre.keys.add(key);
                        map.put(key,node.pre);
                        node.remove();

                    }else{
                        node.count-=1;
                    }
                }
            }
        }
    }

    public String getMaxKey() {
     return    root.pre.keys.size()>0?root.pre.keys.iterator().next():"";
    }

    public String getMinKey() {
       return root.next.keys.size()>0?root.next.keys.iterator().next():"";
    }
}
