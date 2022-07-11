package com.lwf.oneLearnOneday.easy;

import java.util.HashMap;
import java.util.Map;

public class MinCostToMoveChips {
    class Solution {
        public int minCostToMoveChips(int[] position) {
            int i1=0;
            int i2=0;

            for (int i = 0; i < position.length; i++) {
                if ((position[i]&1)==1){
                    i1+=position[i];
                }else{
                    i2+=position[i];
                }
            }
            return Math.min(i1,i2);

        }
    }
}
