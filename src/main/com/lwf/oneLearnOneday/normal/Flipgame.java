package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/8/2 8:47
 */
public class Flipgame {
    /**
     * 常规思路，使用hash存储所有的正面值对应的index数组，然后遍历front，
     * 1.如果front==back则该卡无效
     * 2.否则对比 front 和back：找到相同的index数组，看index数组是否能翻转变化，从而找到是否有效
     * 3.找到的值记录min即可
     *
     * 脑筋急转弯：前后相同的牌，肯定无效，那前后不同的牌是什么情况呢？前后不同的牌，可以知道，前后不同的牌的front和back
     * 只要不和前后相同的牌一样，则肯定可以是有效牌，因此可以两次遍历，直接对比即可。
     */
    class Solution {
        public int flipgame(int[] fronts, int[] backs) {
            Set<Integer> set=new HashSet<>();
            for (int i = 0; i < fronts.length; i++) {
                if (fronts[i]==backs[i])set.add(fronts[i]);
            }
            int min=2001;
            for (int i = 0; i < fronts.length; i++) {
                if (!set.contains( fronts[i])){
                    min=Math.min(min,fronts[i]);
                }
                if (!set.contains( backs[i])){
                    min=Math.min(min,backs[i]);
                }
            }
            return min==2001?0:min;
        }
    }

    /**
     * 常规思路，使用hash存储所有的正面值对应的index数组，然后遍历front，
     * 1.如果front==back则该卡无效
     * 2.否则对比 front 和back：找到相同的index数组，看index数组是否能翻转变化，从而找到是否有效
     * 3.找到的值记录min即可
     *
     * 脑筋急转弯：前后相同的牌，肯定无效，那前后不同的牌是什么情况呢？前后不同的牌，可以知道，前后不同的牌的front和back
     * 只要不和前后相同的牌一样，则肯定可以是有效牌，因此可以两次遍历，直接对比即可。
     */
    class Solution1 {
        public int flipgame(int[] fronts, int[] backs) {
            Map<Integer, List<Integer>> v2Index=new HashMap<>();
            for (int i = 0; i < fronts.length; i++) {
                List<Integer> list = v2Index.getOrDefault(fronts[i], new ArrayList<>());
                list.add(i);
                v2Index.put(fronts[i],list);
            }
            int min=2001;
            for (int i = 0; i < fronts.length; i++) {
                if (fronts[i]==backs[i]){
                    continue;
                }
                for (int k = 0; k < 2; k++) {
                    int back = k==0? fronts[i]:backs[i];
                    if (!v2Index.containsKey(back)) {
                        min=Math.min(back,min);
                    }else{
                        List<Integer> list = v2Index.get(back);
                        boolean is=true;
                        for (int j = 0; j < list.size(); j++) {
                            if (backs[list.get(j)]==back) {
                                is=false;
                                break;
                            }
                        }
                        if (is)min=Math.min(back,min);
                    }
                }
            }
            return min==2001?0:min;
        }
    }
}
