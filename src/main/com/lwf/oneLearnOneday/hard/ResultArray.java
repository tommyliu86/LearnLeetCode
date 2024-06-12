package com.lwf.oneLearnOneday.hard;

import java.util.*;

/**
 * 3072. 将元素分配到两个数组中 II
 *
 * @author: liuwenfei
 * @date: 2024/6/5-8:25
 */
public class ResultArray {
    /**
     * 树状数组
     * 树状数组直接记录排序后的数组元素的位置信息，这样可以直接用树状数组来找到元素的个数，
     * 这个用法是：离散型的做法
     */
    class Solution {
        public int[] resultArray(int[] nums) {
           //使用两个树状数组，保存
            int n = nums.length;
            int[] sorted = Arrays.copyOf(nums, n);
            Arrays.sort(sorted);

            Map<Integer,Integer> indez=new HashMap<>();
            for (int i = 0; i < sorted.length; i++) {
                //位置记录从1开始，方便树状数组进行记录
                indez.put(sorted[i],i+1);
            }

            List<Integer> a1=new ArrayList<>();
            a1.add(nums[0]);
            Tree t1=new Tree(n);
            t1.add(indez.get(nums[0]));
            List<Integer> a2=new ArrayList<>();
            a2.add(nums[1]);
            Tree t2=new Tree(n);
            t2.add(indez.get(nums[1]));
            //从第二个元开始
            for (int i = 2; i < n; i++) {
                //看当前a1和a2的great
                Integer cur = indez.get(nums[i]);
                int n1=a1.size()-t1.query(cur);
                int n2=a2.size()-t2.query(cur);
                if (n1>n2||(n1==n2&&a1.size()<=a2.size())){
                    a1.add(nums[i]);
                    t1.add(cur);
                }else{
                    a2.add(nums[i]);
                    t2.add(cur);
                }
            }
            int[] ans=new int[n];
            int x=0;
            for (int i = 0; i < a1.size(); i++) {
                ans[x++]=a1.get(i);
            }
            for (int i = 0; i < a2.size(); i++) {
                ans[x++]=a2.get(i);
            }
            return ans;
        }

        public  class Tree{
            private int[] tree;
            Tree(int n){
                tree=new int[n+1];
            }
            //添加元素，需要从当前位置往树状数组的右侧进行移动++
            public void add(int i){
                while (i<tree.length){
                    tree[i]++;
                    //i^(i-1)可以获取到最低位往后都是1的数据，和-i的补码一样，不同的是补码的高位都是1，而这个的高位都是0
                    i+=i&(i^(i-1));
                }
            }
            //找小于等于i的元素个数
            public int query(int i){
                int sum=0;
                while (i>0){
                    sum+=tree[i];
                    //通过去除最低位的lowbit，实现向左查找的功能
                    i-=i&-i;
                }
                return sum;
            }
        }
    }
}
