package com.lwf.learn.everyday.dp.level1;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-12 15:04
 */
public class IsUgly {
    class test2 {

        /**
         * 动态规划，优先队列+set是预先把每个i的 2，3，5都计算出来，排序+去重，
         * 而实际上，通过 int[] 保存结果数列，记录下每个 i 可以从前面出现过的元素 j（j<i）通过j*2，3，5 计算出来的，
         * 若 i==j*2,3,5 ，则下一个结果i+1 必然是通过 j+1 * 2，3，5 来计算的，不能是原来的i，因此
         * 可以通过三个指针，保存当前位置i是通过前面的j计算得到的，从而防止重复计算。
         *
         * @param n
         * @return
         */
        public int nthUglyNumber(int n) {
            int[] uglys = new int[n];
            uglys[0] = 1;
            int p2 = 0;
            int p3 = 0;
            int p5 = 0;
            int i = 1;
            while (i < n) {
                uglys[i] = Math.min(Math.min(uglys[p2] * 2, uglys[p3] * 3), uglys[p5] * 5);
                if (uglys[i] == uglys[p2] * 2) {
                    p2++;
                }
                if (uglys[i] == uglys[p3] * 3) {
                    p3++;
                }
                if (uglys[i] == uglys[p5] * 5) {
                    p5++;
                }
                i++;
            }
            return uglys[n-1];
        }
    }

    class test1 {

        /**
         * 优先队列+set，
         *
         * @param n
         * @return
         */
        public int nthUglyNumber(int n) {
            PriorityQueue<Long> queue = new PriorityQueue<>(Long::compareTo);
            Set<Long> set = new HashSet<>();
            set.add(1L);
            queue.add(1L);
            int i = 1;
            while (i < n) {
                Long poll = queue.poll();
                i++;
                for (int j = 0; j < mult.length; j++) {
                    Long newp = poll * mult[j];
                    if (!set.contains(newp)) {
                        queue.add(newp);
                        set.add(newp);
                    }
                }
            }
            return queue.peek().intValue();

        }

        int[] mult = {2, 3, 5};
    }

    class test {
        /**
         * 超时
         *
         * @param n
         * @return
         */
        public int nthUglyNumber(int n) {
            Set<Integer> set = new HashSet<>();
            int i = 1;
            set.add(1);
            while (set.size() < n) {
                i++;
                int s = i;
                if (s % 5 == 0 && set.contains(s / 5)) {
                    set.add(i);
                } else if (s % 3 == 0 && set.contains(s / 3)) {
                    set.add(i);
                } else if (s % 2 == 0 && set.contains(s / 2)) {
                    set.add(i);
                }
            }
            return i;
        }
    }

    /**
     * 辗转除余
     */
    class Solution {
        public boolean isUgly(int n) {
            if (n == 0) {
                return false;
            }
            while (n != 1) {
                if (n % 5 == 0) {
                    n /= 5;
                } else if (n % 3 == 0) {
                    n /= 3;
                } else if (n % 2 == 0) {
                    n /= 2;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
