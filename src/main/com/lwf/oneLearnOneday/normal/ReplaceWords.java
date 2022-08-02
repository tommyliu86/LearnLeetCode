package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {
    class Solution {
        public String replaceWords(List<String> dictionary, String sentence) {
            Map<Integer,List<String>> map = new HashMap<>();
            for (String s : dictionary) {
                List<String> list = map.getOrDefault(s.length(), new ArrayList<>());
                list.add(s);
                map.put(s.length(),list);
            }
            int i=0;
            StringBuilder stringBuilder = new StringBuilder();
            while (i<sentence.length()){
                int j=i+1;
                String dic=null;
                while (j<sentence.length()&&sentence.charAt(j)!=' '){

                    if (dic==null&& map.containsKey(j-i)){
                        String sub = sentence.substring(i, j);
                        List<String> strings = map.get(j - i );
                        if (strings.contains(sub)) {
                            dic=sub;
                        }
                    }
                    j++;
                }
                if (dic==null){
                    dic=sentence.substring(i,j);
                }
                stringBuilder.append(dic);
                if (j!=sentence.length()){
                    stringBuilder.append(" ");
                }
                i=j+1;
            }
            return stringBuilder.toString();
        }
    }
}
