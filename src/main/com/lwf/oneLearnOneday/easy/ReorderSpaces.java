package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;
import java.util.List;

public class ReorderSpaces {
    class Solution {
        public String reorderSpaces(String text) {
            char[] chars = text.toCharArray();
            int spaces=0;
            int t=-1;
            int[] start=new int[chars.length];
            int[] end=new int[chars.length];

            int i=0;
            while (i<chars.length){
                if (chars[i]==' ') {
                    spaces++;
                    i++;
                    continue;
                }
                t++;
                start[t]=i;
                while (i<chars.length&&chars[i]!=' '){
                    i++;
                }
                end[t]=i;
            }

            int need= t>0?spaces/(t):0;
            char[] rtns=new char[chars.length];
            i=0;
            for (int j = 0; j < t + 1; j++) {
                for (int k = 0; k < end[j]-start[j]; k++) {
                    rtns[i++]=chars[start[j]+k];
                }
                if (j<t){
                    for (int k = 0; k < need; k++) {
                        rtns[i++]=' ';
                    }
                }
            }
            while (i<rtns.length){
                rtns[i++]=' ';
            }
            return String.valueOf(rtns);
        }
    }
}
