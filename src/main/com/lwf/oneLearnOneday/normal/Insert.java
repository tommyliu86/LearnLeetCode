package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-18 14:27
 */
public class Insert {

    class Solution {
        //start《ns《end 合并 到 start《nn《end or nn《start
        public int[][] insert(int[][] intervals, int[] newInterval) {
            if (intervals.length==0){
                return new int[][]{newInterval};
            }
            List<int[]> lists=new ArrayList<>();
            boolean merged=false;
            for (int i = 0; i < intervals.length; i++) {
                int start=intervals[i][0];
                int end=intervals[i][1];
                if (merged||end<newInterval[0]){
                    lists.add(intervals[i]);
                    continue;
                }

                if (newInterval[1]<start){
                    lists.add(newInterval);
                    lists.add(intervals[i]);
                }else{
                    start=Math.min(start,newInterval[0] );
                    end=Math.max(end,newInterval[1]);
                    int j=i+1;
                    while (j<intervals.length&&intervals[j][0]<=end){
                        end=Math.max(end,intervals[j][1]);
                        j++;
                    }
                    lists.add(new int[]{start,end});
                    i=j-1;
                }
                merged=true;

            }
            if (!merged){
                lists.add(newInterval);
            }
            int[][] ans=new int[lists.size()][2];
            for (int i = 0; i < ans.length; i++) {
                ans[i]=lists.get(i);
            }
            return ans;
        }
    }

    class Solution1 {
        public Node insert(Node head, int insertVal) {
            if (head == null) {
                Node node = new Node(insertVal);
                node.next = node;
                return node;
            }
            Node cur = head;
            Node next = head.next;
            if (next == cur) {
                Node node = new Node(insertVal);
                cur.next = node;
                node.next = next;
                return cur;
            } else {
                boolean find = false;
                while (next != head) {

                    if (cur.val > next.val) {
                        if (insertVal >= cur.val || insertVal <= next.val) {
                            Node node = new Node(insertVal);
                            cur.next = node;
                            node.next = next;
                            find = true;
                            break;
                        }
                    } else {
                        if (insertVal >= cur.val && insertVal <= next.val) {
                            Node node = new Node(insertVal);
                            cur.next = node;
                            node.next = next;
                            find = true;
                            break;
                        }
                    }

                    cur = cur.next;
                    next = next.next;
                }
                if (!find) {

                    Node node = new Node(insertVal);
                    cur.next = node;
                    node.next = next;
                }
                return head;
            }

        }
    }

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
