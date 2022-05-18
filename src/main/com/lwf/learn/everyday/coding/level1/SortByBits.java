package com.lwf.learn.everyday.coding.level1;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-12 09:15
 */
public class SortByBits {
    class Solution {
        public int[] sortByBits(int[] arr) {
            quick(arr,0,arr.length-1);
            return arr;
        }
        Random random=new Random();
        public void quick(int[] arr,int l,int r){
            if (l>=r){return;}
            int i = random.nextInt(r - l + 1) + l;
            int m=arr[i];
            arr[i]=arr[l];

            int nl=l;
            int nr=r;
            while (nl<nr){
                while (nl<nr&&compares(arr[nr],m)>0){
                    nr--;
                }
                arr[nl]=arr[nr];
                while (nl<nr&&compares(arr[nl],m)<=0){
                    nl++;
                }
                arr[nr]=arr[nl];
            }
            arr[nl]=m;
            quick(arr,l,nl-1);
            quick(arr,nl+1,r);

        }
        public int compares(int a,int b){
            if (Integer.bitCount(a)==Integer.bitCount(b)) {
                return Integer.compare(a,b);
            }else{
                return Integer.compare(Integer.bitCount(a),Integer.bitCount(b));
            }
        }
    }
}
