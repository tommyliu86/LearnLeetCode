package com.lwf.learn.everyday.data.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generate {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> rtn=new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                if (i==0){
                    rtn.add(new ArrayList<>(Arrays.asList(1)));
                    continue;
                }
                List<Integer> pre = rtn.get(i - 1);
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j <= i+1; j++) {
                    list.add(j==0? pre.get(j):j==i+1?pre.get(j-1):(pre.get(j-1)+pre.get(j)));
                }
                rtn.add(list);
            }
              return rtn;
        }
    }
}
