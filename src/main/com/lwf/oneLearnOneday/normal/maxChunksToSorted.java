package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2022/10/13 9:01
 */
public class maxChunksToSorted {
    /**
     * 模拟，元素大小 k 和index完全重合时，表示可以作为一个分隔，因此可以从前向后一次遍历，记录 minIndex和curIndex,同时用两个变量记录当前
     * 元素的min和max，当且仅当 min=minIndex  && max=curIndex 时，是一个分隔
     */
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int ans=0;
            int n = arr.length;

            int i=0;
            while (i<arr.length){
                int min=arr[i];
                int max=arr[i];
                int l=i;
                while (i<arr.length-1&&( min!=l||max!=i)){
                    i++;
                    min=Math.min(arr[i],min);
                    max=Math.max(arr[i],max);
                }
                i++;
                ans++;
            }
            return ans;

        }
    }
}

