package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/2/1 13:47
 */
public class DecodeMessage {
    /**
     * hash
     */
    class Solution {
        public String decodeMessage(String key, String message) {
            int[] keys=new int[27];
            int count=0;
            for (int i = 0;count<26&& i < key.length(); i++) {
                if (key.charAt(i)!=' ') {
                    int i1 = key.charAt(i) - 'a' + 1;
                    if (keys[i1] == 0) {
                        keys[i1] = ++count;
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                char c = message.charAt(i);
                if (c==' ') {
                    stringBuilder.append(' ');
                }else{
                    int i1 = c - 'a' + 1;
                    char newC=(char)(keys[i1]-1+'a');

                        stringBuilder.append(newC);

                }
            }
            return stringBuilder.toString();
        }
    }
}
