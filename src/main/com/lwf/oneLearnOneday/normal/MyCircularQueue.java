package com.lwf.oneLearnOneday.normal;

class MyCircularQueue {
    int[] ints;
    int head;
    int end;
    int l;
    public MyCircularQueue(int k) {
        l=0;
        ints=new int[k];
        head=0;
        end=0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        ints[end]=value;
        end=(end+1)%ints.length;
        l++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        head=(head+1)%ints.length;
        l--;
        return true;
    }

    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return ints[head];
    }

    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        return ints[end==0?(ints.length-1):(end-1)];
    }

    public boolean isEmpty() {
        if (l==0){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull() {
        if (l==ints.length){
            return true;
        }else{
            return false;
        }
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
