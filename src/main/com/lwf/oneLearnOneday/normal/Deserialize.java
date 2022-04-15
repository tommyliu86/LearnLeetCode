package com.lwf.oneLearnOneday.normal;

import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * https://leetcode-cn.com/problems/mini-parser/
 *
 * @author: liuwenfei14
 * @date: 2022-04-15 10:00
 */
public class Deserialize {
    public static void main(String[] args) {
        System.out.println('0'-0);
        System.out.println('9'-0);
        new Solution().deserialize("[123,[[]],10,[]]");
    }
   static class Solution {
        public NestedInteger deserialize(String s) {
            char[] chars = s.toCharArray();
            Stack<NestedInteger> stack =new Stack<>();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i]=='['){
                    NestedInteger nestedInteger = new NestedInteger();
                    stack.push(nestedInteger);

                }else if (chars[i]==']'){ //对于空list，】拿到list本身，而非空】拿到最后一个元素。

                    NestedInteger pop = stack.pop();

                        if (!stack.isEmpty()){
                            NestedInteger peek = stack.peek();
                            peek.add(pop);
                        }else{
                            stack.push( pop);
                        }


                }
                else if (chars[i]==','){ //这里的关键在于逗号不做处理，和直接把数字的放入栈顶，保证栈顶一直是list即可。

                }
                else { //数字的直接放入list中，栈顶一直会是list
                    NestedInteger nestedInteger = new NestedInteger();
                    int num=0;
                    boolean plus=true;

                    if (chars[i]=='-'){
                        plus=false;
                        i++;

                    }
                    while (i<chars.length&& chars[i]>='0'&&chars[i]<='9'){
                        num=(num*10+(chars[i]-'0'));
                        i++;
                    }
                    nestedInteger.setInteger(plus?num:(num*-1));
                    if (stack.isEmpty()){
                        return nestedInteger;
                    }else{

                     stack.peek().add(nestedInteger);
                        i--;
                    }
                }
            }
            return stack.pop();
        }
    }

   static class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger(){}

        // Constructor initializes a single integer.
        public NestedInteger(int value){}

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger(){
            return  false;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger(){
            return null;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value){
            return;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni){
            return;
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList(){
            return null;
        }
    }
}
