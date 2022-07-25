package com.lwf.game.easy;

public class BestHand {
    class Solution {
        public String bestHand(int[] ranks, char[] suits) {
            char suit = suits[0];

            boolean flush=true;
            for (int i = 1;flush&& i < suits.length; i++) {
                if (suit!=suits[i]){
                    flush=false;
                }
            }
            if (flush){
                return "Flush";
            }
            int[] indexs=new int[14];
            int max=0;
            for (int i = 0; i < ranks.length; i++) {
               indexs[ ranks[i]]++;
               max=Math.max(max,indexs[ranks[i]]);
            }
            if (max>=3){
                return "Three of a Kind";
            }else if (max==2){
                return "Pair";
            }else{
                return "High Card";
            }
        }
    }
}
