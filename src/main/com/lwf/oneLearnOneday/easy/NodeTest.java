package com.lwf.oneLearnOneday.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-02-11 14:34
 */
public class NodeTest {
    static class Node {
        public int val;
        public Node next;

        public Node() {

        }
        public  Node(int i){
            val=i;
        }

    }

    public static void main(String[] args) {
        int[] input=new int[]{1,2,3,4,5,6,7};
        Node root=new Node(input[0]);
        Node current=root;
        for (int i = 1; i < input.length; i++) {
            Node node = new Node(input[i]);
            current.next=node;
            current=current.next;
        }
        Node delete = delete(root, 0);
        System.out.println(printNode(delete));

        Node search = search(root, 3);
        System.out.println(printNode(search));
    }
    public static List<Integer> printNode(Node node){
        List<Integer> list=new ArrayList<>();
        if (node==null){
            return list;
        }else{
            Node current=node;
            while (current!=null){
                list.add(current.val);
                current=current.next;
            }
            return list;
        }

    }
    /**
     * 使用栈保存节点
     * 遍历节点，如果节点值=sum，则直接后移，如果节点值和栈顶的和=sum，则出栈
     *
     * @param root
     * @param sum
     * @return
     */
    public static Node delete(Node root, int sum) {
        Stack<Node> stack = new Stack<>();
        Node pre = new Node();
        pre.next = root;
        Node current = root;
        while (current != null) {
            if (current.val != sum) {
                if (stack.empty()) {
                    pre.next = current;
                    stack.push(current);
                } else {

                    if (stack.peek().val + current.val == sum) {
                        stack.pop();
                    } else {
                        stack.peek().next = current;
                        stack.push(current);
                    }
                }
            }
            current = current.next;
        }

        if (!stack.isEmpty()) {
            stack.peek().next = null;
            return pre.next;
        } else {
            return null;
        }
    }

    /**
     * 递归，search返回的是已经处理好的链表，因此拼接到当前current节点的next，如果current+next=sum，则返回上层next.next，
     * 由于递归本身模拟的就是出栈，因此最后将返回到root节点时就是处理完成的链表
     * @param current
     * @param sum
     * @return
     */
    public static Node search( Node current, int sum) {

        while (current!=null&&current.val == sum) {
            current=  current.next;
        }
        if ( current == null) {
            return current;
        }
        current.next=search(current.next,sum);
        if (current.next==null){
            return current;
        }else{
            if (current.val+current.next.val==sum){
                return current.next.next;
            }else{
                return current;
            }
        }

    }


}
