package com.lwf.TOP100.normal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * https://leetcode-cn.com/problems/number-of-provinces/
 * 547. 省份数量
 *
 * @author: liuwenfei14
 * @date: 2022-03-21 10:06
 */
public class FindCircleNum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ins = new int[][]{new int[]{1, 0, 0, 1}, new int[]{0, 1, 1, 0}, new int[]{0, 1, 1, 1}, new int[]{1, 0, 1, 1}};
        int circleNum = solution.findCircleNum(ins);
        System.out.println(circleNum);
    }

    /**
     * 图的广度遍历方法，
     * 1.使用队列辅助，把与当前节点直接连接的顶点放入队列，然后获取队列长度，依次出队当前队列长度的顶点，对取到的顶点进行处理，并入队顶点直接相关的顶点
     * 2.使用额外一个数组作为辅助，对每个顶点进行记录是否已经遍历到，防止额外读取
     * 3.使用额外常量保存遍历过的节点数量markCount，如果markCount=节点数量n，则终止流程。
     */
    static class bfs {
        /**
         * 第一版本广度遍历BFS，mark的时机放在出队列时判断，由于出队列判断会导致入队时无法知道是否已经入队过，会导致队列中的节点重复。因此会增大时间复杂度。
         * @param isConnected
         * @return
         */
        public int findCircleNum(int[][] isConnected) {
            boolean[] mark = new boolean[isConnected.length];
            int markCount = 0;
            int num = 0;

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; markCount < isConnected.length && i < isConnected.length; i++) {
                if (mark[i]) {
                    continue;
                }
                queue.offer(i);
                while (!queue.isEmpty()) {

                    Integer poll = queue.poll();
                    if (mark[poll]){ //广度遍历有可能会导致 比较靠后的节点被放入队列两次，因此取出来之后，需要先进行一次判断。不然会导致markCount计数重复
                        continue;
                    }
                    mark[poll] = true;
                    markCount++;
                    for (int j = 0; j < isConnected.length; j++) {
                        if (mark[j]) {
                            continue;
                        }
                        if (isConnected[poll][j] == 1) {
                            queue.offer(j);
                        }
                    }
                }
                num++;
            }
            return num;
        }

        /**
         * 第二版，把节点mark的时机放到入队列时判断，这样后续重复节点不会重复入队列。保证不会重复
         * @param isConnected
         * @return
         */
        public int findCircleNum1(int[][] isConnected) {
            boolean[] mark = new boolean[isConnected.length];
            int markCount = 0;
            int num = 0;

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; markCount < isConnected.length && i < isConnected.length; i++) {
                if (mark[i]) {
                    continue;
                }
                queue.offer(i);
                mark[i] = true;
                markCount++;
                while (!queue.isEmpty()) {

                    Integer poll = queue.poll();

                    for (int j = 0; j < isConnected.length; j++) {
                        if (mark[j]) {
                            continue;
                        }
                        if (isConnected[poll][j] == 1) {
                            queue.offer(j);
                            mark[j] = true;
                            markCount++;
                        }
                    }
                }
                num++;
            }
            return num;
        }

    }

    /**
     * 图的深度遍历方法。通用做法
     * 1.使用一个额外数组来保存节点是否遍历过了
     * 2.对顶点数组进行一次遍历
     * 3.每个顶点，对和其相连顶点进行深度向下遍历，一次找到所有相连顶点。构成一个图
     * 4.在遍历过程中注意统计遍历到的节点个数做边界终止条件即可。
     */
    static class Solution {
        Integer markCount = 0;

        public int findCircleNum(int[][] isConnected) {
            boolean[] mark = new boolean[isConnected.length];
            int num = 0;


            for (int i = 0; i < isConnected.length && markCount <= isConnected.length; i++) {
                if (mark[i]) {
                    continue;
                }
                dfs(isConnected, i, mark);
                num++;
            }
            return num;
        }

        private void dfs(int[][] isConnected, int curIndex, boolean[] mark) {
            mark[curIndex] = true;
            markCount++;
            for (int j = 0; j < isConnected.length && markCount <= isConnected.length; j++) {
                if (mark[j]) {
                    continue;
                }
                if (isConnected[curIndex][j] == 1) {

                    dfs(isConnected, j, mark);
                }
            }
        }
    }
}
