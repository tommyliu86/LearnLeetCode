package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author Administrator
 * time 2019-11-04-23:25
 */
public class WordBreak {
    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("catsandog",
                new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return recursive(s, wordDict, 0);
    }

    /**
     * 超时
     * @param s
     * @param wordDict
     * @param start
     * @return
     */
    boolean recursive(String s, List<String> wordDict, int start) {
        for (int i = start; i < s.length(); i++) {
            if ( wordDict.contains(s.substring(start, i+1))&&(i==s.length()-1 || recursive(s, wordDict, i + 1))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 递归优化，添加失败的标记
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        return recursive1(s, wordDict, 0,new int[s.length()]);
    }
    boolean recursive1(String s, List<String> wordDict, int start,int[] falseTags) {
        falseTags[start]=1;
        for (int i = start; i < s.length(); i++) {
            if (falseTags[i+1]==1) continue; //从i+1开始到s尾部的已经被标记为失败，因此不需要再遍历判断了
            if ( wordDict.contains(s.substring(start, i+1))&&(i==s.length()-1 || recursive1(s, wordDict, i + 1,falseTags))) {
                return true;
            }
        }
        return false;
    }
}
