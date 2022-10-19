package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author liuwenfei
 * @date 2022/10/19 8:55
 */
public class CountStudents {
    class Solution {
        public int countStudents(int[] students, int[] sandwiches) {
            int[] counts = new int[2];

            counts[1] = Arrays.stream(students).sum();
            counts[0] = students.length - counts[1];
            int i = 0;
            while (i < sandwiches.length) {
                int sandwich = sandwiches[i];
                if (counts[sandwich] > 0) {
                    counts[sandwich]--;
                } else {
                    break;
                }
                i++;
            }
            return sandwiches.length - i;
        }
    }
}
