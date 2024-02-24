package com.lwf.oneLearnOneday.normal;

/**
 * 2182. 构造限制重复的字符串
 */
public class RepeatLimitedString {
    class Solution {
        public String repeatLimitedString(String s, int repeatLimit) {
            int[] marks=new int[26];
            //统计所有字符个数
            for (int i = 0; i < s.length(); i++) {
                marks[s.charAt(i)-'a']++;
            }
            //i表示 当前要看的是哪个字符，j表示 间隔用的字符，直到
            int i=25;
            StringBuilder stringBuilder = new StringBuilder();
            while (i>=0){
                while (i>=0&&marks[i]==0){
                    i--;
                }
                if (i<0)
                    break;
                for (int i1 = 0; i1 < Math.min(marks[i], repeatLimit); i1++) {

                    stringBuilder.append((char)('a'+i));
                }
                marks[i]-=Math.min(marks[i],repeatLimit);
                int j=i-1;
                while (j>=0&&marks[j]==0){
                    j--;
                }
                if (j<0)
                    break;
                for (int i1 = 0; i1 < Math.min(marks[j], repeatLimit); i1++) {

                    stringBuilder.append((char)('a'+j));
                }
                marks[j]-=Math.min(marks[j],repeatLimit);

            }
            return stringBuilder.toString();
        }
    }
}
