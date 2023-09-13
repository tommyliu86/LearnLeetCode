package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2023/9/12 8:48
 */
public class CheckIfPrerequisite {
    /**
     * 拓扑排序 的 思路
     * 使用hash表保存每个节点的后节点。 时间 50ms
     * 我们也可以使用二维数组来表示相互关系，时间 10ms
     */
    class Solution {
        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
            posts = new int[numCourses][numCourses];
            marks = new int[numCourses];

            for (int i = 0; i < prerequisites.length; i++) {
                posts[prerequisites[i][0]][prerequisites[i][1]] = 1;
            }
            for (int i = 0; i < numCourses; i++) {
                dfs(i, posts);
            }
            List<Boolean> ans = new ArrayList<>();
            for (int[] query : queries) {
                ans.add(posts[query[0]][query[1]] == 1);
            }
            return ans;
        }

        int[][] posts;
        int[] marks;

        public void dfs(int p, int[][] posts) {
            if (marks[p] == 1) {
                return;
            }
            for (int i = 0; i < posts[p].length; i++) {
                if (posts[p][i] == 1) {
                    dfs(i, posts);
                    for (int j = 0; j < posts[i].length; j++) {
                        posts[p][j] |= posts[i][j];
                    }
                }
            }
            marks[p] = 1;
        }
    }

    /**
     * 使用hash表保存每个节点的后节点。
     * 我们也可以使用二维数组来表示相互关系
     */
    class Solution1 {
        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
            List<Integer>[] posts = new List[numCourses];
            sets = new Set[numCourses];
            marks = new int[numCourses];
            for (int i = 0; i < posts.length; i++) {
                posts[i] = new ArrayList<>();
                sets[i] = new HashSet<>();
            }
            for (int i = 0; i < prerequisites.length; i++) {
                posts[prerequisites[i][0]].add(prerequisites[i][1]);
            }
            for (int i = 0; i < numCourses; i++) {
                dfs(i, posts);
            }
            List<Boolean> ans = new ArrayList<>();
            for (int[] query : queries) {
                ans.add(sets[query[0]].contains(query[1]));
            }
            return ans;
        }

        Set<Integer>[] sets;
        int[] marks;

        public Set<Integer> dfs(int p, List<Integer>[] posts) {
            if (marks[p] == 1) {
                return sets[p];
            }
            sets[p].addAll(posts[p]);
            for (Integer integer : posts[p]) {
                sets[p].addAll(dfs(integer, posts));
            }
            marks[p] = 1;
            return sets[p];

        }

        public Boolean check(int q, int t, List<Integer>[] posts) {
            for (Integer integer : posts[q]) {
                if (integer == t || check(integer, t, posts)) return true;
            }
            return false;
        }
    }
}
