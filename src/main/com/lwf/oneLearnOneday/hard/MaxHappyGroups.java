package com.lwf.oneLearnOneday.hard;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuwenfei
 * @date 2023/1/28 13:55
 */
public class MaxHappyGroups {
    public static void main(String[] args) {

        new Solution().maxHappyGroups(7,new int[]{2,7,5,2,3,2,6,5,3,6,2,3,7,2,2,5,4,6,6,4,7,5,6,1,6,2,6,6,2,5});
    }
static
    class Solution {
        private Map<Long, Integer> f = new HashMap<>();
        private int size;

        public int maxHappyGroups(int batchSize, int[] groups) {
            size = batchSize;
            int ans = 0;
            long state = 0;
            for (int g : groups) {
                int i = g % size;
                if (i == 0) {
                    ++ans;
                } else {
                   //位运算计数，相同长度的5位来记录余数是1到9的顾客组的数量。
                    state += 1l << (i * 5);
                }
            }
            ans += dfs(state, 0);
            return ans;
        }

    /**
     * 状态压缩一般都是跟记忆化搜索一起使用的！
     * @param state
     * @param mod
     * @return
     */
        private int dfs(long state, int mod) {
            if (f.containsKey(state)) {
                return f.get(state);
            }
            int res = 0;
            for (int i = 1; i < size; ++i) {
                if ((state >> (i * 5) & 31) != 0) {
                    int t = dfs(state - (1l << (i * 5)), (mod + i) % size);
                    res = Math.max(res, t + (mod == 0 ? 1 : 0));
                }
            }
            f.put(state, res);
            return res;
        }
    }



    class Solution3 {
        public int maxHappyGroups(int batchSize, int[] groups) {
            int[] nums = new int[batchSize];
            for (int i = 0; i < groups.length; i++) {
                groups[i] %= batchSize;
                nums[groups[i]]++;
            }
            int ans = nums[0];
            nums[0]=0;
            int remain = groups.length - ans;
            //从两个数到batchSize个数，贪心
            for (int i = 2; remain > 0 && i <= batchSize/2; i++) {

                List<List<Integer>> split = split(1, i, batchSize);
                for (List<Integer> list : split) {
                    Map<Integer, List<Integer>> collect = list.stream().collect(Collectors.groupingBy(Integer::intValue));
                    Integer min = list.stream().map(index -> nums[index] / collect.get(index).size()).min(Integer::compareTo).get();
                    if (min > 0) {
                        ans += min;
                        for (Integer index : list) {
                            nums[index] -= min;
                        }
                        remain -= i * min;
                    }
                }
            }
            if (remain==0) {
                return ans;
            }else{
                ans++;
                int sum = 0;
                for (int i = 0; i < nums.length; i++) {
                    sum+=nums[i]*i;
                }


                int[] countMark=new int[sum+1];
                int max = split(nums, 0, countMark);

                ans+=max;


                return ans;
            }
        }

        private List<List<Integer>> split(int start, int i, int n) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            if (i == 1) {
                ArrayList<Integer> sub = new ArrayList<>();
                sub.add(n);
                ans.add(sub);
                return ans;
            }
            for (int j = start; j < n; j++) {

                List<List<Integer>> split = split(j, i - 1, n - j);
                for (List<Integer> list : split) {
                    list.add(j);
                    ans.add(list);
                }
            }
            return ans;
        }
        private int split(int[] nums,int count,int[] ans ) {
            int max=0;
            int sum = Arrays.stream(nums).sum();
            if (sum==0){
                for (int i = 1; i <= (ans.length - 1) / nums.length; i++) {
                    if (ans[nums.length*i]>0&&nums.length*i!=ans.length-1) {
                        max++;
                    }
                }
                return max;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]>0){
                    nums[i]--;
                    ans[count+i]++;
                    int subMax = split(nums, count + i, ans);
                    max=Math.max(subMax,max);
                    ans[count+i]--;
                    nums[i]++;
                }
            }
            return max;
        }
    }

    /**
     * 超时，
     */
    class Solution2 {
        public int maxHappyGroups(int batchSize, int[] groups) {
            int[] nums = new int[batchSize];
            for (int i = 0; i < groups.length; i++) {
                groups[i] %= batchSize;
                nums[groups[i]]++;
            }
            int ans = nums[0];
            nums[0]=0;
            int remain = groups.length - ans;
            //从两个数到batchSize个数，贪心


            List<List<Integer>> split = split(1, 2, batchSize);
            for (List<Integer> list : split) {
                Map<Integer, List<Integer>> collect = list.stream().collect(Collectors.groupingBy(Integer::intValue));
                Integer min = list.stream().map(index -> nums[index] / collect.get(index).size()).min(Integer::compareTo).get();
                if (min > 0) {
                    ans += min;
                    for (Integer index : list) {
                        nums[index] -= min;
                    }
                    remain -= 2 * min;
                }
            }

            if (remain==0) {
                return ans;
            }else{
                ans++;
                int sum = 0;
                for (int i = 0; i < nums.length; i++) {
                    sum+=nums[i]*i;
                }


                int[] countMark=new int[sum+1];
                int max = split(nums, 0, countMark);

                ans+=max;


                return ans;
            }
        }

        private List<List<Integer>> split(int start, int i, int n) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            if (i == 1) {
                ArrayList<Integer> sub = new ArrayList<>();
                sub.add(n);
                ans.add(sub);
                return ans;
            }
            for (int j = start; j < n; j++) {

                List<List<Integer>> split = split(j, i - 1, n - j);
                for (List<Integer> list : split) {
                    list.add(j);
                    ans.add(list);
                }
            }
            return ans;
        }
        private int split(int[] nums,int count,int[] ans ) {
            int max=0;
            int sum = Arrays.stream(nums).sum();
            if (sum==0){
                for (int i = 1; i <= (ans.length - 1) / nums.length; i++) {
                    if (ans[nums.length*i]>0&&nums.length*i!=ans.length-1) {
                        max++;
                    }
                }
                return max;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]>0){
                    nums[i]--;
                    ans[count+i]++;
                    int subMax = split(nums, count + i, ans);
                    max=Math.max(subMax,max);
                    ans[count+i]--;
                    nums[i]++;
                }
            }
            return max;
        }
    }

    class Solution1 {
        public int maxHappyGroups(int batchSize, int[] groups) {
            int[] nums = new int[batchSize];
            for (int i = 0; i < groups.length; i++) {
                groups[i] %= batchSize;
                nums[groups[i]]++;
            }
            int ans = nums[0];
            nums[0]=0;
            int remain = groups.length - ans;
            //从两个数到batchSize个数，贪心
            for (int i = 2; remain > 0 && i <= batchSize; i++) {

                List<List<Integer>> split = split(1, i, batchSize);
                for (List<Integer> list : split) {
                    Map<Integer, List<Integer>> collect = list.stream().collect(Collectors.groupingBy(Integer::intValue));
                    Integer min = list.stream().map(index -> nums[index] / collect.get(index).size()).min(Integer::compareTo).get();
                    if (min > 0) {
                        ans += min;
                        for (Integer index : list) {
                            nums[index] -= min;
                        }
                        remain -= i * min;
                    }
                }
            }
            if (remain==0) {
                return ans;
            }else{
                ans++;
                int sum = 0;
                for (int i = 0; i < nums.length; i++) {
                    sum+=nums[i]*i;
                }


                int[] countMark=new int[sum+1];
                int max = split(nums, 0, countMark);

                ans+=max;


                return ans;
            }
        }

        private List<List<Integer>> split(int start, int i, int n) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            if (i == 1) {
                ArrayList<Integer> sub = new ArrayList<>();
                sub.add(n);
                ans.add(sub);
                return ans;
            }
            for (int j = start; j < n; j++) {

                List<List<Integer>> split = split(j, i - 1, n - j);
                for (List<Integer> list : split) {
                    list.add(j);
                    ans.add(list);
                }
            }
            return ans;
        }
        private int split(int[] nums,int count,int[] ans ) {
            int max=0;
            int sum = Arrays.stream(nums).sum();
            if (sum==0){
                for (int i = 1; i <= (ans.length - 1) / nums.length; i++) {
                    if (ans[nums.length*i]>0&&nums.length*i!=ans.length-1) {
                        max++;
                    }
                }
                return max;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]>0){
                    nums[i]--;
                    ans[count+i]++;
                    int subMax = split(nums, count + i, ans);
                    max=Math.max(subMax,max);
                    ans[count+i]--;
                    nums[i]++;
                }
            }
            return max;
        }
    }
}
