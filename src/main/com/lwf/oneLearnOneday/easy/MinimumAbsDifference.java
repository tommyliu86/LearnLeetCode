package com.lwf.oneLearnOneday.easy;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference {
    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
                Arrays.sort(arr);
                int min=Integer.MAX_VALUE;
                List<Integer> indexes=new ArrayList<>();
                for (int i = 1; i < arr.length; i++) {
                  int diff=  arr[i]-arr[i-1];
                  if(diff <min){
                    min=diff;
                    indexes.clear();
                    indexes.add(i);
                  }else if(diff==min){
                    indexes.add(i);
                  }
                }
                List<List<Integer>> rtn=new ArrayList<>();
                for (int i = 0; i < indexes.size(); i++) {
                  int j=  indexes.get(i);
                  List<Integer> list=  new ArrayList<>();
                  list.add(arr[j-1]);
                  list.add(arr[j]);

                }
                return rtn;
        }
    }
}
