package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

public class CheckDistances {
    class Solution {
        public boolean checkDistances(String s, int[] distance) {
            int[] dis1=new int[26];
            Arrays.fill(dis1,-1);

            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (dis1[index]==-1) {
                    dis1[index]=i;
                }else{
                    if (distance[index]!=i- dis1[index]-1){
                        return false;
                    }
                }

            }
            return true;
        }
    }
}
