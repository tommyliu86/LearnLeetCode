package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-01 21:40
 */
public class MyCircularQueue {

    int[] queue;
    int front;
    int end;
    int size;

    public MyCircularQueue(int k) {
        queue = new int[k];
        front = 0;
        end = 0;
        size = 0;

    }

    public boolean enQueue(int value) {
        if (size == queue.length) {
            return false;
        } else {
            queue[end++] = value;
            end = end % queue.length;
            size++;
            return true;
        }
    }

    public boolean deQueue() {
        if (size > 0) {
            front++;
            front=front%queue.length;
            size--;
            return true;
        } else {
            return false;
        }
    }

    public int Front() {
        if (size==0){
            return -1;
        }else{
            return queue[front];
        }
    }

    public int Rear() {
        if (size==0){
            return -1;
        }else{
            return queue[(front+size-1)%queue.length];
        }
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==queue.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */