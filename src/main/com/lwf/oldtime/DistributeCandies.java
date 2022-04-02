package com.lwf.oldtime;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * author Administrator
 * time 2019-08-29-23:09
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {

        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < candies.length&&set.size()<candies.length/2; i++) {
            set.add(candies[i]);
        }
        return set.size();
    }
}
