package com.lwf.offer.two;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/12/29 16:27
 */
public class CombinationSum {
    /**
     * 注意使用深度遍历和递归时的些微区别，一个使用了for循环，一个不用for循环，直接进行二次递归调用即可实现向后的遍历了
     * 递归、深度遍历搜索，每一个位置的选+后续all和不选+后续all，如果选择了i则后续仍然可以选择i或不选i，当不选i时，表示后续也不应该再选i，这样可以保证
     * 整个路劲中不会有回头路（重复情况，223,232）
     */
    class Solution {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            dfs(candidates, 0, target, new ArrayList<>(), ans);
            return ans;
        }



        //深度遍历，
        public void dfs(int[] can, int i, int t, List<Integer> list, List<List<Integer>> ans) {
            if (i == can.length || t < 0) {
                return;
            }
            //使用for循环，则表示当前取哪个以及之后的所有情况，因此每个dfs的index也要响应的向后。
            for (int j = i; j < can.length; j++) {
                if (can[j] > t) {
                    return;
                } else if (can[j] == t) {
                    list.add(t);
                    ans.add(new ArrayList<>(list));
                    list.remove(list.size() - 1);
                } else {
                    list.add(can[j]);
                    dfs(can, j, t - can[j], list, ans);
                    list.remove(list.size() - 1);

                }
            }
        }
    }
    /**
     * 递归、深度遍历搜索，每一个位置的选+后续all和不选+后续all，如果选择了i则后续仍然可以选择i或不选i，当不选i时，表示后续也不应该再选i，这样可以保证
     * 整个路劲中不会有回头路（重复情况，223,232）
     */
    class Solution2 {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            recurse(candidates, 0, target, new ArrayList<>(), ans);
            return ans;
        }

        //递归，
        public void recurse(int[] can, int i, int t, List<Integer> list, List<List<Integer>> ans) {
            if (i == can.length || t < 0) {
                return;
            }
            if (can[i] > t) {
                return;
            }

            if (can[i] == t) {
                list.add(t);
                ans.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            } else {
                list.add(can[i]);
                recurse(can, i, t - can[i], list, ans);
                list.remove(list.size() - 1);
                recurse(can, i + 1, t, list, ans);
            }

        }

    }

    /**
     * 递归+记忆化搜索，直接使用数组作为记忆化搜索工具时，没办法进行list的去重，因为这里如果是相同的组合则不需要。2+2、3 和3+2、2是重复的
     * 使用set进行去重。耗时会比较久。
     */
    class Solution1 {
        Set<List<Integer>>[] ts;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            ts = new Set[target + 1];
            for (int i = 0; i < ts.length; i++) {
                ts[i] = new HashSet<>();
            }
            ts[0].add(new ArrayList<>());
            //target-i  得到的是更小规格的求解，
            ArrayList<List<Integer>> objects = new ArrayList<>();

            Set<List<Integer>> recurse = recurse(candidates, target);
            objects.addAll(recurse);
            return objects;
        }


        //t是要找到的目标，在can中找到所有的组合，返回给上一级，上一级把自己+result组合出来，更新，并返回
        public Set<List<Integer>> recurse(int[] can, int t) {
            if (ts[t].size() > 0) {
                return ts[t];
            }
            Set<List<Integer>> ans = new HashSet<>();
            for (int i = 0; i < can.length; i++) {
                if (can[i] > t) {
                    break;
                } else {
                    Set<List<Integer>> recurse = recurse(can, t - can[i]);
                    for (List<Integer> integers : recurse) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.addAll(integers);

                        list.add(can[i]);
                        list.sort(Integer::compareTo);
                        ans.add(list);
                    }
                }
            }

            if (ans.size() > 0) {
                ts[t].addAll(ans);
            }
            return ts[t];
        }
    }
}
