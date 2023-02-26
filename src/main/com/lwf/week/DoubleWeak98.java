package com.lwf.week;

import java.util.*;

public class DoubleWeak98 {
    class Solution4 {
        public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
            List<Long> ans = new ArrayList<>();
            long sum1 = 0;
            long sum2 = 0;
            for (int i = 0; i < nums2.length; i++) {
                sum1 += nums1[i];
                sum2 += nums2[i];
            }
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                if (query[0] == 1) {
                    int total = 0;
                    for (int j = query[1]; j <= query[2]; j++) {
                        nums1[j] ^= 1;
                        total += nums1[j];
                    }
                    sum1 = sum1 - (query[2] + 1 - query[1] - total) + total;
                } else if (query[0] == 2) {

                    sum2 += (long) sum1 * query[1];

                } else {
                    ans.add(sum2);
                }
            }
            long[] longs = new long[ans.size()];
            for (int i = 0; i < longs.length; i++) {
                longs[i] = ans.get(i);
            }
            return longs;
        }

    }
    class Solution3 {
        public int minImpossibleOR(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int[] bits=new int[32];
            for (int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                set.add(cur);
                int j=0;
                while (cur!=0){
                    bits[j++]|= cur&1;
                    cur>>>=1;
                }
            }
            int ans=0;
            for (int i = 0; i < bits.length; i++) {
                ans=1<<i;
                if (bits[i]==0) {
                   break;
                }else if (!set.contains(ans)){
                    break;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] ints = {58, 42, 8, 75, 28};
        Arrays.sort(ints);
}
    class Solution2 {

        public int minimizeSum(int[] nums) {
            if (nums.length==3) return 0;
            Arrays.sort(nums);
            int n = nums.length-1;
            int min=Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                min=Math.min(nums[n-2+i]-nums[0+i],min);
            }
            return min;
        }
    }
    class Solution1 {
        public int minMaxDifference(int num) {


            List<Integer> bits=new ArrayList<>();

            while (num!=0){
               bits.add( num%10);
               num/=10;
            }
            Integer maxF = bits.get(bits.size() - 1);
            Integer minF = bits.get(bits.size() - 1);
            for (int size = bits.size()-1; size >= 0; size--) {
                if (bits.get(size)!=9) {
                    maxF=bits.get(size);
                    break;
                }
            }


            int max=0,min=0;
            for (int i = bits.size()-1; i >=0; i++) {
                Integer cur = bits.get(i);
                if (cur==maxF){

                    max=max*10+9;
                }else{
                    max=max*10+cur;
                }
                if (cur==minF){
                    min=min*10+0;
                }else{
                    min=min*10+cur;
                }

            }
            return max-min;
        }
    }
}
