package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-02 14:41
 */
public class NumDecodings {
    class Solution {
        public int numDecodings(String s) {
            char[] chars = s.toCharArray();
            if (chars[0] == '0') {
                return 0;
            }
            int pre = 0;
            int cur = 1;
            for (int i = 1; i < chars.length; i++) {
                char aChar = chars[i];
                int newcur = 0;
                if (aChar != '0') {
                    newcur += cur;
                }

                char aChar1 = chars[i - 1];
                int x = (aChar1 - '0') * 10 + (aChar - '0');
                if (x >= 10 && x <= 26) {
                    newcur += (pre == 0 ? 1 : pre);
                }
                if (newcur==0){
                    return 0;
                }
                pre=cur;
                cur=newcur;

            }
            return cur;
        }
    }
}
