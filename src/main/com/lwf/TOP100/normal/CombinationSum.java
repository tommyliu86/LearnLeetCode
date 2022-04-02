package com.lwf.TOP100.normal;


import javax.swing.text.html.HTML;
import java.util.*;

/**
 * author Administrator
 * time 2019-10-08-22:13
 * https://leetcode-cn.com/problems/combination-sum/
 * 39. 组合总和
 * {@link 39.md}
 */
public class CombinationSum {
    public  static class main1{
        public static void main(String[] args) {
            Integer a=1;
            Integer b=null;
            System.out.println(a==b);
            System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8));
        }
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> lists = new ArrayList<>();
            backTracking(0, target, candidates, new LinkedList<>(), lists);
            return lists;
        }

        void backTracking(int currIndex, int target, int[] ints, Deque<Integer> list, List<List<Integer>> lists) {
            if (currIndex >= ints.length) return;
            int current = ints[currIndex];
            if (current > target) {
                return;
            }
            else if (current== target){
                list.add(current);
                lists.add(new ArrayList<>(list));
                list.removeLast();
            }else{
                backTracking(currIndex+1,target,ints,list,lists);
                list.add(current);
                backTracking(currIndex,target-current, ints, list, lists);
                list.removeLast();
            }

        }
    }
    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        backTracking(0, target, candidates, new ArrayList<Integer>(), lists);
        return lists;
    }



    void backTracking(int currIndex, int target, int[] ints, List<Integer> list, List<List<Integer>> lists) {
        if (currIndex >= ints.length) return;
        int current = ints[currIndex];
        if (current > target) {
            return;
        } else {
            int count = target / current;
            int nextTarget = target % current;
            if (nextTarget == 0) {
                lists.add(listGet(list, count, current));
            }
            listAdd(list, count, current);
            backTracking(currIndex + 1, nextTarget, ints, list, lists);
            for (int i = 1; i <= count; i++) {
                list.remove((Object) current);
                backTracking(currIndex + 1, nextTarget + i * current, ints, list, lists);

            }

        }
    }

    <T> List<T> listGet(List<T> list, int count, T element) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (T t : list) {
            arrayList.add(t);
        }
        for (int i = 0; i < count; i++) {
            arrayList.add(element);
        }
        return arrayList;
    }

    <T> List<T> listAdd(List<T> list, int count, T element) {
        for (int i = 0; i < count; i++) {
            list.add(element);
        }
        return list;
    }

}
