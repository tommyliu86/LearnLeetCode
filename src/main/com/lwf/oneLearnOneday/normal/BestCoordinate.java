package com.lwf.oneLearnOneday.normal;

import com.sun.source.tree.IfTree;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuwenfei
 * @date 2022/11/2 9:09
 */
public class BestCoordinate {
    public static void main(String[] args) {
        System.out.println(5/(1+Math.sqrt(5)));
        System.out.println(1 + (1 / (1 + Math.sqrt(2))) > 1);
    }


    class Solution1 {

        public int[] bestCoordinate(int[][] towers, int radius) {
            int xMax = Integer.MIN_VALUE, yMax = Integer.MIN_VALUE;
            for (int[] tower : towers) {
                int x = tower[0], y = tower[1];
                xMax = Math.max(xMax, x);
                yMax = Math.max(yMax, y);
            }
            int cx = 0, cy = 0;
            int maxQuality = 0;
            for (int x = 0; x <= xMax; x++) {
                for (int y = 0; y <= yMax; y++) {
                    int[] coordinate = {x, y};
                    int quality = 0;
                    for (int[] tower : towers) {
                        int squaredDistance = getSquaredDistance(coordinate, tower);
                        if (squaredDistance <= radius * radius) {
                            double distance = Math.sqrt(squaredDistance);
                            quality += (int) Math.floor(tower[2] / (1 + distance));
                        }
                    }
                    if (quality > maxQuality) {
                        cx = x;
                        cy = y;
                        maxQuality = quality;
                    }
                }
            }
            return new int[]{cx, cy};
        }

        public int getSquaredDistance(int[] coordinate, int[] tower) {
            return (tower[0] - coordinate[0]) * (tower[0] - coordinate[0]) + (tower[1] - coordinate[1]) * (tower[1] - coordinate[1]);
        }
    }

}
