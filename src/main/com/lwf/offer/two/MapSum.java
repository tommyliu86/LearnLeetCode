package com.lwf.offer.two;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MapSum {
    /**
     * LCR 066. 键值映射
     * https://leetcode.cn/problems/z1R5dt/submissions/?envType=study-plan-v2&envId=coding-interviews-special
     */
    class Node {
        Node[] children = new Node[26];
        String str;
        int count = 0;
        void add(String s){
            Node cur=this;
            for (int i = 0; i < s.length(); i++) {
                int j = s.charAt(i) - 'a';
                if (cur.children[j]==null) {
                    cur.children[j]=new Node();
                    cur.count++;
                }
                cur=cur.children[j];
            }
            cur.str=s;
        }
        Node find(String prefix){
            Node cur=this;
            for (int i = 0; i < prefix.length(); i++) {
                int j = prefix.charAt(i) - 'a';
                if (cur.count==0||cur.children[j]==null) {
                    return null;
                }else{
                  cur=  cur.children[j];
                }
            }
            return cur;
        }
    }

    Map<String, Integer> map = new HashMap<>();
    Node root = new Node();

    public MapSum() {

    }

    public void insert(String key, int val) {
        if (!map.containsKey(key)) {
            root.add(key);
        }
        map.put(key, val);
    }

    public int sum(String prefix) {
        Node node = root.find(prefix);
        if (node==null)return 0;
        int sum=0;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            if (poll.str!=null) {
                sum+=map.get(poll.str);
            }
            if (poll.count!=0) {
                for (Node child : poll.children) {
                    if (child!=null) {
                        queue.offer(child);
                    }
                }
            }
        }
        return sum;
    }


/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
}
