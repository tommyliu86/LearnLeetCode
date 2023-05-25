package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/5/25 9:02
 */
public class OddString {
    /**
     * 按位比较，遍历比较每一个位置的大小是否相等
     */
    class Solution {
        public String oddString(String[] words) {
            for (int i = 0; i < words[0].length()-1; i++) {
                int a=words[0].charAt(i+1)-words[0].charAt(i);
                int counta=1,diff=0;
                for (int j = 1; j < words.length; j++) {
                    if (a== words[j].charAt(i + 1) - words[j].charAt(i)) {
                        counta++;
                    }else {
                        if (diff!=0){
                            return words[0];
                        }
                        diff=j;
                    }
                    if (counta>1&&diff!=0){
                        return words[diff];
                    }
                }
            }
            return null;
        }
    }
}
