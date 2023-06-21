package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/6/21 9:29
 */
public class FlipChess {
    /**
     * 广度优先遍历
     */
    class Solution {
        //周围方向的数组
        int[] steps = new int[]{1, 0, -1, 0, 1, 1, -1, -1, 1};

        public int flipChess(String[] chessboard) {
            //ans记录最大翻转区域大小
            int ans = 0;
            for (int i = 0; i < chessboard.length; i++) {
                //遍历棋盘每一行
                for (int j = 0; j < chessboard[i].length(); j++) {
                    //如果当前位置不是空,跳过
                    if (chessboard[i].charAt(j) != '.') {
                        continue;
                    }
                    //如果当前位置周围没有O,跳过
                    if (!check(i, j, chessboard)) {
                        continue;
                    }

                    //points记录要翻转的位置
                    Set<Integer> points = new HashSet<>();
                    //queue用于BFS遍历
                    Queue<Integer> queue = new LinkedList<>();
                    //将当前位置加入queue
                    queue.add(i * 10 + j);
                    while (!queue.isEmpty()) {
                        //遍历queue中的点
                        int size = queue.size();
                        for (int i1 = 0; i1 < size; i1++) {
                            Integer poll = queue.poll();
                            //得到行列号
                            int ni = poll / 10;
                            int nj = poll % 10;
                            for (int l = 0; l < steps.length - 1; l++) {
                                //遍历8个方向
                                int i2 = steps[l] + ni;
                                int j2 = steps[l + 1] + nj;

                                //查找该方向上是否会遇到X，有X则加入到队列和翻转点中
                                List<Integer> ps = new ArrayList<>();
                                while (i2 >= 0 && i2 < chessboard.length && j2 >= 0 && j2 < chessboard[0].length() && chessboard[i2].charAt(j2) == 'O' && !points.contains(i2 * 10 + j2)) {
                                    ps.add(i2 * 10 + j2);
                                    i2 += steps[l];
                                    j2 += steps[l + 1];
                                }
                                if (i2 >= 0 && i2 < chessboard.length && j2 >= 0 && j2 < chessboard[0].length() && chessboard[i2].charAt(j2) != '.') {
                                    points.addAll(ps);
                                    queue.addAll(ps);
                                }
                            }
                        }
                    }

                    //更新最大翻转区域
                    ans = Math.max(points.size(), ans);
                }
            }
            return ans;
        }

        //检查当前位置周围是否有O
        private boolean check(int i, int j, String[] chessboard) {
            for (int k = 0; k < steps.length - 1; k++) {
                int i1 = steps[k] + i;
                int i2 = steps[k + 1] + j;
                if (i1 >= 0 && i1 < chessboard.length && i2 >= 0 && i2 < chessboard[0].length()) {
                    if (chessboard[i1].charAt(i2) == 'O') {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
