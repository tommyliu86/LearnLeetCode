package com.lwf.learn.everyday.arith.second.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-22 14:31
 */
public class CombinationSum2 {
    /**
     * 在目标大于当前index值的时候，对index==index+1进行判断查找是否有重复元素，
     * 找到重复元素的index 区间，对重复元素进行迭代取值，分别取0~k个元素 nextIndex取为重复元素的下一个元素进行求和
     * 注意，如果在重复元素取值过程中target==0，则表示当前组合也是一个解，需要添加大rtn中
     */
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> rtn = new ArrayList<>();
            recursive(candidates, target, 0, new ArrayList<Integer>(), rtn);
            return rtn;
        }

        private void recursive(int[] candi, int target, int index, List<Integer> list, List<List<Integer>> rtn) {
            if (index >= candi.length) {
                return;
            }
            if (candi[index] > target) {
                return;
            } else if (candi[index] == target) {
                list.add(target);
                rtn.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return;
            } else {
                int next = index;
                while (next < candi.length - 1 && candi[next] == candi[next + 1]) {
                    next++;
                }
                if (next > index) {
                    int newTarget = target;
                    List<Integer> newList = new ArrayList<>(list);
                    while (index <= next && newTarget > 0) {
                        newList.add(candi[index]);
                        recursive(candi, newTarget - candi[index], next + 1, newList, rtn);
                        newTarget -= candi[index];
                        index++;
                    }
                    if (newTarget == 0) {
                        rtn.add(new ArrayList<>(newList));
                    }
                } else {
                    recursive(candi, target, index + 1, list, rtn);
                    list.add(candi[index]);
                    recursive(candi, target - candi[index], index + 1, list, rtn);
                    list.remove(list.size() - 1);
                }


            }
        }
    }
}

