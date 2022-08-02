package com.lwf.oneLearnOneday.easy;

import java.util.*;

public class ArrayRankTransform {
    /**
     * 排序哈希
     */
    class Solution {
        public  int[] arrayRankTransform(int[] arr) {
            if (arr.length==0){
                return arr;
            }
            int[] s = Arrays.copyOf(arr, arr.length);
            Arrays.sort(s);
            Map<Integer,Integer> map=new HashMap<>();
            int k=1;
            for (int i = 0; i < s.length; i++) {
                if (map.containsKey(s[i])) {
                    continue;
                }
                map.put(s[i],k++);
            }
            for (int i = 0; i < arr.length; i++) {
              arr[i]=map.get(arr[i]);

            }
            return arr;
        }

    }
    /**
     * 优先队列
     */
    class Solution1 {
        public int[] arrayRankTransform(int[] arr) {
            if (arr.length<1){
                return arr;
            }
            PriorityQueue<int[]> qu=new PriorityQueue<int[]>(Comparator.comparing(ints -> ints[1]));
            for (int i = 0; i < arr.length; i++) {
                int[] node=new int[]{i,arr[i]};
                qu.offer(node);
            }
            int[] pre=qu.poll();
            int k=1;
            arr[pre[0]]=k;
            while (!qu.isEmpty()){
                int[] cur = qu.poll();
                if (cur[1]==pre[1]){
                    arr[cur[0]]=k;
                }else{
                    arr[cur[0]]=++k;

                }
                pre=cur;
            }
            return arr;
        }
    }
}
