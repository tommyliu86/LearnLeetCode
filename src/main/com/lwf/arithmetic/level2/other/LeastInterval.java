package com.lwf.arithmetic.level2.other;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-18 17:15
 */
public class LeastInterval {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return a - b;
        }
        );
        queue.add(4);
        queue.add(1);
        queue.add(2);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        new Solution().leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'},
                2);
    }

    static class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] chars = new int[26];
            for (int i = 0; i < tasks.length; i++) {
                int index = tasks[i] - 'A';
                chars[index]++;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> {
                return b - a;
            });
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] > 0) {
                    queue.add(chars[i]);
                }
            }
            int count = 0;
            List<Integer> cache = new ArrayList<>();

            while (!queue.isEmpty() || !cache.isEmpty()) {
                int i = 0;
                List<Integer> list = new ArrayList<>();
                while (i <= n) {
                    if (!cache.isEmpty()) {
                        queue.add(cache.remove(0));
                    }

                    if (!queue.isEmpty() || !list.isEmpty()) {
                        if (!queue.isEmpty()) {
                            Integer poll = queue.poll();
                            poll--;
                            if (poll > 0) {
                                list.add(poll);
                            }
                        }
                    } else {
                        break;
                    }
                    count++;
                    i++;
                }
                cache = list;
            }
            return count;
        }
    }
}
