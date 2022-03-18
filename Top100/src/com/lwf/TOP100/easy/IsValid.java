package com.lwf.TOP100.easy;

import java.util.Stack;

/**
 * author Administrator
 * time 2019-09-09-22:28
 */
public class IsValid {
    public boolean isValid(String s) {
        if (s.length()==0) return  true;
        if ((s.length()&1)==1) return false;
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()){

                char li=stack.peek();
                if (li=='('&&s.charAt(i)==')'||li=='{'&&s.charAt(i)=='}'||li=='['&&s.charAt(i)==']'){
                    stack.pop();
                }else {
                    stack.add(s.charAt(i));
                }
            }else  {
                stack.add(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
