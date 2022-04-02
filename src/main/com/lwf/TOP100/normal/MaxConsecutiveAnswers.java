package com.lwf.TOP100.normal;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/
 * 2024. 考试的最大困扰度
 *
 * @author: liuwenfei14
 * @date: 2022-03-29 09:01
 */
public class MaxConsecutiveAnswers {
    /**
     *
     * 滑动窗口-双指针法，使用前后指针，在中间记录出现T 、F的个数count，保持count<=k 并记录遍历过程中的max即可
     */
    class test {
        public int maxConsecutiveAnswers(String answerKey, int k) {
            int leftT=0;
            int leftF=0;
            int countT=0;
            int countF=0;
            int max=0;
            char[] chars = answerKey.toCharArray();
            for (int i = 0; i < answerKey.length(); i++) {
                if (chars[i]=='T'){
                    countT++;
                }else{
                    countF++;
                }
                while (countT>k){
                    while (chars[leftF++]=='F'){

                    }
                    countT--;
                }
                while (countF>k){
                    while (chars [leftT++]=='T'){

                    }
                    countF--;
                }
                max=Math.max(max, Math.max(i-leftT+1,i-leftF+1));
            }
            return max;
        }

    }

    /**
     * 动态规划，超时。因为 时间为 n*logn
     */
    class Solution {
        public int maxConsecutiveAnswers(String answerKey, int k) {
            recurse(answerKey, 0, k, 0, answerKey.charAt(0));
            return max;
        }

        int max = 1;

        private void recurse(String answerKey, int currentIndex, int currentK, int count, char currentCount) {
            if (currentIndex > answerKey.length() - 1) {
                return;
            }

            max = Math.max(max, count);
            if (answerKey.charAt(currentIndex) == currentCount) {
                recurse(answerKey, currentIndex + 1, currentK, count + 1, currentCount);
                if (currentK > 0) {

                    recurse(answerKey, currentIndex + 1, currentK - 1, 1, currentCount == 'T' ? 'F' : 'T');
                }
            } else {
                if (currentK > 0) {
                    recurse(answerKey, currentIndex + 1, currentK - 1, count + 1, currentCount);
                }
                recurse(answerKey, currentIndex + 1, currentK, 1, currentCount == 'T' ? 'F' : 'T');
            }

        }
    }
}
