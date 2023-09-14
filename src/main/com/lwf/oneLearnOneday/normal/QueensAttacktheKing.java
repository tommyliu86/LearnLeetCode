package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/9/14 8:38
 */
public class QueensAttacktheKing {
    /**
     * 标记+模拟
     */
    class Solution {
        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
                int[][] marks=new int[8][8];
            for (int i = 0; i < queens.length; i++) {
                marks[queens[i][0]][queens[i][1]]=1;
            }
            int[] steps=new int[]{0,1,0,-1,-1,1,1,-1,0};
            List<List<Integer>> ans=new ArrayList<>();
            for (int i = 0; i < steps.length-1; i++) {
                int ix = steps[i];
                int iy = steps[i+1];
                for (int j = 1; j < 8; j++) {
                    int nx=king[0]+ix*j;
                    int ny=king[1]+iy*j;
                    if (nx>=0&&nx<8&&ny>=0&&ny<8&&marks[nx][ny]==1){
                        ans.add(List.of(nx,ny));
                        break;
                    }
                }
            }
            return ans;
        }
    }
}
