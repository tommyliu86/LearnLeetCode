package com.lwf.oneLearnOneday.normal;

/**
 * 299. 猜数字游戏
 *
 * @author: liuwenfei
 * @date: 2024/3/11-18:47
 */
public class GetHint {
    class Solution {
        public String getHint(String secret, String guess) {

            int a=0;
            //记录a和b中分别有多少个数字，然后再进行数组遍历，取两个数组中的最小值就是重复但位置不同的
            int[] countA = new int[10];
            int[] countB = new int[10];
            for (int i = 0; i < guess.toCharArray().length; i++) {
                if (guess.charAt(i) == secret.charAt(i)) {
                    a++;
                }else {
                    countA[secret.charAt(i)-'0']++;
                    countB[guess.charAt(i)-'0']++;
                }

            }
            int b=0;
            for (int i = 0; i < countA.length; i++) {
                b+=Math.min(countA[i],countB[i]);
            }

            return "" + a + "A" + b + "B";
        }
    }
}
