package com.lwf.learn.everyday.dp.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-10 15:48
 */
public class WordBreak {
    class test {
        public boolean wordBreak(String s, List<String> wordDict) {
            Map<Character,List<String>> dics=new HashMap<>();
            for (int i = 0; i < wordDict.size(); i++) {
                char c = wordDict.get(i).charAt(wordDict.get(i).length() - 1);
                List<String> l = dics.getOrDefault(c, new ArrayList<>());
                l.add(wordDict.get(i));
                dics.put(c, l);
            }
            boolean[] mark=new boolean[s.length()];
            for (int i = 0; i < s.length(); i++) {
                Character c =Character.valueOf( s.charAt(i));
                if (dics.containsKey(c)){
                    List<String> list = dics.get(c);
                    for (int j = 0; j < list.size(); j++) {
                        String s1 = list.get(j);
                        int preI = i + 1 - s1.length();
                        if (i+1>=s1.length()&&s.substring(preI,i+1).equals(s1)&&(preI ==0||mark[preI-1]==true)) {
                               mark[i]=true;
                               break;
                        }
                    }
                }
            }
            return mark[s.length()-1];
        }
    }

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {

            boolean[] mark = new boolean[s.length()];
            for (int i = 0; i < s.length(); i++) {
                for (String s1 : wordDict) {
                    if (i + 1 >= s1.length()) {
                        if (s.substring(i + 1 - s1.length(), i + 1).equals(s1) && mark[i + 1 - s1.length()]) {
                            mark[i] = true;
                            break;
                        }
                    }
                }
            }
            return mark[s.length() - 1];
        }

    }
}
