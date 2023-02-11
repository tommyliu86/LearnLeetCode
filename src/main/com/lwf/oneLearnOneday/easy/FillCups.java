package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

public class FillCups {
    class Solution {
        public int fillCups(int[] amount) {
            Arrays.sort(amount);
            if (amount[0]+amount[1]<=amount[2])return amount[2];

            int remain = amount[0] + amount[1] - amount[2];
            return amount[2]+ remain /2+(remain%2==0?0:1);
        }
    }
}
