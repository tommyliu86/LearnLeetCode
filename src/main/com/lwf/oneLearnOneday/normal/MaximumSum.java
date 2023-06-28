package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;

/**
 * @author liuwenfei
 * @date 2023/6/27 8:54
 */
public class MaximumSum {
    /**
     * 用贪心的思路去解题，重点是确定要删除哪个。因此我们可以遍历每个节点作为删除节点，看删除后留下的最大值
     * 那么我们需要知道删除节点的左边+右边的不删除的最大值。
     */
    class Solution {
        public int maximumSum(int[] arr) {
            if (arr.length==1)return arr[0];
            int[] left=new int[arr.length],right=new int[arr.length];
            left[0]=arr[0];
            for (int i = 1; i < arr.length; i++) {
                //前面为负则不再需要。
                left[i]=Math.max(0,left[i-1])+arr[i];
            }
            right[arr.length-1]=arr[arr.length-1];
            for (int i = arr.length - 2; i >= 0; i--) {
                //前面为负则不再需要。
                right[i]=Math.max(0,right[i+1])+arr[i];
            }
            int ans=Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                int l=i-1<0?0:left[i-1];
                int r=i+1>=arr.length?0:right[i+1];
                //只取当前i，当前i+l+r，当前i删除：l+r 三种情况
                ans=Math.max(arr[i], Math.max( l+r+arr[i],Math.max(ans,l+r)));
            }
            return ans;
        }
    }
}
