package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * 2661. 找出叠涂元素
 * @author liuwenfei
 * @date 2023/12/1 8:54
 */
public class FirstCompleteIndex {
    /**
     * 哈希 +遍历即可
     */
    class Solution {
        public int firstCompleteIndex(int[] arr, int[][] mat) {
            int[] rows = new int[mat.length];
            int[] columns = new int[mat[0].length];
            Arrays.fill(rows, mat[0].length);
            Arrays.fill(columns, mat.length);

            int[][] maps=new int[arr.length+1][2];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    maps[mat[i][j]][0]=i;
                    maps[mat[i][j]][1]=j;
                }
            }

            for (int i = 0; i < arr.length; i++) {
                int cur = arr[i];
                int[] map = maps[cur];
                rows[ map[0]]--;
                columns[ map[1]]--;
                if (rows[ map[0]]==0||columns[ map[1]]==0){
                    return i;
                }
            }
            return arr.length;

        }
    }
}
