package com.lwf.learn.everyday.arith.second.day4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-16 17:16
 */
public class IntervalIntersection {
    /**
     * 双指针，考虑覆盖率的多个情况。
     */
    class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            int fi=0;
            int si=0;
            List<int[]> list=new ArrayList<>();
            while (fi<firstList.length&&si<secondList.length){
                int[] f = firstList[fi];
                int[] s = secondList[si];
                if (f[0]>=s[0]){
                    if (f[1]<=s[1]){
                        list.add(new int[]{f[0],f[1]});
                        fi++;
                    }else if (f[0]<=s[1]){
                        list.add(new int[]{f[0],s[1]});
                        si++;
                    }else{
                        si++;
                    }
                }else{
                    if (s[1]<=f[1]){
                        list.add(new int[]{s[0],s[1]});
                        si++;
                    }else if (s[0]<=f[1]){
                        list.add(new int[]{s[0],f[1]});
                        fi++;
                    }else{
                        fi++;
                    }
                }
            }
            int[][] rtn=new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                rtn[i]=list.get(i);
            }
            return rtn;
        }
    }
}
