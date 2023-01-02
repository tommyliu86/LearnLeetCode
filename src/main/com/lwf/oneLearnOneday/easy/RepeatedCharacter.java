package com.lwf.oneLearnOneday.easy;

import java.net.ServerSocket;

public class RepeatedCharacter {
    class Solution {
        public char repeatedCharacter(String s) {
            int[] letters=new int[26];

            for (int i = 0; i < s.length(); i++) {

                if (++letters[s.charAt(i)-'a']==2){
                    return s.charAt(i);
                }
            }
            return 'a';
        }
    }
}
