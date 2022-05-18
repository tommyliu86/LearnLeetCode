package com.lwf.learn.everyday.dp.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-13 10:29
 */
public class Generate {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> rtn=new ArrayList<>();
            int i=0;
            while (i<numRows){
                if (i==0){
                    rtn.add(new ArrayList<Integer>(Arrays.asList(1)));
                }else{
                    List<Integer> list = rtn.get(i - 1);
                    List<Integer> l=new ArrayList<>();
                    for (int j = 0; j <= list.size(); j++) {
                        l.add(j==0?list.get(j):(j==list.size()?list.get(j-1):(list.get(j)+list.get(j-1))));
                    }
                    rtn.add(l);
                }
                i++;
            }
            return rtn;
        }
    }
}
