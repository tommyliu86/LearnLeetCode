package com.lwf.oneLearnOneday.normal;

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
    /**
     * 并查集方法
     */
    static class unionFind {
        public int findCircleNum(int[][] isConnected) {
            return 0;
        }

        /**
         * 直接使用数组保存所有顶点的根节点。因此在find时可以直接找到根。
         */
        class QuickFind {
            // 保存每个顶点的根节点
            int[] mark;

            public QuickFind(int length) {
                mark = new int[length];
                for (int i = 0; i < mark.length; i++) {
                    mark[i] = i;
                }
            }

            public int find(int index) {
                return mark[index];
            }

            /**
             * union ，两个顶点要连接，如果这两个节点不是根节点，则选择使用一个的根节点a作为根节点，然后需要遍历所有节点，找到根节点为b的节点改为a
             * 
             * @param x
             * @param y
             */
            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX != rootY) {
                    for (int i = 0; i < mark.length; i++) {
                        if (mark[i] == rootY) {
                            mark[i] = rootX;
                        }
                    }
                }
            }
        }

        class quickUnion {
            int[] root;

            public quickUnion(int count) {
                root = new int[count];
                for (int i = 0; i < root.length; i++) {
                    root[i] = i;
                }
            }

            /**
             * 沿着路径一直找下去，找到父节点等于自身（根节点）为止。
             * 
             * @param index
             * @return
             */
            public int find(int index) {
                if (root[index] != index) {
                    index = root[index];
                }
                return root[index];
            }
            /**
             * 使用find方法找到根节点，然后把两个根节点做连接。union是快速的。查找要一直找到根才行。
             * @param x
             * @param y
             */
            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                if(rootX!=rootY){
                    root[rootX]=rootY;
                }

            }

        }

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
         * 
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
                    if (mark[poll]) { // 广度遍历有可能会导致 比较靠后的节点被放入队列两次，因此取出来之后，需要先进行一次判断。不然会导致markCount计数重复
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
         * 
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
    static class dfs {
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
