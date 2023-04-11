package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/4/11 9:04
 */
public class IsRobotBounded {
    class Solution {
        //机器人是否会循环，仅且仅跟走完一次之后的位置+朝向有关，一次完整指令表示的是向北时走完的位移，因此，
        //走完之后位置为（x,y），朝向为北，循环的后续为n*（x,y)，
        //朝向为南，则 第二次为 (-x,-y），会回到原点，朝向为东，则第一次、第三次会使得方向正好相反且位移相反，因此4次之后会回到原点。
        public boolean isRobotBounded(String instructions) {

            int[][] stats=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
            int cur=0;
            int[] curP={0,0};
            for (int i = 0; i < instructions.length(); i++) {
                char c = instructions.charAt(i);
                if (c=='G'){
                    curP[0]+=stats[cur][0];
                    curP[1]+=stats[cur][1];
                }else if (c=='L'){
                    cur=(4+cur-1)%4;
                }else{
                    cur=(4+cur+1)%4;
                }
            }

            if (curP[0]==0&&curP[1]==0){
                return true;
            }
            return cur != 0;
        }
    }
}
