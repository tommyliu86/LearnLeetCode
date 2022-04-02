package com.lwf.oldtime;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * author Administrator
 * time 2019-08-08
 */
public class ReadBinaryWatch {
    public static void main(String[] args) {
        int h=9;
        int m=9;
        System.out.println(Instant.now());
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            String.format("%d:%02d",h,m);
        }
      long end=  System.currentTimeMillis();

        System.out.println(Instant.now());
        System.out.println(end-start);
    }
    static HashMap<Integer, List<Integer>> hours = new HashMap<>();
    static HashMap<Integer, List<Integer>> minutes = new HashMap<>();

    static {
        for (int i = 0; i < 12; i++) {
            int binary = getBinary(i);
            if (hours.containsKey(binary)) {
                List<Integer> list = hours.get(binary);
                list.add(i);
                hours.put(binary, list);
            } else {
                List<Integer> list = new ArrayList<>(Arrays.asList(i));
                hours.put(binary, list);
            }
        }
        for (int i = 0; i < 60; i++) {
            int binary = getBinary(i);
            if (minutes.containsKey(binary)) {
                List<Integer> list = minutes.get(binary);
                list.add(i);
                minutes.put(binary, list);
            } else {
                List<Integer> list = new ArrayList<>(Arrays.asList(i));
                minutes.put(binary, list);
            }
        }
    }

    public List<String> readBinaryWatch(int num) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i <= Math.min(3, num); i++) {
            int j = num - i;
            if (j>5) continue;
            List<Integer> hourList = hours.get(i);
            List<Integer> minutList = minutes.get(j);
            for (Integer houri : hourList) {
                for (Integer minj : minutList) {
                    list.add(String.format("%d:%02d", houri, minj));
                }
            }

        }
        return list;
    }

    static int getBinary(int n) {
        int rtn = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                rtn += 1;
            }
            n = n >> 1;
        }
        return rtn;
    }
}
class solution{
    public List<String> readBinaryWatch(int num) {
        int[] roots=new int[10];
        List<String> rtn=new ArrayList<>();
        backTrack(rtn,roots,0,num);
        return rtn;
    }
    void backTrack(List<String> rtn,int[] root,int index,int num){
        if (num<=0){
            String h=getHour(root);
            if (null!=h){
                rtn.add(h);
            }
            return;
        }
        if (index<10){
            //回溯算法的思想在于，在选择点上，若选择该节点，则记录为回溯点并继续，然后再设置不选择该节点，然后再继续推导。
            //此处先选择index节点，则num数会少一位，继续
            root[index]=1;
            num--;
            backTrack(rtn,root,index+1,num);
            //回溯，设置index节点不被选择，则num数保持不变，继续遍历。
            num++;
            root[index]=0;
            backTrack(rtn,root,index+1,num);
        }
    }
    String getHour(int[] root){
        int hour=0;
        for (int i = 0; i < 4; i++) {
            hour+=root[i]==1? Math.pow(2,i):0;
        }
        if (hour>11){
            return null;
        }
        int minute=0;
        for (int i = 4; i < 10; i++) {
            minute  +=root[i]==1? Math.pow(2,i-4):0;
        }
        if (minute>59){
            return null;
        }
        return String.format("%d:%02d",hour,minute  );
    }
}
