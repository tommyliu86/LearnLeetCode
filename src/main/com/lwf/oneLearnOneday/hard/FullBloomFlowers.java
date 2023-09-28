package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/9/28 8:36
 */
public class FullBloomFlowers {
    /**
     * 前缀和做法，统计 花的两个时间点，然后对于每个people来看的时间点，使用 total
     */
    class Solution {
        public int[] fullBloomFlowers(int[][] flowers, int[] people) {
            int[] starts=new int[flowers.length];
            int[] ends=new int[flowers.length];
            for (int i = 0; i < flowers.length; i++) {
                starts[i]=flowers[i][0];
                ends[i]=flowers[i][1]+1;
            }
            Arrays.sort(starts);
            Arrays.sort(ends);

            int[] ans=new int[people.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i]=halfF(starts,people[i])-halfF(ends,people[i]);
            }
            return ans;

        }
        private int halfF(int[] ints,int p){
            int i=0,j=ints.length-1;
            if (p<ints[i]) return 0;
            if (p>ints[j])return ints.length;
            while (i<j){
                int m=i+(j-i)/2;
                if (ints[m]>p){
                    j=m;
                }else{
                    i=m+1;
                }
            }
            return ints[i]<=p?i+1:i;
        }
    }

    /**
     * 暴力 会内存溢出
     */
    class Solution1 {
        public int[] fullBloomFlowers(int[][] flowers, int[] people) {
            int[] indez = new int[1000_000_001];
            for (int i = 0; i < flowers.length; i++) {
                indez[flowers[i][0]]++;
                indez[flowers[i][1] + 1]--;
            }
            List<Integer> sum = new ArrayList<>();
            List<Integer> index = new ArrayList<>();
            int preSum = 0;
            for (int i = 0; i < indez.length; i++) {
                if (indez[i] != 0) {
                    preSum += indez[i];
                    sum.add(preSum);
                    index.add(i);
                }
            }
            int[] ans = new int[people.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = halfFind(people[i], sum, index);
            }
            return ans;
        }

        private int halfFind(int p, List<Integer> sum, List<Integer> index) {
            Integer min = index.get(0);
            Integer max = index.get(index.size() - 1);
            if (p < min || p > max) return 0;

            while (min < max) {
                int mid = min + (max - min) / 2;
                if (mid >= p) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            return sum.get(max);

        }
    }
}
