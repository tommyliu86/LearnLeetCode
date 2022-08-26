package com.lwf.oneLearnOneday.hard;

public class MovesToChessboard {
    class Solution {
        public int movesToChessboard(int[][] board) {
            int n = board.length;
            //使用位来记录0，1的位置
            int rowMask = 0, colMask = 0;

            /* 检查棋盘的第一行与第一列 */
            for (int i = 0; i < n; i++) {
                rowMask |= (board[0][i] << i);
                colMask |= (board[i][0] << i);
            }
            //获取位记录的反mark，由于 行，列都只能有两种mark才能构成棋盘的充分条件
            int reverseRowMask = ((1 << n) - 1) ^ rowMask;
            int reverseColMask = ((1 << n) - 1) ^ colMask;

            //遍历每一行、每一列的情况并做记录
            int rowCnt = 0, colCnt = 0;
            for (int i = 0; i < n; i++) {
                int currRowMask = 0;
                int currColMask = 0;
                for (int j = 0; j < n; j++) {
                    currRowMask |= (board[i][j] << j);
                    currColMask |= (board[j][i] << j);
                }
                /* 检测每一行的状态是否合法 */
                if (currRowMask != rowMask && currRowMask != reverseRowMask) {
                    return -1;
                } else if (currRowMask == rowMask) {
                    /* 记录与第一行相同的行数 */
                    rowCnt++;
                }
                /* 检测每一列的状态是否合法 */
                if (currColMask != colMask && currColMask != reverseColMask) {
                    return -1;
                } else if (currColMask == colMask) {
                    /* 记录与第一列相同的列数 */
                    colCnt++;
                }
            }
            int rowMoves = getMoves(rowMask, rowCnt, n);
            int colMoves = getMoves(colMask, colCnt, n);
            return (rowMoves == -1 || colMoves == -1) ? -1 : (rowMoves + colMoves);
        }

        public int getMoves(int mask, int count, int n) {
            int ones = Integer.bitCount(mask);
            if ((n & 1) == 1) {
                /* 如果 n 为奇数，则每一行中 1 与 0 的数目相差为 1，且满足相邻行交替 */
                if (Math.abs(n - 2 * ones) != 1 || Math.abs(n - 2 * count) != 1 ) {
                    return -1;
                }
                if (ones == (n >> 1)) {
                    /* 以 0 为开头的最小交换次数 */
                    return n / 2 - Integer.bitCount(mask & 0xAAAAAAAA);
                } else {
                    return (n + 1) / 2 - Integer.bitCount(mask & 0x55555555);
                }
            } else {
                /* 如果 n 为偶数，则每一行中 1 与 0 的数目相等，且满足相邻行交替 */
                if (ones != (n >> 1) || count != (n >> 1)) {
                    return -1;
                }
                /* 找到行的最小交换次数 */
                int count0 = n / 2 - Integer.bitCount(mask & 0xAAAAAAAA);
                int count1 = n / 2 - Integer.bitCount(mask & 0x55555555);
                return Math.min(count0, count1);
            }
        }
    }

}
