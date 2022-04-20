package com.lwf.oneLearnOneday.normal;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-20 09:34
 */
public class LengthLongestPath {
    public static void main(String[] args) {
        String s="dir\n\t";
        char[] chars = s.toCharArray();
        System.out.println(chars.length);
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
            if (chars[i]=='\n'){
                System.out.println("\\n");
            }
            if (chars[i]=='\t'){
                System.out.println("\t");
            }
        }
    }

    /**
     * 考虑所有分支情况进行遍历，使用辅助栈来保存经过路径上的每个文件，文件夹的长度，这样在回退的时候可以统计到路径长
     */
    class Solution {
        public int lengthLongestPath(String input) {
            Stack<Integer> stack =new Stack<>();
            int count=0;
            int max=0;
            char[] chars = input.toCharArray();
            for (int i = 0; i < chars.length; ) {
                int c=i;
                int l=0;
                boolean isFile=false;
                while (c<chars.length&& chars[c]!='\n'){
                    if (chars[c]=='.'){
                        isFile=true;
                    }
                    l++;
                    c++;
                }
                if (c==chars.length){
                    stack.add(l);
                    count+=l;
                    if (isFile){
                        max=Math.max(max,count);
                    }
                    break;
                }
                else {
                    if (isFile){
                        stack.add(l);
                        count+=l;
                        max=Math.max(max,count);
                    }else{

                        stack.add(l+1);
                        count+=l+1;
                    }

                    int depth=0;
                    while (chars[++c]=='\t'){
                        depth++;
                    }
                    while (stack.size()>depth){
                       count-= stack.pop();
                    }
                    i=c;
                }
            }
            return max;
        }
    }
}
