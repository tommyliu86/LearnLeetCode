package com.lwf.learn.everyday.arith.first.d2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-23 15:17
 */
public class Combine {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> rtn=new ArrayList<>();
            recursive(n,1,new ArrayList<>(),rtn,k);
            return rtn;
        }
        public void recursive(int n,int i,List<Integer> list,List<List<Integer>> rtn,int k){

            if (list.size()==k){
                rtn.add(new ArrayList<>(list));
                return;
            }
            for (int j = i; j <= n+1-(k-list.size()); j++) {
                list.add(j);
                recursive(n,j+1,list,rtn,k);
                list.remove(list.size()-1);
            }
        }
    }
}
