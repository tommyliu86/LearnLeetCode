package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/4/10 9:38
 */
public class NextLargerNodes {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            int i = 0;
            List<ListNode> nodes = new ArrayList<>();
            Stack<Integer> index = new Stack<>();
            Map<Integer,Integer> map=new HashMap<>();
            while (head != null) {
                nodes.add(head);
                while (!index.isEmpty() && nodes.get(index.peek()).val< nodes.get(i).val){
                    map.put(index.pop(), head.val);
                }
                index.push(i);
                i++;
                head = head.next;
            }
            int[] ans=new int[i];
            map.forEach((k,v)->ans[k]=v);
            return ans;
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
