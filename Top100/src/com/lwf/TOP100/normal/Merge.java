package com.lwf.TOP100.normal;

import java.util.Arrays;


/**
 * author Administrator
 * time 2019-10-13-22:57
 */
public class Merge {


    public int[][] merge(int[][] intervals) {

        if (intervals.length==0) return intervals;

        Arrays.sort(intervals, (int[] o1, int[] o2)-> {
                    if (o1[0]>o2[0]) {
                        return 1;
                    }
                    else if(o1[0]==o2[0]) {
                        return 0;
                    }else{
                        return -1;
                    }
                }
        );
        int[][] merges=new int[intervals.length][2];
        merges[0]=intervals[0];
        int j=0;
        for (int i = 1; i < intervals.length; i++) {
            if (merges[j][1]>=intervals[i][0]){
                merges[j][1]=Math.max(merges[j][1],intervals[i][1]);
            }else{
                j++;
                merges[j]=intervals[i];
            }
        }
        return Arrays.copyOf(merges,j+1);
    }
    public int[][] merge1(int[][] intervals) {

        if (intervals.length==0) return intervals;
        int[] starts=new int[intervals.length];
        int[] ends=new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i]=intervals[i][0];
            ends[i]=intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int[][] merges=new int[intervals.length][2];
        int len=0;
        for (int i = 0, j=0; i < ends.length; i++) {
            if (ends[i]<starts[i+1]||i==ends.length-1){
                merges[len][0]=starts[j];
                merges[len][1]=ends[i];
                j=i+1;
                len++;
            }
        }
        return Arrays.copyOf(merges ,len);

    }
}
