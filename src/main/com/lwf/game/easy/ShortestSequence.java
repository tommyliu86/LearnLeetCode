package com.lwf.game.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShortestSequence {
    class Solution{
        public int shortestSequence(int[] rolls, int k) {
            Set<Integer> haved=new HashSet<>();
            int len=1;
            for (int i = 0; i < rolls.length; i++) {
               haved.add(  rolls[i]);
               if (haved.size()==k){
                   haved.clear();
                   len++;
               }
            }
            return len;
        }

    }

    class Solution1 {
        public int shortestSequence(int[] rolls, int k) {
            List<Integer>[] index = new List[k + 1];
            for (int i = 0; i < index.length; i++) {
                index[i] = new ArrayList<>();

            }
            for (int i = 0; i < rolls.length; i++) {
                int roll = rolls[i];
                index[roll].add(i);
            }
            int rtn = k;
            for (int i = 1; i <= k; i++) {
                rtn = Math.min(rtn, recursive(index, i, -1, 1, k));
                if (rtn == 1) {
                    return rtn;
                }
            }
            return rtn;
        }

        public int recursive(List<Integer>[] indexes, int find, int curIndex, int len, int k) {
            List<Integer> list = indexes[find];
            if (list.isEmpty() || len == k) {
                return len;
            }
            int nextIndex = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > curIndex) {
                    nextIndex = list.get(i);
                    break;
                }
            }
            if (nextIndex == -1) {
                return len;
            }
            int l = k;
            for (int i = 1; i <= k; i++) {
                l = Math.min(recursive(indexes, i, nextIndex, len + 1, k), l);
            }
            return l;
        }
    }
}
