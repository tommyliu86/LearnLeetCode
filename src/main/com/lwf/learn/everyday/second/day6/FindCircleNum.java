package com.lwf.learn.everyday.second.day6;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-18 11:55
 */
public class FindCircleNum {
    public static void main(String[] args) {
        System.out.println(Boolean.FALSE.toString().equals(String.valueOf(true)));
    }
    class Solution {

        public int findCircleNum(int[][] isConnected) {
            boolean[] n = new boolean[isConnected.length];
            int num = 0;

            for (int i = 0; i < isConnected.length; i++) {
                int cursor = i;
                Queue<Integer> queue = new LinkedList<>();
                if (!n[cursor]) {
                    queue.add(cursor);
                    while (!queue.isEmpty()) {
                        Integer poll = queue.poll();
                        n[poll] = true;
                        for (int j = 0; j < isConnected[poll].length; j++) {

                            if (isConnected[poll][j] == 1) {
                                if (!n[j]) {
                                    n[j] = true;
                                    queue.add(j);
                                }
                            }
                        }
                    }
                    num++;
                }

            }
            return num;
        }
    }
}

