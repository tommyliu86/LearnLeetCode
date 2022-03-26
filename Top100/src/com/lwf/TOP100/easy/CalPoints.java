package com.lwf.TOP100.easy;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-03-26 10:33
 */
public class CalPoints {
    public static void main(String[] args) {
        new test().calPoints(new String[] {"5","2","C","D","+"});
    }

    /**
     * 使用栈来作为辅助，一次遍历进行计算
     */
    static class test {
        public int calPoints1(String[] ops) {
            int sum=0;
            Stack<Integer> stack=new Stack<>();
            for (int i = 0; i < ops.length; i++) {
                if (ops[i].equals("C")){
                    Integer pop = stack.pop();
                    sum-=pop;
                }else if (ops[i].equals("D")){
                    Integer peek = stack.peek();
                    stack.push(peek*2);
                    sum+=peek*2;
                }else if(ops[i].equals("+")){
                    Integer pop = stack.pop();
                    Integer peek = stack.peek();
                    stack.push(pop);
                    stack.push(pop+peek);
                    sum+=pop+peek;
                }else{
                    Integer integer = Integer.valueOf(ops[i]);
                    stack.push(integer);
                    sum+=integer;
                }
            }

            return sum;
        }
        public int calPoints(String[] ops) {
            int sum=0;
            Stack<Integer> stack=new Stack<>();
            for (int i = 0; i < ops.length; i++) {
                if (ops[i]=="C"){
                    stack.pop();
                }else if (ops[i]=="D"){
                    Integer peek = stack.peek();
                    stack.push(peek*2);
                }else if(ops[i]=="+"){
                    Integer pop = stack.pop();
                    Integer peek = stack.peek();
                    stack.push(pop);
                    stack.push(pop+peek);
                }else{
                    stack.push(Integer.valueOf(ops[i]));
                }
            }
            while (!stack.isEmpty()){
                sum+=stack.pop();
            }
            return sum;
        }
    }
    /**
     * 模拟法，一次遍历，对 C、D + 三个计算符号进行模拟计算即可。同时对着三个符号的位置进行赋值或移除操作。
     */
    static class Solution {
        public int calPoints(String[] ops) {
            int sum=0;
            for (int i = 0; i < ops.length; i++) {
                if (ops[i].equals("C")){
                    int index=i;
                    while (ops[--index]==""){

                    }
                    String needRemove = ops[index];
                    ops[index]="";
                    ops[i]="";
                    sum-= Integer.valueOf(needRemove);
                }else if (ops[i].equals("D")){
                    int index=i;
                    while (ops[--index]==""){

                    }
                    Integer needDouble = Integer.valueOf(ops[index]);
                    ops[i]=String.valueOf( needDouble*2);
                    sum+=needDouble*2;
                }else if (ops[i].equals("+")){
                    int first=i;
                    while (ops[--first]==""){

                    }
                    int second=first;
                    while (ops[--second]==""){

                    }
                    int sum1 = Integer.valueOf(ops[first]) + Integer.valueOf(ops[second]);
                    ops[i]=String.valueOf( sum1);
                    sum+=sum1;
                }else{
                    sum+=Integer.valueOf(ops[i]);
                }
            }
            return sum;
        }
    }
}
