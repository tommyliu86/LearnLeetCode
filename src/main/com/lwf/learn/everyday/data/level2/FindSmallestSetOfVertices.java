package com.lwf.learn.everyday.data.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-13 16:04
 */
public class FindSmallestSetOfVertices {
    class Solution {
        public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
            int[] tos=new int[n];
            for (int i = 0; i < edges.size(); i++) {
                List<Integer> list = edges.get(i);
               tos[ list.get(1)]++;
            }
            List<Integer> rtn=new ArrayList<>();
            for (int i = 0; i < tos.length; i++) {
                if (tos[i]==0) {
                    rtn.add(i);
                }
            }
            return rtn;
        }
    }
}
