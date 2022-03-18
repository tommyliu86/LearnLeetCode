package com.lwf;

import java.util.HashMap;
import java.util.IllegalFormatCodePointException;

/**
 * author Administrator
 * time 2019-07-25
 */
public class IsIsomorphic {
    /**
     * 1.题目详解：同构则表示，char位置相同，双向替换可以交换，则在一个字符串中出现多次的字符需要在另外一个中有对应的字符对应
     * 因此暴力解法，使用map映射，比较两个位置上的是否一致，如果只有一个，则需要遍历到最后，最坏时间O(n)
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length()!=t.length()) {
            return false;
        }
        HashMap<Character,Character> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                if (map.get(s.charAt(i))!=t.charAt(i))
                return false;
                else {
                    continue;
                }
            }else if (map.containsValue(t.charAt(i))){
               return false;

            }else {
                map.put(s.charAt(i),t.charAt(i));
            }


        }
        return true;
    }
    public boolean isIsom(String s,String t){
        if (s.length()!=t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            if ( s.indexOf(s.charAt(i))!=t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
