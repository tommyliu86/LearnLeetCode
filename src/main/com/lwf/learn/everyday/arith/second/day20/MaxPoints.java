package com.lwf.learn.everyday.arith.second.day20;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-02 13:51
 */
public class MaxPoints {
    public static void main(String[] args) {
        int[][] ints = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        new Solution().maxPoints(ints);
    }

    static class Solution {
        public int maxPoints(int[][] points) {

            int max = 0;
            for (int i = 0; i < points.length; i++) {
                HashMap<Point, Integer> map = new HashMap<>();
                for (int j = i + 1; j < points.length; j++) {
                    int x = points[j][0] - points[i][0];
                    int y = points[j][1] - points[i][1];
                    int gcd = gcd(x > 0 ? x : -1 * x, y > 0 ? y : -1 * y);
                    x /= gcd;
                    y /= gcd;
                    Point l = new Point(x, y);
                    if (map.containsKey(l)) {
                        int i1 = map.get(l) + 1;
                        max = Math.max(i1, max);
                        map.put(l, i1);
                    } else {
                        max = Math.max(1, max);
                        map.put(l, 1);
                    }
                }
            }
            return max + 1;
        }

        static class Point {
            int x;
            int y;

            public Point() {

            }

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj instanceof Point) {
                    Point obj1 = (Point) obj;
                    return (obj1.x == this.x && obj1.y == this.y) || (obj1.x == -1 * this.x && obj1.y == -1 * this.y);
                } else {
                    return false;
                }
            }

            @Override
            public int hashCode() {
                return x * y;
            }
        }

        /**
         * 辗转相除求最大公约数
         *
         * @param b
         * @param s
         * @return
         */
        public int gcd(int b, int s) {
            return s != 0 ? gcd(s, b % s) : b;
        }
    }
}
