package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.Map;

public class AlphabetBoardPath {
    class Solution {
        public String alphabetBoardPath(String target) {
            Map<Integer,int[]> map = new HashMap<>();
            for (int i = 0; i < 26; i++) {
                map.put(i,new int[]{i/5,i%5});
            }
            StringBuilder stringBuilder = new StringBuilder();

            int pre=0;
            for (int i = 0; i < target.length(); i++) {
                char c = target.charAt(i);
                if (pre==c-'a') {
                    stringBuilder.append("!");
                    continue;
                }
                int[] prei = map.get(pre);
                int[] cur;
                if (c=='z'){
                   cur= map.get(20);
                }else{
                    cur= map.get(c-'a');
                }

                int x = cur[0] - prei[0];
                int y = cur[1] - prei[1];

                while (x!=0){
                    if (x>0){
                        stringBuilder.append("D");
                        x--;
                    }
                    if (x<0){
                        stringBuilder.append("U");
                        x++;
                    }
                }
                while (y!=0){
                    if (y>0){
                        stringBuilder.append("R");
                        y--;
                    }
                    if (y<0){
                        stringBuilder.append("L");
                        y++;
                    }
                }
                if (c=='z'){
                    stringBuilder.append("D");
                }
                stringBuilder.append("!");
                pre=c-'a';
            }
            return stringBuilder.toString();
        }
    }
}
