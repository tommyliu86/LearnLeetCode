package com.lwf.oneLearnOneday.normal;

/**
 * Created with IntelliJ IDEA.
 *https://leetcode-cn.com/problems/where-will-the-ball-fall/
 * 1706. 球会落何处
 * @author: liuwenfei14
 * @date: 2022-02-28 09:27
 */
public class FindBall {
    /**
     * 模拟路径方法，观察小球移动，每次都是先进行左右移动一次，然后再向下移动，因此每次判断小球向左、右移动后，是否还可以向下移动即可知道是否可以走到最后。
     * 终止条件：判断小球左右移动后是否越界以及 左右移动的这两个方格的值是否相等（也就是是否形成了V字底）
     * @param grid
     * @return
     */
    public int[] findBall(int[][] grid) {
        int[] rtn=new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            int x=0;
            int y=i;
            while (x<grid.length){

                int iIndex = grid[x][y];
                if (iIndex==1){ //向右走
                    y++;
                }else{ //向左走
                    y--;
                }
                if (y>=grid[0].length||y<0|| iIndex!=grid[x][y]){    //是否可以向下
                    rtn[i]=-1;
                    break;
                }else{
                    x++;
                }
            }
            if (x==grid.length){
                rtn[i]=y;
            }
        }
        return  rtn;
    }
}
