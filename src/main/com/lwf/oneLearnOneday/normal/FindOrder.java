package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/9/11 9:49
 */
public class FindOrder {
    /**
     * 拓扑排序，遍历节点，是canFinish 一样的思路
     */
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] inputs=new int[numCourses];
            List<Integer>[] posts=new List[numCourses];
            for (int i = 0; i < posts.length; i++) {
                posts[i]=new ArrayList<>();
            }
            for (int i = 0; i < prerequisites.length; i++) {
                int post = prerequisites[i][0];
                int pre = prerequisites[i][1];

                inputs[post]++;
                posts[pre].add(post);
            }
            int[] ans=new int[numCourses];
            int c=0;
            Queue<Integer> queue=new LinkedList<>();
            for (int i = 0; i < inputs.length; i++) {
                if (inputs[i]==0) {
                    queue.offer(i);
                    ans[c++]=i;
                }
            }

            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                for (Integer p : posts[poll]) {
                    inputs[p]--;
                    if (inputs[p]==0){
                        queue.offer(p);
                        ans[c++]=p;
                    }
                }
                posts[poll]=null;
            }
            if (c==numCourses){
                return ans;
            }else{
                return new int[0];
            }
        }
    }
}
