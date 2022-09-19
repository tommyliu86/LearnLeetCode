package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author liuwenfei
 * @date 2022/9/16 9:00
 */
public class RectangleArea {
    class Solution {
        public int rectangleArea(int[][] rectangles) {

            //扫描线。。。
            TreeMap<Integer, List<int[]>> map = new TreeMap<>();
            //记录矩形左右线段
            for (int[] p : rectangles) {
                List<int[]> list = map.getOrDefault(p[0], new ArrayList<int[]>());
                list.add(new int[]{p[1], p[3], 0});
                map.put(p[0], list);
                list = map.getOrDefault(p[2], new ArrayList<int[]>());
                list.add(new int[]{p[1], p[3], 1});
                map.put(p[2], list);
            }
            TreeMap<Integer, Integer> line = new TreeMap<>();
            int mod = (int) 1e9 + 7, x = 0, y = map.firstKey();
            long sum = 0;
            //开始扫描
            for (Integer i : map.keySet()) {
                sum += (long) x * (i - y);
                //将线段添加到线上
                for (int[] p : map.get(i)) {
                    if (p[2] == 0) {
                        line.put(p[0], line.getOrDefault(p[0], 0) + 1);
                        line.put(p[1], line.getOrDefault(p[1], 0) - 1);
                    } else {
                        if (line.get(p[0]) == 1) line.remove(p[0]);
                        else line.put(p[0], line.get(p[0]) - 1);
                        if (line.get(p[1]) == -1) line.remove(p[1]);
                        else line.put(p[1], line.get(p[1]) + 1);
                    }
                }
                x = 0;
                y = i;
                int l = -1, n = 0;
                //计算扫描得到的长度
                for (Integer I : line.keySet()) {
                    n += line.get(I);
                    l = l < 0 ? I : l;
                    if (n == 0) {
                        x += (I - l);
                        l = -1;
                    }
                }
            }
            return (int) (sum % mod);
        }
    }
}
