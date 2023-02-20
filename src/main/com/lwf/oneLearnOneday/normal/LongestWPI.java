package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2022/12/1 9:37
 */
public class LongestWPI {
    public static void main(String[] args) {
        new Solution().longestWPI(new int[]{6,6,9});
    }
    static
    class Solution {
        /**
         * 前缀和+hash
         * 为什么在sum<0时，找sum-1就是最远？因为sum从0开始的，所以，sum<0时，sum-1<0, 因sum-2更小，那sum-2的前一个位置就必然是sum-1！！
         * @param hours
         * @return
         */
        public int longestWPI(int[] hours) {
            Map<Integer,Integer> index=new HashMap<>();
            int sum=0;
            int max=0;

            for (int i = 0; i < hours.length; i++) {
                sum+=hours[i]>8?1:-1;
                if (sum>0){
                    max=i+1;
                }else {
                    Integer pre = index.getOrDefault(sum - 1, Integer.MAX_VALUE);
                    max=Math.max(max,i-pre);
                }
                if (!index.containsKey(sum)) {
                    index.put(sum,i);
                }
            }
            return max;
        }
    }
    class Solution1 {
        /**
         * 单调栈+贪心
         * @param hours
         * @return
         */
        public int longestWPI(int[] hours) {
            int[] sums=new int[hours.length+1];
            Stack<Integer> stack=new Stack<>();
            stack.push(0);
            for (int i = 1; i < sums.length; i++) {
                sums[i]=sums[i-1]+(hours[i-1]-8>0?1:-1);
                if (sums[ stack.peek()]>sums[i]){
                    stack.push(i);
                }
            }

            int max=0;
            for (int i = sums.length - 1; i >= 0&& !stack.isEmpty(); i--) {
                int sum = sums[i];
                while (!stack.isEmpty()&& sum>sums[ stack.peek()]){
                    max=Math.max(max,i-stack.pop());
                }
            }
            return max;
        }
    }

    /**
     * 双指针+前缀和
     */
    class Solution2 {
        public int longestWPI(int[] hours) {
            int[] sums=new int[hours.length+1];
            for (int i = 1; i < sums.length; i++) {
                sums[i]=sums[i-1]+(hours[i-1]-8>0?1:-1);
            }
            int max=0;
            int i=0;
            while (i<sums.length&&sums.length-i>max){
                int j=sums.length-1;
                while (j>i){

                    if (sums[j]-sums[i]>0){
                        max=Math.max(max,j-i);
                     break;
                    }
                    j--;
                }
                i++;
            }
            return max;
        }
    }
}
