package com.lwf.oldtime;

import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

/**
 * author Administrator
 * time 2019-08-15-0:29
 * {@link 447.md}
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        if (points.length<3) return 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            for (int j = 0; j <  points.length; j++) {
                if (j==i) continue;
                Integer len=(int)(Math.pow((points[i][0]-points[j][0]),2)+Math.pow((points[i][1]-points[j][1]),2));

                    count+=map.getOrDefault(len,0)*2;
                map.put(len,map.getOrDefault(len,0)+1);

            }
        }
        return count;
    }
}
