package com.lwf.learn.everyday.dp.level1.d2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-03 09:43
 */
public class GetRow {
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            int[] ints=new int[rowIndex+1];
            ints[0]=1;
            for (int i = 1; i <= rowIndex; i++) {
                int pre=0;
                for (int j = 0; j <= i; j++) {
                    int temp=ints[j];
                    ints[j]=pre+ints[j];
                    pre=temp;
                }
            }
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < ints.length; i++) {
                list.add(ints[i]);
            }
            return list;
        }
    }
}
