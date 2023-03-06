package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/3/6 8:52
 */
public class MinimumDeletions {
    /**
     * dp思路要清晰
     * dp思路，设i处为 b，则f(i）不需要处理，因此f(i)=f(i-1),设i处为a，则删除a，或删除前面所有b
     */
    class Solution {
        public int minimumDeletions(String s) {
            int[] maxs=new int[s.length()+1];
            int cb=0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c=='b') {
                    maxs[i+1]=maxs[i];
                    cb++;
                }else{
                    maxs[i+1]=Math.min(maxs[i]+1,cb);
                }
            }
            return maxs[s.length()];
        }
    }
    /**
     * 前缀和+数字统计
     */
    class Solution2 {
        public int minimumDeletions(String s) {
            int[] countB=new int[s.length()+1];
            for (int i = 0; i < s.length(); i++) {
                countB[i+1]=countB[i]+(s.charAt(i)=='b'? 1:0);
            }
            int min=countB[s.length()];
            int countA=0;
            for (int i = s.length()-1; i >= 0; i--) {
                countA+=s.charAt(i)=='a'?1:0;
                min=Math.min(countA+countB[i],min);
            }
            return min;

        }
    }

    /**
     * 思路错误，可以单独前面消除a里面的b，然后消除后面的b里面的a，
     */
    class Solution1 {
        public int minimumDeletions(String s) {
            int firstB = 0, lastA = 0;
            int i = 0;
            while (i < s.length()) {
                if (s.charAt(i) == 'b') {
                    while (i < s.length()) {
                        firstB += s.charAt(i) == 'a' ? 1 : 0;
                        i++;
                    }
                } else {
                    i++;
                }
            }
            while (--i >= 0) {
                if (s.charAt(i) == 'a') {
                    while (i >= 0) {
                        lastA += s.charAt(i) == 'b' ? 1 : 0;
                        i--;
                    }
                } else {
                    i--;
                }
            }
            return Math.min(firstB, lastA);
        }
    }
}
