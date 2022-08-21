package com.lwf.oneLearnOneday.normal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SequenceReconstruction {
    class Solution {
        public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
            int[] bein=new int[nums.length+1];
            Set<Integer>[] toNode=new Set[nums.length+1];
            for (int i = 0; i < toNode.length; i++) {
                toNode[i]=new HashSet<>();
            }
            for (int i = 0; i < sequences.length; i++) {
                int[] sequence = sequences[i];
                int pre = sequence[0];
                for (int j = 1; j < sequence.length; j++) {
                    int k = sequence[j];
                    if (!toNode[pre].contains(k)){

                        toNode[pre].add(k);
                        bein[k]++;
                    }
                    pre=k;
                }
            }
            Queue<Integer> zero=new LinkedList<>();
            for (int i = 1; i < bein.length; i++) {
                if (bein[i]==0){
                    zero.offer(i);
                }
            }
            while (!zero.isEmpty()){
                if (zero.size()>1){
                    return false;
                }
                Integer pop = ((LinkedList<Integer>) zero).pop();
                Set<Integer> integers = toNode[pop];
                for (Integer integer : integers) {
                    bein[integer]--;
                    if (bein[integer]==0){
                        zero.offer(integer);
                    }
                }
            }
            return true;
        }
    }
}
