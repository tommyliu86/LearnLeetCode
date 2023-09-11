package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * https://leetcode-cn.com/problems/course-schedule/
 * 207. 课程表
 * @author: liuwenfei14
 * @date: 2022-02-14 23:21
 */
public class CanFinish {

    /**
     * 拓扑排序的思路，建立依赖树，然后从树的入口开始遍历。
     */
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] inputs=new int[numCourses];
            List<Integer>[] posts=new List[numCourses];

            for (int[] prerequisite : prerequisites) {
                inputs[ prerequisite[0]]++;
                if (posts[prerequisite[1]]==null) {
                    posts[prerequisite[1]]=new ArrayList<>();
                }
                posts[prerequisite[1]].add(prerequisite[0]);
            }
            Queue<Integer> queue=new LinkedList<>();
            for (int i = 0; i < inputs.length; i++) {
                if (inputs[i]==0) queue.offer(i);
            }
            int i=queue.size();
            while (!queue.isEmpty()){
                Integer poll = queue.poll();
                List<Integer> post = posts[poll];
                if (post!=null&&post.size()>0){
                    for (Integer p : post) {
                        inputs[p]--;
                        if (inputs[p]==0) {
                            queue.offer(p);
                            i++;
                        }
                    }
                    posts[poll]=null;
                }
            }
            return i==numCourses;
        }
    }
}
