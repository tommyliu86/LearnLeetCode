package com.lwf.learn.everyday.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-13 10:44
 */
public class GetRow {
    class Solution {
        public List<Integer> getRow(int rowIndex) {

            int[] is=new int[rowIndex+1];
            is[0]=1;

            int i=1;
            while (i<=rowIndex){
                int pre=0;
                int cur=0;
                for (int j = 0; j <= i; j++) {
                    cur=is[j];
                    is[j]+=pre;
                    pre=cur;
                }
                i++;
            }

            List<Integer> rtn=new ArrayList<>();
            for (int j = 0; j < is.length; j++) {
                rtn.add(is[j]);
            }
            return rtn;
        }
    }
}
