package com.lwf.TOP100.normal;

import java.util.HashSet;
import java.util.Set;

/**
 * author Administrator
 * time 2019-11-05-22:46
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null||head.next==null) return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null&&slow!=fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == fast) {
            ListNode cursor=head;
            //按照常规思路，获取一个环内点，需要遍历对比head开始的next和环是否是交点
//            while (slow!=cursor){
//                do{
//                    slow=slow.next;
//                }
//                while (slow!=cursor&&slow!=fast);
//                if (slow==cursor) return cursor;
//                cursor=cursor.next;
//            }
            while (cursor!=slow){ //利用链表环的相交点为slow*2=fast求解得到环的起始点f的公式！
                cursor=cursor.next;
                slow=slow.next  ;
            }
            return cursor;
        }
        return null;
    }
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> set=new HashSet<>();
        ListNode cursor=head;
        while (!set.contains(cursor)&&cursor!=null){
            set.add(cursor);
            cursor=cursor.next;
        }
        return cursor;
    }

}
