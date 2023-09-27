package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuwenfei
 * @date 2023/9/27 8:54
 */
public class FilterRestaurants {
    class Solution {
        public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
            return Arrays.stream(restaurants).filter(a -> ((a[2] & veganFriendly) == veganFriendly) && maxPrice >= a[3] && maxDistance >= a[4])
                    .sorted((a, b) ->
                            {
                                if (a[1] == b[1]) {
                                    return Integer.compare(b[0], a[0]);
                                } else {
                                    return Integer.compare(b[1], a[1]);
                                }
                            }
                    ).map(a -> a[0]).collect(Collectors.toList());
        }
    }
}
