package com.lwf.oneLearnOneday.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-17 09:31
 */
public class MostCommonWord {
    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            Map<String,Integer> map=new HashMap<>();
            Set<String> bans=new HashSet<>();
            for (String s : banned) {
                bans.add(s);
            }
            int max=0;
            String rtn=null;
            char[] chars = paragraph.toCharArray();
            for (int i = 0; i < chars.length; ) {
                StringBuilder builder=new StringBuilder();
                while (i<chars.length&& chars[i]>='A'&&chars[i]<='z'){
                    builder.append(chars[i]<'a'?(char)(chars[i]+32):chars[i]);
                    i++;
                }
                if (builder.length()>0){
                    String s = builder.toString();
                    if (!bans.contains(s)){
                        map.put(s,map.getOrDefault(s,0)+1);
                        if (map.get(s)>max){
                            max=map.get(s);
                            rtn=s;
                        }
                    }
                }else{
                    i++;
                }

            }
            return rtn;
        }
    }
}
