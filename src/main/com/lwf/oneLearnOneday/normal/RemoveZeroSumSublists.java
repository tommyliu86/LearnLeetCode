package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveZeroSumSublists {
    class Solution {
        public ListNode removeZeroSumSublists(ListNode head) {
            Map<Integer, ListNode> preSum = new HashMap<>();

            ListNode pre = new ListNode(0, head);
            preSum.put(0, pre);
            ListNode cursor = head;
            int sum = 0;
            while (cursor != null) {
                sum += cursor.val;
                if (preSum.containsKey(sum)) {
                    ListNode listNode = preSum.get(sum);
                    ListNode cur=listNode.next;
                    int tmp=sum+cur.val;
                    while (tmp!=sum){
                        preSum.remove(tmp);
                        cur=cur.next;
                        tmp+=cur.val;
                    }

                    listNode.next = cursor.next;

                } else {
                    preSum.put(sum, cursor);
                }
                cursor = cursor.next;

            }
            return pre.next;
        }
    }
    class Solution1 {
        public ListNode removeZeroSumSublists(ListNode head) {
            Map<Integer, ListNode> preSum = new HashMap<>();

            ListNode pre = new ListNode(0, head);
            preSum.put(0, pre);
            ListNode cursor = head;
            int sum = 0;
            while (cursor != null) {
                sum += cursor.val;
                if (preSum.containsKey(sum)) {
                    ListNode listNode = preSum.get(sum);
                    ListNode cur=listNode.next;
                    int tmp=sum+cur.val;
                    while (tmp!=sum){
                        preSum.remove(tmp);
                        cur=cur.next;
                        tmp+=cur.val;
                    }

                    listNode.next = cursor.next;

                } else {
                    preSum.put(sum, cursor);
                }
                cursor = cursor.next;

            }
            return pre.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
