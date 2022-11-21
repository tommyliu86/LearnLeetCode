package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2022/11/21 10:01
 */
public class ChampagneTower {
    /**
     * 杨辉三角
     */
    class Solution {
        public double champagneTower(int poured, int query_row, int query_glass) {
            double[] rows=new double[query_row+1];
            rows[0]=poured;
            for (int i = 1; i <= query_row; i++) {
                double cur=rows[0];
                rows[0]=0;
                for (int j = 0; j < i; j++) {
                    double next=rows[j+1];
                    rows[j+1]=0;
                    if (cur>1){
                        rows[j]+=(cur-1)/2;
                        rows[j+1]+=(cur-1)/2;
                    }
                    cur=next;
                }
            }
            return Math.min(1, rows[query_glass]);
        }
    }
}
