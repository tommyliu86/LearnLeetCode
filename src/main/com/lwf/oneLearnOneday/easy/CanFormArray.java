package com.lwf.oneLearnOneday.easy;

import java.io.PipedReader;
import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/9/22 18:56
 */
public class CanFormArray {
    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            int[] marks=new int[101];
            Arrays.fill(marks,-1);
            for (int i = 0; i < pieces.length; i++) {
               marks[ pieces[i][0]]=i;
            }
            int i=0;
            while (i<arr.length){
                int target = arr[i];
                if (marks[target]==-1) {
                    return false;
                }
                int[] piece = pieces[marks[target]];
                for (int j = 0; j < piece.length; j++) {
                    if (arr[i]!=piece[j]){
                        return false;
                    }
                    i++;
                }
            }
            return true;
        }
    }
}
