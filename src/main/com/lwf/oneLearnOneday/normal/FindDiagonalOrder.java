package com.lwf.oneLearnOneday.normal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-14 09:38
 */
public class FindDiagonalOrder {
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int m=mat.length;
            int n = mat[0].length;
            int[] rtn=new int[m*n];
            boolean up=true;
            int x=0;
            int y=0;
            int i=0;
            while (i<rtn.length){
                rtn[i]=mat[x][y];
                if (up) {
                    if (x>0&&y<n-1){

                        x--;
                        y++;
                    }else{
                        up=false;
                        if (y<n-1){
                            y++;
                        }else{
                            x++;
                        }
                    }
                }else{
                    if (y>0&&x<m-1){

                        x++;
                        y--;
                    }else{
                        up=true;
                        if (x<m-1){
                            x++;
                        }else{
                            y++;
                        }
                    }
                }

                i++;
            }
            return rtn;
        }
    }
}
