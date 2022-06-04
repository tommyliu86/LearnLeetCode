package com.lwf.learn.everyday.dp.level1.d2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-03 09:37
 */
public class Generate {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> rtn=new ArrayList<>();
            List<Integer> list=new ArrayList<>();
            list.add(1);
            rtn.add(list);
            for (int i = 1; i < numRows; i++) {
                List<Integer> pre = rtn.get(i - 1);
                List<Integer> cur=new ArrayList<>();
                for (int j = 0; j <= pre.size(); j++) {
                    cur.add((j-1<0?0:pre.get(j-1))+(j==pre.size()?0:pre.get(j)));
                }
                rtn.add(cur);
            }
            return rtn;
        }
    }
}
