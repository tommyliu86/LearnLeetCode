package com.lwf.classic.two;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/6/30 8:43
 */
public class KSmallestPairs {
    class Solution {
        /**
         * 双指针+优先队列，使用一个队列保存每个选中位置的下一个可能位置去做对比，同时需要一个记录 1和2的index组合是否用过了
         * @param nums1
         * @param nums2
         * @param k
         * @return
         */
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            int[] steps=new int[]{0,1,0};
             int n1 = nums1.length;
            int n2 = nums2.length;
            int[][] dp=new int[n1][n2];
            PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparing(a->nums1[a[0]]+nums2[a[1]]));
            queue.offer(new int[]{0,0});
            dp[0][0]=1;
            List<List<Integer>> ans=new ArrayList<>();

            while (!queue.isEmpty()&& ans.size()<Math.min(k,n1*n2)) {
                int[] poll = queue.poll();

                ans.add(List.of(nums1[ poll[0]],nums2[ poll[1]]));

                for (int i = 0; i < steps.length-1; i++) {
                    int i1=poll[0]+steps[i];
                    int j1=poll[1]+steps[i+1];
                    if (i1<n1&&j1<n2&& dp[i1][j1]==0){
                        queue.offer(new int[]{i1,j1});
                        dp[ i1][i1]=1;
                    }
                }

            }
            return ans;
        }
    }

    /**
     * 利用优先队列
     */
    class Solution1 {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(a -> -a.get(0) - a.get(1)));
            for (int i = 0; i < k && i < nums1.length; i++) {
                for (int j = 0; j < k && j < nums2.length; j++) {
                    if (queue.size() < k) {
                        queue.offer(List.of(nums1[i], nums2[j]));
                    } else {
                        if (nums1[i] + nums2[j] < queue.peek().get(0) + queue.peek().get(1)) {
                            queue.offer(List.of(nums1[i], nums2[j]));
                        }
                        while (queue.size() > k) {
                            queue.poll();
                        }
                    }
                }
            }


            List<List<Integer>> ans = new ArrayList<>();
            while (!queue.isEmpty())
                ans.add(queue.poll());
            Collections.reverse(ans);
            return ans;
        }
    }
}
