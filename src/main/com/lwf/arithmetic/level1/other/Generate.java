package com.lwf.arithmetic.level1.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-22 16:50
 */
public class Generate {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> rtn = new ArrayList<>();
            for (int i = 1; i <= numRows; i++) {
                List<Integer> list = new ArrayList<>();
                if (i == 1) {
                    list.add(1);
                    rtn.add(list);
                } else {
                    List<Integer> pre = rtn.get(i - 2);
                    for (int j = 0; j < i; j++) {
                        int cur = 0;
                        if (j == 0) {
                            cur += pre.get(j);
                        } else if (j >= pre.size()) {
                            cur += pre.get(j - 1);
                        } else {
                            cur += pre.get(j) + pre.get(j - 1);
                        }
                        list.add( cur);
                    }
                    rtn.add(list);

                }
            }
            return rtn;
        }
    }
}
