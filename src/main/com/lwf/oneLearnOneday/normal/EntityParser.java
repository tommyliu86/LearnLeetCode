package com.lwf.oneLearnOneday.normal;

import java.util.Map;

/**
 * 1410. HTML 实体解析器
 *
 * @author liuwenfei
 * @date 2023/11/23 8:46
 */
public class EntityParser {
    /**
     * 哈希  + 遍历
     */
    class Solution {
        Map<String, String> map = Map.of(
                "&quot;", "\""
                , "&apos;", "'"
                , "&amp;", "&"
                , "&gt;", ">"
                , "&lt;", "<"
                , "&frasl;", "/"
        );
        public String entityParser(String text) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i)=='&'){
                    int j=i+1;
                    while (j<text.length()&&text.charAt(j)!='&'&&text.charAt(j)!=';'){
                        j++;
                    }
                    if (j==text.length()){
                        stringBuilder.append(text.substring(i,j));
                    }else{
                        String s = map.get(text.substring(i, j + 1));
                        if (s==null){
                            if (text.charAt(j)=='&'){
                                j--;
                            }
                            stringBuilder.append(text.substring(i,j+1));
                        }else{
                            stringBuilder.append(s);
                        }
                    }
                    i=j;
                }else{
                    stringBuilder.append(text.charAt(i));
                }
            }
            return stringBuilder.toString();
        }
    }

}
