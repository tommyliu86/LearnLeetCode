package com.lwf.oneLearnOneday.normal;

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
    class Solution1 {
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
