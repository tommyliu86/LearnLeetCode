package com.lwf.oneLearnOneday.normal;

/**
 * 1670. 设计前中后队列
 * @author liuwenfei
 * @date 2023/11/28 8:38
 */
public class FrontMiddleBackQueue1 {

    /**
     * 使用双端队列，同时使用3个指针，指向三个位置，进行前插和移除操作
     */
    class FrontMiddleBackQueue {
        class Node{
            Node _pre;
            Node _post;
            int val;
            public Node(){}
            public Node(int val){this.val=val;}
        }
        Node head;
        Node tail;
        Node mid;
        int count=0;
        public FrontMiddleBackQueue() {
            head=new Node();
            tail=new Node();
            head._post=tail;
            tail._pre=head;
            mid=tail;
        }
        private void insert(int val,Node cur){
            Node node = new Node(val);
            node._post=cur;
            node._pre=cur._pre;
            cur._pre._post=node;
            cur._pre=node;
            count++;
        }
        private int pop(Node cur){
            cur._pre._post=cur._post;
            cur._post._pre=cur._pre;
            cur._pre=cur._post=null;
            count--;
            return cur.val;
        }

        public void pushFront(int val) {
            insert(val,head._post);

            //奇数-》偶数
            if (count%2==0||count==1){
                mid=mid._pre;
            }
        }

        public void pushMiddle(int val) {
            if (count==0){
                insert(val,mid);
                mid=mid._pre;
            }else{
                insert(val,count%2==0? mid._post:mid);
                if (count%2==1){
                    mid=mid._post;
                }else{
                    mid=mid._pre;
                }
            }
        }

        public void pushBack(int val) {
            insert(val,tail);
            if (count==1){
                mid=mid._pre;
            }else if (count%2==1){
                mid=mid._post;
            }
        }

        public int popFront() {
            if (count==0) return -1;
            if (count%2==0||count==1){
                mid=mid._post;
            }
            int pop = pop(head._post);

            return pop;
        }

        public int popMiddle() {
            if (count==0) return -1;
            if (count%2==0||count==1){
                mid=mid._post;
                return pop(mid._pre);

            }else{
                mid=mid._pre;
                return pop(mid._post);
            }

        }

        public int popBack() {
            if (count==0) return -1;
            if (count==1){
                mid=mid._post;
            }else if (count%2==1){
                mid=mid._pre;
            }
            int pop = pop(tail._pre);

            return pop;
        }
    }

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
}
