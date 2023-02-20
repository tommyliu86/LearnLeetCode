package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/2/20 9:43
 */
public class BestHand {
    /**
     * hash表计数统计
     */
    class Solution {
        public String bestHand(int[] ranks, char[] suits) {
            int ans = 0;
            int max = 0;
            int maxColor = 0;
            int[] counts = new int[14];
            int[] color = new int[4];
            for (int i = 0; i < ranks.length; i++) {
               color[suits[i]-'a']++;
               maxColor= Math.max(maxColor, color[suits[i]-'a']);
                counts[ranks[i]]++;
                max = Math.max(max, counts[ranks[i]]);
            }
            if (maxColor==5){
                return "Flush";
            }else {
               return  max>=3?"Three of a Kind":(max>=2?"Pair":"High Card");
            }
        }
    }
}
