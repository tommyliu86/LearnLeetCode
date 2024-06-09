package com.lwf.week;

import java.util.*;

public class Week401 {
    public static void main(String[] args) {

    }

    /**
     * 额。深度优先遍历可以？？
     */
    class Solution {

            int[] nums;
            int ans = 0;
            boolean done = false;
            public int maxTotalReward(int[] rewardValues) {
                Arrays.sort(rewardValues);
                List<Integer> list = new ArrayList<>();
                int now = 0;
                int n = rewardValues.length;
                for(int i=0;i<n;i++){
                    if(rewardValues[i] > now){
                        list.add(rewardValues[i]);
                        now = rewardValues[i];
                    }
                }
                nums = new int[list.size()];
                for(int i=0;i<list.size();i++){
                    nums[i] = list.get(i);
                }
                int max = nums[nums.length-1];
                dfs(0,max,0);
                return ans;
            }

            void dfs(int startIndex, int max, int sum){
                if(done) return;
                if(sum == max-1){
                    ans = max + sum;
                    done = true;
                    return;
                }
                if(sum >= max){
                    ans = Math.max(ans,sum);
                    return;
                }
                for(int i=startIndex;i< nums.length;i++){
                    if(sum >= nums[i]) continue;
                    dfs(i+1,max,sum+nums[i]);
                }
            }

    }


    /**
     * 前缀和 不行，
     * 背包问题，选和不选， 当前i，可以选择和不可以选择，
     * 可以选择也有选和不选，
     * 不可以选择，则当前的不可以选择的最大
     */
    class Solution3 {
        public int maxTotalReward(int[] rewardValues) {
            Arrays.sort(rewardValues);
            int max = Arrays.stream(rewardValues).max().getAsInt();
            List<Integer> exists=new ArrayList<>();
            SortedSet<Integer> sum=new TreeSet<>();
            sum.add(0);
            for (int i = 0; i < rewardValues.length; i++) {
                if (exists.contains( rewardValues[i])){
                    continue;
                }
                List<Integer> list=new ArrayList<>();
                int cur = rewardValues[i];

                for (Integer j   : sum) {
                    if (j>=cur||(i!=rewardValues.length-1&&j+cur>=max) ){
                        break;
                    }
                    list.add(j+cur);
                }
                sum.addAll(list);
            }

            return  sum.last();
        }
    }
    class Solution2 {
        int mod = (int) 1e9 + 7;
        public int valueAfterKSeconds(int n, int k) {
          int[] ints=new int[n];
            Arrays.fill(ints,1);
            for (int i = 0; i < k; i++) {
                int sum=0;
                for (int j = 0; j < ints.length; j++) {
                    ints[j]=( ints[j]+ sum)%mod;
                    sum=ints[j];
                }
            }
            return ints[n-1];
        }
    }
    class Solution1 {
        public int numberOfChild(int n, int k) {
            if (k<n){
                return k;
            }else{
                int cur=0,c=1;
                for (int i = 0; i <= k; i++) {
                    if (cur==n-1){
                        c=-1;
                    }else if (cur==0){
                        c=1;
                    }
                    cur+=c;
                }
                return cur;
            }
        }
    }
}
