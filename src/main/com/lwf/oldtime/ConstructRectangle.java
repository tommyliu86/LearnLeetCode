package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-08-18-23:26
 * {@link 492.md}
 */
public class ConstructRectangle {
    public int[] constructRectangle(int area) {
        int r=(int) Math.sqrt(area);
        while (area%r!=0){
            r--;
        }
        int[] ints=new int[2];
        ints[0]=area/r;
        ints[1]=r;
        return ints;
    }
}
