package com.lwf.learn.everyday.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-11 15:52
 */
public class NumDecodings {
    class Solution1 {
        public int numDecodings(String s) {
            char[] chars = s.toCharArray();
            if (chars[0] == '0') {
                return 0;
            }
            int pre = 1;
            int cur = 1;
            for (int i = 1; i < chars.length; i++) {
                int i1 = chars[i] - '0';
                int sum=0;
                if (i1!=0){
                    sum+=cur;
                }
                int i2 = chars[i - 1] - '0';
                int i3=i2*10+i1;
                if (i3>=10&&i3<=26){
                    sum+=pre;
                }
                if (sum==0){
                    return 0;
                }else{
                    int temp=cur;
                    cur=sum;
                    pre=temp;
                }
            }
            return cur;
        }
    }

    class Solution {
        public int numDecodings(String s) {
            char[] chars = s.toCharArray();
            if (chars[0] == '0') {
                return 0;
            }
            int pre = 1;
            int cur = 1;
            for (int i = 1; i < chars.length; i++) {
                int i1 = chars[i] - '0';
                int i0 = chars[i - 1] - '0';
                int sum = i0 * 10 + i1;
                if (i == 1) {
                    if (i0 > 2 && i1 == 0) {
                        return 0;
                    } else if ((i1 == 0 && i0 < 3) || sum > 26) {
                        pre = 1;
                        cur = 1;
                    } else {
                        pre = 1;
                        cur = 2;
                    }
                    continue;
                }
                if (sum == 0 || (i0 > 2 && i1 == 0)) {
                    return 0;
                } else if (sum == 10 || sum == 20) {
                    int temp = cur;
                    cur = pre;
                    pre = temp;
                } else if (sum > 10 && sum <= 26) {
                    int temp = cur;
                    cur = cur + pre;
                    pre = temp;
                } else {
                    pre = cur;
                }
            }
            return cur;
        }
    }
}
