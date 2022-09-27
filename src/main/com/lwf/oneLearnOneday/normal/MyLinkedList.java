package com.lwf.oneLearnOneday.normal;



/**
 * @author liuwenfei
 * @date 2022/9/23 9:10
 */
public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(2);
        myLinkedList.addAtIndex(0,1);
        myLinkedList.get(1);
    }
    class LinkNode{
        int val;
        LinkNode next;
    }
    LinkNode head;
    int size;


    public MyLinkedList() {
        head=new LinkNode();
        size=0;
    }

    public int get(int index) {
        if (index>=size|| index<0){
            return -1;
        }
        LinkNode node = getNode(index);
        if (node==null){
            return -1;
        }
        return node.val;
    }
    private LinkNode getNode(int index) {
        if (index>size-1){
            return null;
        }
        LinkNode cur=head;
        while (index>=0){
            cur=cur.next;
        }
        return cur;
    }

    public void addAtHead(int val) {
        LinkNode linkNode = new LinkNode();
        linkNode.val=val;
        linkNode.next = head.next;
        head.next=linkNode;
        size++;
    }

    public void addAtTail(int val) {
        if (size==0){
            addAtHead(val);
            return;
        }
        LinkNode tail = getNode(size - 1);
        LinkNode linkNode = new LinkNode();
        linkNode.val=val;
        tail.next=linkNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index>size){
            return;
        }
        if (index==size){
            addAtTail(val);
            return;
        }
        if (index<=0){
            addAtHead(val);
            return;
        }

        LinkNode curI = getNode(index-1);
        LinkNode linkNode = new LinkNode();
        linkNode.val=val;
        linkNode.next=curI.next;
        curI.next=linkNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index>size-1){
            return ;
        }
        LinkNode node = getNode(index - 1);
        node.next=node.next.next;
    }


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
