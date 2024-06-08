package com.lwf.week;

import java.util.*;

public class Week389 {
    class Solution {
        /**
         * 动作1， 往不是站立的地方放一个1，
         * 动作2. 交换1和0的位置，如果恰好1到达脚底，则可以捡起来，
         * 也就是1和2 要配合，来达到获取k个数。
         * 动作1最多能执行的次数是固定的，
         * 使用动作1，则肯定需要动作而来捡起来。2次操作。。
         * 直接用动作2.则站立位置周围可以直接获取到1，则只用1次。
         * @param nums
         * @param k
         * @param maxChanges
         * @return
         */
        public long minimumMoves(int[] nums, int k, int maxChanges) {
            //1.找位置，1最多的位置，
            //2.用maxchange
            //3.找距离最近的1
            int n = nums.length;
            //保存距离最近的2个格子中的1的个数


            int min=Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int have=nums[i];
                int step=0;

                if (have<k&& i-1>=0&&nums[i-1]==1){
                    step++;
                    have++;
                }
                if (have<k&& i+1<nums.length&&nums[i+1]==1){
                    step++;
                    have++;
                }
                int change=0;
                while(have<k&&change<maxChanges){
                   step+=2;
                   change++;
                   have++;
                }
                //还小，这时候，只能是找其他地方的1，来放入这个地方
                if (have<k){
                    int dis=2;
                    while( have<k&&(i+dis<n||i-dis>=0)){
                        if (i+dis<n&&i+dis<n&&nums[i+dis]==1){
                            step+=dis;
                            have++;
                        }
                        if (have<k&&i-dis>=0&&nums[i-dis]==1){
                            step+=dis;
                            have++;
                        }
                        dis++;
                    }
                }
                min=Math.min(min,step);
            }
        return min;
        }
    }

    class Solution31 {
        public int minimumDeletions(String word, int k) {
            //获得所有的字符数量
            int[] counts=new int[26];
            for (int i = 0; i < word.length(); i++) {
                counts[word.charAt(i)-'a']++;
            }
            //1,2,3,4,5,6,7
           //滑动窗口。左侧的不能更小，右侧的可以变小，变小到多少，是
            Map<Integer,Integer> map=new HashMap<>();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < counts.length; i++) {
                if (!map.containsKey(counts[i])){
                    list.add(counts[i]);
                }
                map.put(counts[i],map.getOrDefault(counts[i],0)+1);

            }
            list.sort(Integer::compareTo);
            int ans=Integer.MAX_VALUE;
            int pre=0;
            for (int i = 0; i < list.size(); i++) {
                Integer cur = list.get(i);

                //假设我们让最下的数量是cur，则我们计算当前要删除多少个
                int remove=pre+calc(cur,map,k);

                ans=Math.min(ans,remove);
                pre+=cur* map.get(cur);

            }
            return ans;
        }
        private int calc(Integer cur, Map<Integer, Integer> map, int k) {
            int ans=0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey()>cur+k){
                    ans+=(entry.getKey()-cur-k)*entry.getValue();
                }
            }
            return ans;
        }
    }



    class Solution3 {
        public int minimumDeletions(String word, int k) {
            //获得所有的字符数量
            int[] counts=new int[26];
            for (int i = 0; i < word.length(); i++) {
                counts[word.charAt(i)-'a']++;
            }

            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < counts.length; i++) {
                if (counts[i]>0){
                    list.add(counts[i]);
                }
            }
            //获取所有的字符的数量，

            //排序之后，最大和最小两个如果差大于k，则找到距离 i 和 j的哪个
            // 1,3,6 ,k==0,  53，54，155，小的这个不移除，则肯定会存在，因此，每次让最大的变小，只到最大的和最小的两个的差小于当前k
            //删除，只能变少，因此肯定 是移除，因此两个数比较，如果移除 前一个更划算，则有限移除前一个的全部，这样，后面的数更大
            //26个数，找到所有数都靠近
            int ans=0;
            list.sort(Integer::compareTo);
            while(Math.abs( list.get(0)-list.get(list.size()-1))>k){
                Integer i0 = list.get(0);
                Integer i1 = list.get(list.size() - 1);
                if (i1-i0-k>=i0){
                    ans+=i0;
                    list.remove(0);

                }else{
                    ans+=i1-i0-k;
                    list.set(list.size()-1,i0+k);
                    list.sort(Integer::compareTo);
                }

            }
            return ans;

        }
    }
    class Solution2 {
        public long countSubstrings(String s, char c) {
            int count=0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)==c){
                    count++;
                }
            }
            //遍历并尽心计算
            long ans=0;
            int pre=0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)!=c){
                    continue;
                }
                int cur=count-pre;
                ans+=cur;
                pre++;
            }
            return ans;
        }
    }
    class Solution1 {
        public boolean isSubstringPresent(String s) {
            Set<Integer> set=new HashSet<>();
            for (int i = 0; i < s.length()-1; i++) {
                int i1 = s.charAt(i) - 'a';
                int i2 = s.charAt(i + 1) - 'a';
                set.add(i1*100+i2);
            }
            for (int i = s.length()-1; i > 0; i--) {
                int i1 = s.charAt(i) - 'a';
                int i2 = s.charAt(i - 1) - 'a';
                if (set.contains(i1*100+i2)){
                    return true;
                }
            }
            return false;
        }
    }
}
