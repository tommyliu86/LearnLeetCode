package com.lwf.oneLearnOneday.hard;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/7/7 8:37
 */
public class FindCrossingTime {
    public static void main(String[] args) {
        PriorityQueue<Integer> leftQ = new PriorityQueue<>(Integer::compareTo);
        leftQ.offer(2);
        leftQ.offer(1);
        System.out.println(leftQ.poll());
    }

    /**
     * 优先队列排序 +模拟 工人运动，通过过桥来进行时间推移
     */
    class Solution {
        public int findCrossingTime(int n, int k, int[][] time) {
            PriorityQueue<Integer> leftQ = new PriorityQueue<>((a, b) -> {
                if (time[a][0] + time[a][2] == time[b][0] + time[b][2]) {
                    return b - a;
                } else {
                    return (time[b][0] + time[b][2]) - (time[a][0] + time[a][2]);
                }
            });
            PriorityQueue<int[]> oldM = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
            PriorityQueue<Integer> rightQ = new PriorityQueue<>((a, b) -> {
                if (time[a][0] + time[a][2] == time[b][0] + time[b][2]) {
                    return b - a;
                } else {
                    return (time[b][0] + time[b][2]) - (time[a][0] + time[a][2]);
                }
            });
            PriorityQueue<int[]> newM = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

            for (int i = 0; i < time.length; i++) {
                leftQ.offer(i);
            }
            int times = 0;
            while (n > 0 || !rightQ.isEmpty() || !oldM.isEmpty()) {
                //根据times，让左右移动的人进入等待
                dealMap(oldM, rightQ, times);
                dealMap(newM, leftQ, times);
                //右边先走
                if (!rightQ.isEmpty()) {
                    Integer ri = rightQ.poll();
                    times += time[ri][2];
                    newM.offer(new int[]{times + time[ri][3], ri});

                } else if (!leftQ.isEmpty()&&n>0) {
                    Integer li = leftQ.poll();
                    times += time[li][0];
                    oldM.offer(new int[]{times + time[li][1], li});
                    n--;
                } else {
                    int add=Integer.MAX_VALUE;
                    if (!oldM.isEmpty()) {
                        add=Math.min( oldM.peek()[0],add);
                    }
                    if (!newM.isEmpty()) {
                        add=Math.min( newM.peek()[0],add);
                    }
                    times=add!=Integer.MAX_VALUE?add:times;
                }
            }
            return times;
        }

        public void dealMap(PriorityQueue<int[]> map, PriorityQueue<Integer> queue, int times) {
            while (!map.isEmpty() && map.peek()[0] <= times) {
                int[] poll = map.poll();
                queue.offer(poll[1]);
            }
        }
    }
}

