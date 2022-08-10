package com.lwf.oneLearnOneday.normal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ExclusiveTime {
    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            int[] methods = new int[n];

            Stack<int[]> stack = new Stack<>();
            for (int i = 0; i < logs.size(); i++) {
                String s = logs.get(i);
                String[] split = s.split(":");
                int[] node = new int[3];
                node[0] = Integer.parseInt(split[0]);
                node[1] = Integer.parseInt(split[2]);
                if (split[1].equals("start")) {
                    stack.push(node);
                } else {
                    int[] pop = stack.pop();

                    methods[pop[0]] += 1 + node[1] - pop[1] - pop[2];
                    if (stack.size() > 0) {
                        stack.peek()[2] += 1 + node[1] - pop[1];
                    }
                }

            }
            return methods;
        }
    }
}
