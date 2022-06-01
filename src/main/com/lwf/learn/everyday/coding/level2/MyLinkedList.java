package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-01 19:23
 */
public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtIndex(1,2);
        myLinkedList.addAtTail(1);
        myLinkedList.addAtHead(7);
        myLinkedList.addAtIndex(1,2);
        myLinkedList.addAtTail(1);

        myLinkedList.addAtTail(4);
        myLinkedList.addAtHead(6);
        myLinkedList.deleteAtIndex(7);
        myLinkedList.deleteAtIndex(5);
        myLinkedList.addAtIndex(3,0);
        System.out.println(myLinkedList.get(4));
        myLinkedList.addAtIndex(1,2);
    }

    class linklist {
        int val;
        linklist next;
    }

    linklist head;
    linklist tail;
    int size=0;

    public MyLinkedList() {
        head=new linklist();
        tail=head;
    }

    public int get(int index) {
        if (size>0&& index >= 0 && index < size) {
            linklist cursor=head;
            while (index >= 0) {
                cursor=cursor.next;
                index--;
            }
            return cursor.val;
        }
        return -1;
    }

    public void addAtHead(int val) {
        linklist linklist = new linklist();
        linklist.val = val;
        if (size > 0) {

            linklist.next =head.next;
        } else{
            tail=linklist;
        }
        head.next=linklist;
        size++;
    }

    public void addAtTail(int val) {
        linklist linklist = new linklist();
        linklist.val = val;
        if (size > 0) {

            tail.next=linklist;
        }else{
            head.next=linklist;
        }
        tail=linklist;
        size++;

    }

    public void addAtIndex(int index, int val) {

        if (index <= 0) {
            addAtHead(val);

        } else if (index ==size) {
            addAtTail(val);

        }else  if (index>size){
            return;
        }
        else {
            linklist linklist = new linklist();
            linklist.val = val;

            linklist cursor=head;
            while (index > 0) {
                cursor= cursor.next;
                index--;
            }
            linklist.next =cursor.next;
            cursor.next=linklist;

            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (size > 0&&index>=0&&index<size) {

            linklist cursor=head;
            int c=index;
            while (c>0){
                cursor=cursor.next;
                c--;
            }
            cursor.next=cursor.next.next;

            if (index==size-1){
                tail=cursor;
            }
            size--;
        }

    }
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