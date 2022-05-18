package com.lwf.oneLearnOneday.normal;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * https://leetcode-cn.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
 * 2038. 如果相邻两个颜色均相同则删除当前颜色
 *
 * @author: liuwenfei14
 * @date: 2022-03-22 17:49
 */
public class WinnerOfGame {
    /**
     * while写法和for写法效果一样。。。
     */
    static class test {
        public static void main(String[] args) {

           new test().winnerOfGame("AAAABBBB");
        }

        public boolean winnerOfGame(String colors) {
            if (colors.length() < 3) {
                return false;
            }
            int aC = 0;
            int bC = 0;
            int index=0;
            char[] chars = colors.toCharArray();
            while (index<colors.length()){
                if (chars[index]=='A'){
                    int aCount=1;
                    while (++index<colors.length()&&chars[index]=='A'){
                        aCount++;
                    }
                    aC += aCount > 2 ? (aCount - 2) : 0;
                }else{
                    int bCount = 1;

                    while (++index<colors.length() && chars[index]== 'B') {

                        bCount++;

                    }

                    bC += bCount > 2 ? (bCount - 2) : 0;
                }
            }

            return aC > bC;
        }
    }
    /**
     *一次遍历，连续计数即可。
     * 该题目是要判断连续A和连续B的个数，A先走。则A要赢必须A>B
     *
     */
    static class Solution {
        public static void main(String[] args) {
            Solution solution = new Solution();
            solution.winnerOfGame("AAAABBBB");
        }

        public boolean winnerOfGame(String colors) {
            if (colors.length() < 3) {
                return false;
            }
            int aC = 0;
            int bC = 0;
            char[] chars = colors.toCharArray();

            for (int i = 0; i + 1 < chars.length; ) {
                if (chars[i] == 'A') {
                    int aCount = 1;

                    while (i + 1 < chars.length && chars[++i] == 'A') {

                        aCount++;

                    }
                    aC += aCount > 2 ? (aCount - 2) : 0;
                } else {
                    int bCount = 1;

                    while (i + 1 < chars.length && chars[++i] == 'B') {

                        bCount++;

                    }

                    bC += bCount > 2 ? (bCount - 2) : 0;
                }
            }
            return aC > bC;
        }
    }
}
