package com.lwf.oneLearnOneday.easy;

/**
 * 2660. 保龄球游戏的获胜者
 * @author liuwenfei
 * @date 2023/12/27 9:04
 */
public class IsWinner {
    class Solution {
        public int isWinner(int[] player1, int[] player2) {
            int pre11=0,pre12=0,pre21=0,pre22=0;
            int sum1=0,sum2=0;
            for (int i = 0; i < player1.length; i++) {
                sum1+=(pre11==10||pre12==10)?2*player1[i]:player1[i];
                pre11=pre12;pre12=player1[i];
                sum2+=(pre21==10||pre22==10)?2*player2[i]:player2[i];
                pre21=pre22;pre22=player2[i];

            }
            return sum1>sum2?1:sum1==sum2?0:2;
        }
    }
}
