package com.lwf.learn.everyday.coding.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-09 10:07
 */
public class Interpret {
    class Solution {
        public String interpret(String command) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < command.length(); i++) {
                if (command.charAt(i)=='G'){
                    builder.append(command.charAt(i));
                }else if (command.charAt(i)=='('){
                    i++;
                    boolean isO=true;
                    while (command.charAt(i)!=')'){
                        isO=false;
                        builder.append(command.charAt(i));
                        i++;
                    }
                    if (isO) {
                        builder.append('o');
                    }
                }
            }
            return builder.toString();
        }
    }
}
