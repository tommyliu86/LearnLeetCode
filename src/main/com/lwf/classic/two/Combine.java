package com.lwf.classic.two;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/12/29 16:05
 */
public class Combine {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            recurse(1,new ArrayList<>(),k,n);
            return ans;
        }

        public void recurse(int i, List<Integer> list, int k,int n) {

            if ( list.size() == k) {
                ans.add(new ArrayList<>(list));
                return;
            }
            if (i>n){
                return;
            }
            list.add(i);
            recurse(i + 1, list, k,n);
            list.remove(list.size() - 1);
            recurse(i + 1, list, k,n);
        }

        List<List<Integer>> ans = new ArrayList<>();
    }
}
