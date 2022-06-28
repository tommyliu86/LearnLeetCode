package com.lwf.learn.everyday.data.level2.d2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-22 15:40
 */
public class GetRow {
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> rtn=new ArrayList<>();
            rtn.add(1);
            for (int i = 0; i <= rowIndex; i++) {
                int pre=0;
                for (int j = 0; j < i + 1; j++) {
                    if (j>=rtn.size()){
                        rtn.add(pre);
                    }else{
                        Integer temp = rtn.get(j);
                        rtn.set(j,temp+pre);
                        pre=temp;
                    }

                }
            }
            return rtn;

        }
    }
}
