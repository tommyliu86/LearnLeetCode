package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * 1465. 切割后面积最大的蛋糕
 * https://leetcode.cn/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/?envType=daily-question&envId=2023-10-27
 *
 * @author liuwenfei
 * @date 2023/10/27 8:47
 */
public class MaxArea1 {
    public static void main(String[] args) {
        System.out.println((long) 1000000000 * 1000000000);
    }

    /**
     * 排序后，直接找 h 和w上的最大间隔即可
     * 向下，向右遍历
     */
    class Solution {
        public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
            Arrays.sort(horizontalCuts);
            Arrays.sort(verticalCuts);
            int x=0,maxx=0;
            for (int i = 0; i < verticalCuts.length; i++) {
                maxx=Math.max(maxx,verticalCuts[i]-x);
                x=verticalCuts[i];
            }
            maxx=Math.max(maxx,w-x);
            int y=0,maxy=0;
            for (int i = 0; i < horizontalCuts.length; i++) {
                maxy=Math.max(maxy ,horizontalCuts[i]-y);
                y=horizontalCuts[i];
            }
            maxy=Math.max(maxy,h-y);

            int mod = 1000_000_000 + 7;
            return (int) ((long)maxx*maxy %mod);
        }
    }

    /**
     * 暴力解法，直接遍历，会超时
     * 向下，向右遍历
     */
    class Solution1 {
        public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
            int mod = 1000_000_000 + 7;
            Arrays.sort(horizontalCuts);
            Arrays.sort(verticalCuts);
            int y = 0;
            long ans = 0;
            for (int i = 0; i <= horizontalCuts.length; i++) {
                int hor = h;
                if (i < horizontalCuts.length)
                    hor = horizontalCuts[i];

                int yh = hor - y;

                int x = 0;
                for (int j = 0; j <= verticalCuts.length; j++) {
                    int ver = w;
                    if (j < verticalCuts.length)
                        ver = verticalCuts[j];

                    ans = Math.max((long) (ver - x) * yh, ans);
                    x = ver;
                }
                y = hor;
            }
            //注意进行类型转换时， 优先级是最高的，会直接进行转换后计算！
            return (int) (ans % mod);
        }
    }
}
