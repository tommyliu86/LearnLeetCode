package com.lwf;

/**
 * author Administrator
 * time 2019-07-25
 */
public class ReverseList {

    /**
     * 迭代翻转，两个指针，分别指向要移位的node 和新链表的表头，让node的next 指向新表头即可。
     * 边界条件是移位node==null，
     * 注意：迭代开始时，需要使用一个null作为表头，移动node指向old的表头开始，这样避免构成环状链表。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head ==null) return head;
        ListNode first=null;
        ListNode second=head;
        do {
            ListNode temp=second.next;
            second.next=first;
            first=second;
            second=temp;
        }while (second!=null);
        return first;
    }

    /**
     * 递归思路，类似于stack，遍历node到最后一个node之后，递归返回上来，这时最后的node应该是新链表的头，
     * 所以return的node不变，一直是lastnode，这就需要在return之前把node的移动交换完成，那不能操作lastnode时，
     * 剩余的就只有一个局部变量node。该node是这一个递归层上的node，要移动到的位置是它本身的next的next位置，也就是node向后移动
     * 此处不同于迭代，迭代是向前移动，递归是从最后一个开始构建新链表，因此向后移动。移动之后会和node.next形成循环，因此再需要
     * node.next=null。直到最后完成！
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        if(head==null) return head;
        if (head.next   ==null){

          return  head;
        }else   {
          ListNode p = reverse(head.next);
                  head.next.next  =head;
                  head.next=null;
                  return p;
        }
    }

}
