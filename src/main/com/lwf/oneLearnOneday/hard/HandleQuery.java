package com.lwf.oneLearnOneday.hard;

import com.lwf.data.SegmentTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/2/20 17:37
 */
public class HandleQuery {
    /**
     * 线段树处理nums1进行区间更新
     */
    class Solution {
        public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
            List<Long> ans=new ArrayList<>();
            long sums1=0,sums2=0;
            for (int i = 0; i < nums2.length; i++) {
                sums1+=nums1[i];
                sums2+=nums2[i];
            }
            SegmentTree segmentTree = new SegmentTree(nums1);
            long[] longs = new long[ans.size()];
            for (int i = 0; i < longs.length; i++) {
                longs[i] = ans.get(i);
            }
            return longs;
        }
        public class SegmentTree {
            //数组存储
            int[] segment;
            //原数组长度
            int n;
            public SegmentTree(int[] nums){
                this.n=nums.length;
                //线段数标准计算，最大的扩展后节点数量 不会大于4*n
                segment=new int[4*n];
                build(0,nums,0,n-1);
            }

            /**
             * 递归构建线段数的数组结构
             * @param segIndex
             * @param nums
             * @param left
             * @param right
             */
            private void build(int segIndex,int[] nums,int left,int right){
                if (left==right){//叶子节点,叶子节点表示的区间是本身，因此构建时，递归找到叶子节点，进行赋值，然后通过节点=左+右来构建上层节点
                    segment[segIndex]=nums[left];
                    return;
                }
                //通过中点划分左右子树
                int mid=(left+right)/2;
                build(segIndex*2+1,nums,left,mid);
                build(segIndex*2+2,nums,mid+1,right);
                //通过左右子树的值来设置当前节点
                segment[segIndex]=segment[segIndex*2+1]+segment[segIndex*2+2];
            }

            public void update(int index,int val){
                update(index,val,0,0,n-1);
            }

            /**
             * 递归更新，使用要更新的index与 每个segment中节点表示的L和R的区间进行比较，看index的叶子节点落在哪个子树中，然后进入更新即可
             * @param index
             * @param val
             * @param segIndex
             * @param segL
             * @param segR
             */
            private void update(int index,int val,int segIndex,int segL,int segR){
                if (segL==segR){ //递归更新，L==R表示找到当前index的节点了
                    segment[segL]=val;
                    return;
                }
                int segM=(segL+segR)/2;
                if (index>segM){
                    update(index,val,segIndex*2+2,segM+1,segR);
                }else{
                    update(index,val,segIndex*2+1,segL, segM);
                }
                segment[segIndex]=segment[segIndex*2+1]+segment[segIndex*2+2];
            }
            public int query(int left,int right){
                return query(0,0,n-1,left,right);
            }
            private int query(int segIndex,int segL,int segR,int left,int right){
                if (segL==left&&segR==right){ //segment的区间正好重合，则直接返回
                    return segment[segIndex];
                }
                int segM=(segL+segR)/2;
                if (right<=segM){ //区间在左侧，则找左子树
                    return query(segIndex*2+1,segL,segM,left,right);
                }else if (left>segM){ //区间在右侧，则找右子树
                    return query(segIndex*2+2,segM+1,segR,left,right);
                }else{ //跨区间，则拆分为左和右，中间的m直接使用segment的中间值segM即可。
                    return query(segIndex*2+1,segL,segM,left,segM)+query(segIndex*2+2,segM+1,segR,segM+1,right);
                }
            }
        }
    }
    /**
     * 暴力解法
     */
    class Solution1 {
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

                    sum2 += sum1 * query[1];

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
}
