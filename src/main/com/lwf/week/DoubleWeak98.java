package com.lwf.week;

import java.util.*;

public class DoubleWeak98 {
    class Solution41{
        /**
         * 线段树。
         */
        class Solution {

            public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
                long sum = 0;
                for (int num : nums2) {
                    sum += num;
                }
                LazySegTree tree = new LazySegTree(nums1);
                ArrayList<Long> list = new ArrayList<>();
                for (int[] query : queries) {
                    if (query[0] == 1) {
                        tree.updateLazySegTree(0, 0, nums1.length - 1, query[1], query[2]);
                    } else if (query[0] == 2) {
                        sum += query[1] * tree.queryLazySegTree(0, 0, nums1.length - 1, 0, nums1.length - 1);
                    } else {
                        list.add(sum);
                    }
                }
                return list.stream().mapToLong(v -> v).toArray();
            }

            class LazySegTree {
                private int[] tree, lazy;

                private LazySegTree(int[] arr) {
                    tree = new int[4 * arr.length];
                    lazy = new int[4 * arr.length];
                    buildSegTree(arr, 0, 0, arr.length - 1);
                }

                private void buildSegTree(int[] arr, int treeIndex, int lo, int hi) {
                    if (lo == hi) {
                        tree[treeIndex] = arr[lo];
                        return;
                    }
                    int mid = lo + (hi - lo) / 2;
                    buildSegTree(arr, 2 * treeIndex + 1, lo, mid);
                    buildSegTree(arr, 2 * treeIndex + 2, mid + 1, hi);
                    tree[treeIndex] = tree[2 * treeIndex + 1] + tree[2 * treeIndex + 2];
                }

                private void updateLazySegTree(int treeIndex, int lo, int hi, int i, int j) {
                    if (lazy[treeIndex] != 0) {
                        tree[treeIndex] = (hi - lo + 1) - tree[treeIndex];
                        if (lo != hi) {
                            lazy[2 * treeIndex + 1] ^= 1;
                            lazy[2 * treeIndex + 2] ^= 1;
                        }
                        lazy[treeIndex] = 0;
                    }
                    if (lo > hi || lo > j || hi < i) {
                        return;
                    }
                    if (i <= lo && hi <= j) {
                        tree[treeIndex] = (hi - lo + 1) - tree[treeIndex];
                        if (lo != hi) {
                            lazy[2 * treeIndex + 1] ^= 1;
                            lazy[2 * treeIndex + 2] ^= 1;
                        }
                        return;
                    }
                    int mid = lo + (hi - lo) / 2;
                    updateLazySegTree(2 * treeIndex + 1, lo, mid, i, j);
                    updateLazySegTree(2 * treeIndex + 2, mid + 1, hi, i, j);
                    tree[treeIndex] = tree[2 * treeIndex + 1] + tree[2 * treeIndex + 2];
                }

                private long queryLazySegTree(int treeIndex, int lo, int hi, int i, int j) {
                    if (lo > j || hi < i) {
                        return 0;
                    }
                    if (lazy[treeIndex] != 0) {
                        tree[treeIndex] = (hi - lo + 1) - tree[treeIndex];
                        if (lo != hi) {
                            lazy[2 * treeIndex + 1] ^= 1;
                            lazy[2 * treeIndex + 2] ^= 1;
                        }
                        lazy[treeIndex] = 0;
                    }
                    if (i <= lo && j >= hi) {
                        return tree[treeIndex];
                    }
                    int mid = lo + (hi - lo) / 2;
                    if (i > mid) {
                        return queryLazySegTree(2 * treeIndex + 2, mid + 1, hi, i, j);
                    } else if (j <= mid) {
                        return queryLazySegTree(2 * treeIndex + 1, lo, mid, i, j);
                    }
                    long leftQuery = queryLazySegTree(2 * treeIndex + 1, lo, mid, i, mid);
                    long rightQuery = queryLazySegTree(2 * treeIndex + 2, mid + 1, hi, mid + 1, j);
                    return leftQuery + rightQuery;
                }
            }
        }
    }
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
