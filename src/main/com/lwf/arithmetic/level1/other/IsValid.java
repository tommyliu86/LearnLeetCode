package com.lwf.arithmetic.level1.other;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-22 17:09
 */
public class IsValid {
    class Solution {
        public boolean isValid(String s) {
            Map<Character,Character> map=new HashMap<>();
            map.put(')','(');
            map.put(']','[');
            map.put('}','{');
            char[] chars = s.toCharArray();
            Stack<Character> stack=new Stack<>();
            for (int i = 0; i < chars.length; i++) {
                if (map.containsKey(chars[i])){
                    if (stack.isEmpty()|| stack.peek()!=map.get(chars[i])){
                        return false;
                    }else{
                        stack.pop();
                    }
                }else{
                    stack.push(chars[i]);
                }
            }
            return stack.isEmpty();
        }
        char[] lefts={'(','{','['};
        char[] rights={')','}',']'};
    }
}
