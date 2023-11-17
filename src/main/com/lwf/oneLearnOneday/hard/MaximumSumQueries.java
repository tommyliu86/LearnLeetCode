package com.lwf.oneLearnOneday.hard;

import java.util.*;

/**
 * 2736. 最大和查询
 * @author liuwenfei
 * @date 2023/11/17 9:01
 */
public class MaximumSumQueries {
    public static void main(String[] args) {
        new Solution().maximumSumQueries(new int[]{72,52},new int[]{81,36},new int[][]{{32,94},{4,76}});
    }
    /**
     * 单调栈+ 排序 +二分查找
     * 假设我们找到nums1中的 i符合 nums1[i]>=q[j]，且存在nums2[i]是符合的集合
     */
    static
    class Solution {
        public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
            int n = nums1.length;
            int[][] sums=new int[n][3];
            for (int i = 0; i < sums.length; i++) {
                sums[i][0]=nums1[i];
                sums[i][1]=nums2[i];
                sums[i][2]=nums1[i]+nums2[i];

            }
            int[][] qu=new int[queries.length][3];
            for (int i = 0; i < qu.length; i++) {
                qu[i][0]=queries[i][0];
                qu[i][1]=queries[i][1];
                qu[i][2]=i;
            }
            Arrays.sort(sums, Comparator.comparing(s->s[0]));
            Arrays.sort(qu, Comparator.comparing(s->s[0]));

            //倒序访问qu，每次访问的x的值是有序减少的，这样保证我们可以获取到所有的符合要求的nums1，且可以记录下来，
            //同时，由于我们要的是 i+j的最大值，因此在i是降序访问时，j<=j-pre,则 sum<sum-pre 成立，因此我们可以直接
            //使用sum作为单调递减栈，同时，单调栈中的j时单调递增的，这样，在这个栈中我们就能实现二分查找！
            List<int[]> stack=new LinkedList<>();

            int[] ans=new int[qu.length];
            Arrays.fill(ans,-1);

            int i1=n-1;
            for (int i = qu.length - 1; i >= 0; i--) {
                int x=qu[i][0],y=qu[i][1],index=qu[i][2];
                while (i1>=0&& sums[i1][0]>=x){
                    int[] sum = sums[i1--];

                    while (!stack.isEmpty()&&stack.get(stack.size()-1)[1]<=sum[2]){
                        stack.remove(stack.size()-1);
                    }
                    if (stack.isEmpty()||stack.get(stack.size()-1)[0]<sum[1]){

                        stack.add(new int[]{sum[1],sum[2]});
                    }

                }
                int k = binarySearch(stack, y);
                if (k < stack.size()) {
                    ans[index] = stack.get(k)[1];
                }


            }
            return ans;
        }
        public int binarySearch(List<int[]> list, int target) {
            int low = 0, high = list.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (list.get(mid)[0] >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

    }
}
