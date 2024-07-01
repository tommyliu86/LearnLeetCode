package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2732. 找到矩阵中的好子集
 *
 * @author: liuwenfei
 * @date: 2024/6/26-9:17
 */
public class GoodSubsetofBinaryMatrix {

    /**
     * 题目的意思是任意找一个好子集，只要是好的，我们就可以直接返回，因此从一般性考虑，我们找到 1行\2行的，
     * 那么这里就需要证明，如果1行、2行的好子集不存在，那么>2行的肯定不存在才行。
     * 奇数行的选项，等同于偶数行多+1行但是要求不变，因此不需要单独考虑，
     * 那么我们需要考虑偶数行：
     * 考虑4行的情况。这时2行是不满足的，那么可以知道肯定存在一个列上有两个1.同时我们知道，任意的两行不满足要求，
     */
    class Solution {
        public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
            int n = grid[0].length;     // 列数
            int u = (1 << n) - 1;         // 用于生成补集的掩码
            int[] mask2Idx = new int[u + 1];        // 行掩码mask和行索引的映射，重复掩码只存储首个掩码对应的行（n列二进制最多有2^n个数）
            Arrays.fill(mask2Idx, -1);     // 映射初始为-1，表示掩码未出现
            int m = grid.length;
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < m; i++){
                // 生成每一行的掩码
                int mask = 0;
                for(int j = 0; j < n; j++){
                    mask <<= 1;     // 将上一位左移
                    mask |= grid[i][j];     // 将当前位添加到最低位
                }
                if(mask == 0){
                    res.add(i);   // 该行全为0，行数为1的好子集
                    return res;
                }
                //异或操作，找到所有的0位对应的为1的那个行。
                int x = mask ^ u;     // 和mask配对的掩码最大值x，同时x中为1的位是可1可0的
                int y = x;            // 用于生成x的子集
                while(x > 0){
                    //找到对应的补码存在，
                    if(mask2Idx[x] >= 0){
                        res.add(mask2Idx[x]);
                        res.add(i);     // i行之前出现和它配对的掩码，返回这个掩码对应的行索引和i
                        return res;
                    }
                    //移除低位的1，这样去找更少的1的行
                    x = (x - 1) & y;    // 位与y保证为0的位始终为0
                }
                if(mask2Idx[mask] < 0){
                    mask2Idx[mask] = i;   // 未处理过的掩码标记其索引
                }
            }
            return res;  // 没有找到好子集返回空集
        }
    }

}
