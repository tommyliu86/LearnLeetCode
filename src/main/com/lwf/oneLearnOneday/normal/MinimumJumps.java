package com.lwf.oneLearnOneday.normal;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuwenfei
 * @date 2023/8/30 8:54
 */
public class MinimumJumps {
    /**
     * 广度优先遍历，每次保存的都是向前跳的，因此，必须满足条件 i+(a-b)<=x,
     * 最远的边界条件，使用 3*2000.。这个为什么？？
     */
    class Solution {
        public int minimumJumps(int[] forbidden, int a, int b, int x) {
            int step=0;
            Set<Integer> forbids=new HashSet<>();
            for (int i : forbidden) {
                forbids.add(i);
            }
            Queue<int[]> queue=new LinkedList<>();
            queue.offer(new int[]{0,0});
            forbids.add(0);
            while (!queue.isEmpty()){
                step++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    int next = poll[0] + a;

                    if (!forbids.contains(next)){
                        forbids.add(next);
                        if (next==x) return step;
                        //1.<x
                        // 2.>x  1.a-b>0 不需要 2.a-b<0 &&
                        if (next<x){
                            queue.offer(new int[]{next,0});

                        }else{
                            if (next<6000){
                                queue.offer(new int[]{next,0});
                            }
                        }
                    }

                    if (poll[1]==0){
                        next = poll[0] - b;
                        if (!forbids.contains(next)){

                            if (next==x) return step;
                            if (next>0){
                                queue.offer(new int[]{next,1});
                            }
                        }
                    }
                }
            }
            return -1;
        }
    }
}
