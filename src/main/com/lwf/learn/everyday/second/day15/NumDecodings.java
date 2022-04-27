package com.lwf.learn.everyday.second.day15;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-27 12:49
 */
public class NumDecodings {
    public static void main(String[] args) {
        new dp().numDecodings("11");
    }

    /**
     * 转换思路，对于 char[i]，单独作为字母如果可以，则count[i]中可以加上count[i-1]，如果char[i-1]+char[i]两个字母也可以
     * 则count[i]+=count[i-2]；,这样的判断逻辑就非常清晰和简单了。有时候，想问题需要多思路思考！！！！
     */
    static class dp1 {
        public int numDecodings(String s) {
            char[] chars = s.toCharArray();
            if (chars[0]=='0'){
                return 0;
            }
            int i=1;
            int pre=1;
            int cur=1;
            while (i<chars.length&&cur!=0){
                int count=0;
                int curI = chars[i]-'0';
                int i1 = chars[i - 1] - '0';
                if (curI!=0){
                    count+=cur;
                }
                if (i1!=0&&(i1*10+curI)<=26){
                    count+=pre;
                }
                pre=cur;
                cur=count;
            }
            return cur;

        }
    }
    /**
     *直观的边界条件，i 和i-1都是0，则错误，否则，i-1==0，则为count[i-1]; i==0,i-1>2错误，否则为count[i-2]，i!=0&&i-1!=0,
     */
    static class dp {
        public int numDecodings(String s) {
            char[] chars = s.toCharArray();
            if (chars[0] == '0') {
                return 0;
            }
            int[] count = new int[chars.length + 1];
            count[0] = 1;
            count[1] = 1;
            int i = 1;
            while (i < chars.length) {
                int i2 = chars[i] - '0';
                int i1 = chars[i - 1] - '0';
                int j = i1 * 10 + i2;
                if (i1 == 0 && i2 == 0) {
                    return 0;
                } else if (i1 == 0) {
                    count[i + 1] = count[i];
                } else if (i2 == 0) {
                    if (i1 > 2) {
                        return 0;
                    } else {
                        count[i + 1] = count[i - 1];
                    }
                } else {

                    if (j <= 26) {
                        count[i + 1] = count[i - 1] + count[i];
                    } else {
                        count[i + 1] = count[i];
                    }
                }
                i++;

            }
            return count[count.length - 1];
        }
    }

    /**
     * 暴力递归法，超时，
     */
    class Solution {
        public int numDecodings(String s) {
            char[] chars = s.toCharArray();
            recursive(chars, 0);
            return count;
        }

        int count = 0;

        public void recursive(char[] chars, int index) {
            if (index == chars.length) {
                count++;
            }
            char aChar = chars[index];
            if (aChar != '0') {
                recursive(chars, index + 1);
                if (index + 1 < chars.length) {
                    int i = 0;
                    i += (aChar - '0');
                    i = i * 10 + (chars[index + 1] - '0');
                    if (i <= 26) {
                        recursive(chars, index + 2);
                    }
                }
            } else {
                return;
            }
        }
    }
}
