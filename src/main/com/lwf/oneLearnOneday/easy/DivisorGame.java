package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/2/25 10:20
 */
public class DivisorGame {
    /**
     * 找规律，通过递推计算所有的后续可能值来进行计算是否可以获胜，这里假如 i时会失败那么只要能到达i就肯定可以获胜，因此从i向后计算
     * 能到达i的数值，向后不断推进计算
     */
    class Solution {
        public boolean divisorGame(int n) {
            boolean[] marks=new boolean[n+1];
            for (int i = 1; i < marks.length; i++) {
                if (marks[i]==false){
                    for (int j = 1;i+j<=n&& j <= i; j++) {
                        if ((i%j)==0) {
                            marks[i+j]=true;
                        }
                    }
                }
            }
            return marks[n];
        }
    }
}
