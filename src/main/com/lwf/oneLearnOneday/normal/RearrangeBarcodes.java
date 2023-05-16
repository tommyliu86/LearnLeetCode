package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/5/15 14:05
 */
public class RearrangeBarcodes {


    class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
            int l = barcodes.length;
            PriorityQueue<int[]> map=new PriorityQueue<>(Comparator.comparingInt(i->-i[1]));
            Arrays.sort(barcodes);
            int pre=0;
            for (int i = 1; i < barcodes.length; i++) {
                if (barcodes[i]!=barcodes[i-1]) {
                    map.add(new int[]{ barcodes[i-1], i-pre});
                    pre=i;
                }
            }
            map.add(new int[]{ barcodes[l-1],l-pre});

            int[] ans=new int[barcodes.length];
            int i=0;
            while (!map.isEmpty()){
                int[] poll = map.poll();
                int val = poll[0];
                int count = poll[1];
                for (int j = 0; j < count; j++) {
                    if (i>=l){
                        i=1;
                    }
                    ans[i]=val;
                    i+=2;
                }

            }
            return ans;
        }
    }
}
