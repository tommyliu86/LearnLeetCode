package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/5/5 8:48
 */
public class HardestWorker {
    /**
     * 枚举大法
     */
    class Solution {
        public int hardestWorker(int n, int[][] logs) {

            int max=0;
            int indez=n;
            for (int i = 0; i < logs.length; i++) {
                int cur=logs[i][1]-(i==0?0:logs[i-1][1]);
                if (max<cur){
                    max=cur;
                    indez=logs[i][0];
                }else if (max==cur){
                    indez=Math.min(indez,logs[i][0]);
                }
            }
            return indez;
        }
    }
    /**
     * 排序大法
     */
    class Solution1 {
        public int hardestWorker(int n, int[][] logs) {
            for (int i = logs.length-1; i >0; i--) {
                logs[i][1] -= logs[i - 1][1];
            }
            Arrays.sort(logs, (a, b) -> {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(b[1], a[1]);
                }
            });
            return logs[0][0];
        }
    }
}
