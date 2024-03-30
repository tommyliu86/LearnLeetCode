package com.lwf.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * from home
 * author: liuwu
 * time: 2024/3/16 22:15
 */
public class DoubleWeek126 {
    public static void main(String[] args) {
        System.out.println(big(3015));
    }
    public static int big(int m){
        int i=0;
        int count=0;
        while (m>0){
            i=Math.max(i, m%10);
            count=count*10+1;
            m/=10;
        }
        return i*count;
    }
    class Solution {
        private static final int MOD = 1000000007;
        public int sumOfPower(int[] nums, int k) {
            Arrays.sort(nums);
            //找到所有==k的子序列即可。其他的就是找个数。。
            for (int i = 0; i < nums.length; i++) {

            }
            return 0;

        }
    }
    class Solution3 {
        /**
         * DP 问号替换成谁
         * @param s
         * @return
         */
        public String minimizeStringValue(String s) {
            int countss=0;
            //总数，不变
            int[] count=new int[26];
            //前缀，同时如果每个位置设置位字母
            int[] pre=new int[26];
            //保存添加了多少个字母，
            int[] adds=new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c!='?'){
                    count[c-'a']++;
                }else{
                    countss++;
                }
            }
            List<Character> list=new ArrayList<>();

            for (int i = 0; i <s.length(); i++) {
                char c = s.charAt(i);
                if (c!='?'){
                    pre[c-'a']++;

                }else{
                    int min=Integer.MAX_VALUE;
                    int cur=0;
                    for (int j = 25; j >= 0; j--) {
                        if (min>= count[j]+adds[j]) {
                            cur=j;
                            min=count[j]+adds[j];
                        }
                    }
                    adds[cur]++;
                    list.add((char)(cur+'a'));
                }
            }
            list.sort(Character::compareTo);
            int kk=0;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)!='?'){
                    stringBuilder.append(s.charAt(i));
                }else{
                    stringBuilder.append(list.get(kk++));
                }
            }
            return stringBuilder.toString();
        }

    }
    class Solution3 {
        /**
         * 贪心，
         * 贪心不行，如果用dp，则空间是否够？
         *
         * 26个字母，如果我现在放的是a，=0，但是后面有n个a，则我的值ma=current+n
         * @param s
         * @return
         */
        public String minimizeStringValue(String s) {
            //总数，不变
            int[] count=new int[26];
            //前缀，同时如果每个位置设置位字母
            int[] pre=new int[26];
            //保存添加了多少个字母，
            int[] adds=new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c!='?'){
                    count[c-'a']++;
                }
            }

            char[] chars = s.toCharArray();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c!='?'){
                    pre[c-'a']++;
                }else{
                    int min=Integer.MAX_VALUE;

                    for (int j = 25; j >= 0; j--) {
                        int ccc = ccc(count, adds, pre, chars, i);
                        if (min>= ccc) {
                            min=ccc;
                        }
                    }
                }
            }
            return String.valueOf(chars);
        }
        public int ccc(int[] count,int[] adds,int[] pres,char[] chars,int i){
              int sum=0;

        }

    }

    class Solution2 {
        public long[] unmarkedSumArray(int[] nums, int[][] queries) {
            boolean[] mark=new boolean[nums.length];
            long[] ans=new long[queries.length];

            PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->{
                if (a[0]==b[0]){
                    return Integer.compare( a[1],b[1]);
                }else{
                    return Integer.compare(a[0],b[0]);
                }

            });
            long sum=0;
            for (int i = 0; i < nums.length; i++) {
                sum+=nums[i];
                queue.add(new int[]{nums[i],i});
            }
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                if (!mark[query[0]]){
                    sum-=nums[query[0]];
                    mark[query[0]]=true;
                }
                int k = query[1];
                while (!queue.isEmpty()&& k>0){
                    int[] poll = queue.poll();
                    if (!mark[ poll[1]]) {

                        mark[poll[1]] = true;
                        sum -= poll[0];
                        k--;
                    }
                }
                ans[i]=sum;
            }
            return ans;

        }
    }


    /**
     * 1
     */
    class Solution1 {
        public int sumOfEncryptedInt(int[] nums) {
            int ans=0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                ans+=big(num);
            }
            return ans;
        }


        public int big(int m){
            int i=0;
            int count=0;
            while (m>0){
                i=Math.max(i, m%10);
                count=count*10+1;
                m/=10;
            }
            return i*count;
        }
    }
}
