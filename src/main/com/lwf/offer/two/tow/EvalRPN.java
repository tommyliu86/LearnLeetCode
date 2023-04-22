package com.lwf.offer.two.tow;

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvalRPN {
    class Solution {
        public int evalRPN(String[] tokens) {


            Stack<Integer> members=new Stack<>();

            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i].equals("*")) {
                   members.push( members.pop()*members.pop());
                }else if (tokens[i].equals("+")){
                    members.push(members.pop()+members.pop());
                }else if (tokens[i].equals("-")){
                    members.push(-1*(members.pop())+ members.pop());
                }else if (tokens[i].equals("/")){
                    Integer pop1 = members.pop();
                    Integer pop2 = members.pop();
                    members.push(pop2/pop1);
                }else{
                    members.add(Integer.valueOf(tokens[i]));
                }
            }
            return members.pop();
        }
    }
}
