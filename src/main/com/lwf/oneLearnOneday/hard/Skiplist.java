package com.lwf.oneLearnOneday.hard;

import com.sun.tools.javac.util.Dependencies;

import javax.management.NotificationEmitter;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Skiplist {
    List<Node> root = new ArrayList<>();
    int level = 0;
    Random random;

    public Skiplist() {
        Node node = new Node();
        node.val = Integer.MIN_VALUE;

        root.add(node);
        random = new Random();
    }

    public boolean search(int target) {

        Node cursor = root.get(level);
        while (cursor != null && cursor.val != target) {
            Node next = cursor.next;
            if (next != null && next.val <= target) {
                cursor = next;
            } else if (cursor.down != null) {
                cursor = cursor.down;
            } else {
                break;
            }
        }
        return cursor != null && cursor.val == target;
    }

    public void add(int num) {
        List<Node> path = new ArrayList<>();
        Node cursor = root.get(level);

        while (cursor != null) {
            Node next = cursor.next;
            if (next != null && next.val <= num) {
                cursor = next;
            } else if (cursor.down != null) {
                path.add(cursor);
                cursor = cursor.down;

            } else {
                break;
            }
        }
        Node node = new Node();
        node.val = num;
        node.next = cursor.next;
        cursor.next = node;
        if (cursor.val == num) {
            return;
        }
        int i = path.size();
        while (random.nextBoolean() && --i >= 0) {
            Node node1 = path.get(i);
            Node up = new Node();
            up.val = num;
            up.down = node;
            up.next = node1.next;
            node1.next = up;
        }
        if (i == -1 && random.nextBoolean()) {
            Node node1 = new Node();
            node1.val = Integer.MIN_VALUE;
            node1.down = root.get(level++);
            root.add(node1);

            Node up = new Node();
            up.val = num;
            up.down = node;
            node1.next = up;
        }
    }

    public boolean erase(int num) {
        List<Node> path = new ArrayList<>();
        Node cursor = root.get(level);

        while (cursor != null) {
            Node next = cursor.next;
            if (next != null && next.val < num) {

                cursor = next;
            } else if (cursor.down != null) {
                path.add(cursor);

                cursor = cursor.down;

            } else {
                break;
            }
        }
        if (cursor == null || cursor.next == null || cursor.next.val != num) {
            return false;
        }
        cursor.next= cursor.next.next;
        for (int i = path.size() - 1; i >= 0; i--) {
            Node node = path.get(i);
            if (node.next != null && node.next.val == num) {
                node.next = node.next.next;
            } else {
                break;
            }
        }
        if (root.get(level).next==null){
            level--;
            root.remove(level+1);
        }

        return true;
    }

    class Node {
        int val;
        Node next;

        Node down;
    }
}
