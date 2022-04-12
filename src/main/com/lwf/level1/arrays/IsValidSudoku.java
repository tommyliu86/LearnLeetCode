package com.lwf.level1.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-09 18:36
 */
public class IsValidSudoku {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            List<int[]>[] mark=new List[9];
            for (int i = 0; i < mark.length; i++) {
                mark[i]=new ArrayList<>();
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    char c = board[i][j];
                    if (c=='.'){
                        continue;
                    }else{
                        List<int[]> points = mark[c - '1'];
                        if (points.isEmpty()){
                            points.add(new int[]{i,j});
                        }else{
                            boolean  isvalid= checkPointsInvalid(points, i, j);
                            if (!isvalid){
                                return false;
                            }else {
                                points.add(new int[]{i,j});
                            }
                        }
                    }
                }
            }
            return true;
        }
        private boolean checkPointsInvalid(List<int[]> points,int x,int y){
            for (int[] point : points) {
                int oX = point[0];
                int oY = point[1];
                if (oX ==x|| oY ==y){
                    return false;
                }
                int bX = oX / 3;
                int bY = oY / 3;
                if (x/3==bX&&y/3==bY){
                    return false;
                }
            }
            return true;
        }
    }
}
