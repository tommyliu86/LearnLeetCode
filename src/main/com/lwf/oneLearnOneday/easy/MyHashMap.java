package com.lwf.oneLearnOneday.easy;

/**
 * @author: liuwenfei
 * @date: 2024/4/15-9:11
 */
class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;
        Node(){}
        Node(int k,int v){
            this.key=k;
            this.value=v;
        }
    }
    Node[] nodes=new Node[1<<12];
    /**
     * 1.暴力解法，直接使用链表，然后使用遍历方法
     * 2.模拟hash解法，使用哈希碰撞进行index的计算，然后使用数组保存node节点，
     */
    public MyHashMap() {

    }

    public void put(int key, int value) {
        int index = getIndex(key);
        Node node = nodes[index];
        if (node==null){
            nodes[index]=new Node(key,value);
        }else{
            Node cur=node;
            if (cur.key==key){
                cur.value=value;
                return;
            }

            while (cur.next!=null&& cur.next.key!=key){
                cur=cur.next;
            }
            if (cur.next!=null){
                cur.next.value=value;
            }else{
                cur.next=new Node(key,value);
            }
        }
    }



    public int get(int key) {
        int index = getIndex(key);
        Node node = nodes[index];
        Node cur=node;
        while ( cur!=null&&cur.key!=key){
            cur=cur.next;
        }
        return cur==null?-1:cur.value;
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node node = nodes[index];
        if (node==null){
            return;
        }else if (node.key==key){
            nodes[index]=node.next;
        }else{
            Node cur=node;
            while (cur.next!=null&&cur.next.key!=key){
                cur=cur.next;
            }
            if (cur.next!=null){
                cur.next=cur.next.next;
            }
        }

    }

    public int getIndex(int i){
        return i&(nodes.length-1);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */