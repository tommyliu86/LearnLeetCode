package com.lwf.data;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 跳表，链表的nlogn的查找和插入。
 */
public class Skiplist {
    Node head;
    Random random;

    public Skiplist() {
        head = new Node(Integer.MIN_VALUE);
        random = new Random();
    }

    public boolean search(int target) {
        List<Node> nodes = find(target);
        Node node = nodes.get(nodes.size() - 1);
        if (node.level.size() == 0) {
            return false;
        } else {
            return node.level.get(0).val == target;
        }
    }

    private List<Node> find(int t) {
        int level = head.level.size();
        Node cursor = head;
        List<Node> path = new ArrayList<>();
        for (int i = level - 1; i >= 0; i--) { //按层进行访问，在每一层，使用while循环找到游标节点，然后向下层走。
            while (cursor.level.size() > i && cursor.level.get(i).val < t) {
                cursor = cursor.level.get(i);
            }
            path.add(cursor);
        }
        return path;
    }

    public void add(int num) {
        List<Node> nodes = find(num);
        Node node = new Node(num);

        for (int i = nodes.size() - 1; i >= 0; i--) {
            int j = nodes.size() - 1 - i;
            //pre 节点
            Node node1 = nodes.get(i);
            //pre的next
            if (node1.level.size()>j){

            Node node2 = node1.level.get(j);
            //node的next=pre.next
            node.level.add(node2);
            //pre.next=node;
            node1.level.set(j, node);
            }else{
                node1.level.add(node);
            }
            if (node.level.size()==1&&node.level.get(0).val==node.val){
                break;
            }
            if (!random.nextBoolean()){
                break;
            }
        }
        if (node.level.size()==head.level.size()&&random.nextBoolean()){
            head.level.add(node);
        }
    }

    public boolean erase(int num) {
        List<Node> nodes = find(num);
        List<Node> last = nodes.get(nodes.size() - 1).level;
        if (last.size()==0|| last.get(0).val!=num){
            return false;
        }
        Node removed = last.get(0);
        for (int i = nodes.size() - 1; i >= 0; i--) {
            int j = nodes.size() - 1 - i;
            //pre 节点
            Node node1 = nodes.get(i);
            if (node1.level.size()>j&& node1.level.get(j)==removed) {
               node1.level.remove(j);
            }else{
                break;
            }
        }
        return true;

    }

    class Node {
        int val;
        List<Node> level;

        public Node(int v) {
            level = new ArrayList<>();
            val = v;
        }
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */