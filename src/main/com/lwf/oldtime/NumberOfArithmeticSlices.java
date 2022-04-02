package com.lwf.oldtime;

import java.util.ArrayList;
import java.util.List;

/**
 * author Administrator
 * time 2019-08-11
 */
public class NumberOfArithmeticSlices {
    public static void main(String[] args) {
        System.out.println(new NumberOfArithmeticSlices().numberOfArithmeticSlices(new int[]{1, 2, 3, 8, 9, 10}));
    }
    public int numberOfArithmeticSlices(int[] A) {
        if (A==null|| A.length<3) return 0;
        List<Integer> list=new ArrayList<>();
        int start =0;
        int diff=A[start+1]-A[start];
        for (int i = 2; i < A.length; i++) {
            if((A[i]-A[i-1])==diff){
                continue;
            }else {
                if (i-start>2){
                    list.add(i-start);
                }
                start=i-1;
                diff=A[start+1]-A[start];
            }
        }
        if (A.length-start>2){
            list.add(A.length-start);
        }
        if (list.size()==0){
            return 0;
        }
        int rtn=0;
        for (int i = 0; i < list.size(); i++) {
            rtn+=((list.get(i)-2)*(list.get(i)-1))/2;
        }
        return rtn;
    }



}