package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * 274. H 指数
 * https://leetcode.cn/problems/h-index/?envType=daily-question&envId=2023-10-31
 * @author liuwenfei
 * @date 2023/10/31 9:50
 */
public class HIndex {
    /**
     * 274. H 指数
     *   https://leetcode.cn/problems/h-index/?envType=daily-question&envId=2023-10-31
     * 排序后 找index 位置和index的值的 对比即可
     */
    class Solution1 {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int n = citations.length;
            for (int i = n - 1; i >= 0; i--) {
                if (citations[i]<n-i){
                    return n-i-1;
                }
            }
            return n;
        }
    }

    /**
     * 275. H 指数 II
     * https://leetcode.cn/problems/h-index-ii/?envType=daily-question&envId=2023-10-31
     * 二分查找，排序后，直接找位置即可， f[i]>=n-i 则 表示成立
     * 二分查找 灵神写法
     * https://leetcode.cn/problems/h-index-ii/solutions/2504326/tu-jie-yi-tu-zhang-wo-er-fen-da-an-si-ch-d15k/?envType=daily-question&envId=2023-10-31
     */
    class Solution2 {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int n = citations.length;
            int i=0,j=n-1;
            while (i<=j){
                int mid=i+(j-i)/2;
                //左边不包含答案 mid+1
                if (citations[mid]<n-mid){
                    i=mid+1;
                }else{ //mid符合要求，此时可以两种写法
                    // 1. j=mid 则j肯定符合要求，这样的写法不能使用i==j，否则会再找到j时，一直循环在j上
                    // 2. j=mid-1 则j可能符合也可能不符合，这样 需要条件时i<=j，因为当找到的i==j时不符合要求，则我们会让i+1，就会找到了
                    j=mid-1;
                }
            }
            return n-i;
        }
    }
}
