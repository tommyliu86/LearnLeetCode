package com.lwf.learn.everyday.data.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-27 18:14
 */
public class GetRow {
    class Solution {
        public List<Integer> getRow(int rowIndex) {

            int[] row = new int[rowIndex + 2];
            row[1] = 1;
            for (int i = 2; i <= rowIndex+1; i++) {
                int pre = 0;
                for (int j = 1; j <= i; j++) {
                    int temp = row[j];
                    row[j] += pre;
                    pre = temp;
                }
            }
            List<Integer> rtn=new ArrayList<>();
            for (int i = 1; i < row.length; i++) {
                rtn.add(row[i]);
            }
            return rtn;
        }
    }
}
