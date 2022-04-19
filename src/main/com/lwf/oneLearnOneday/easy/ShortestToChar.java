package com.lwf.oneLearnOneday.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-19 08:54
 */
public class ShortestToChar {
    class test {
        public int[] shortestToChar(String s, char c) {
            int[] dis=new int[s.length()];
            char[] chars = s.toCharArray();
            Queue<Integer> indexs=new LinkedList<>();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i]==c) {
                    dis[i]=0;
                    indexs.add(i);
                }else{
                    dis[i]=s.length();
                }
            }
            int d=1;
            while (!indexs.isEmpty()){
                int size = indexs.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = indexs.poll();
                    if (poll-1>=0) {
                        if (dis[poll-1]>d){
                            dis[poll-1]=d;
                            ((LinkedList<Integer>) indexs).add(poll-1);
                        }
                    }
                    if (poll+1<chars.length){
                        if (dis[poll+1]>d){
                            dis[poll+1]=d;
                            ((LinkedList<Integer>) indexs).add(poll+1);
                        }
                    }
                }
                d++;
            }
            return dis;
        }
    }

    class Solution {
        public int[] shortestToChar(String s, char c) {
            int[] dis = new int[s.length()];
            char[] chars = s.toCharArray();
            int d = chars.length;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == c) {
                    d = 0;
                }
                dis[i] = d++;
            }
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] == c) {
                    d = 0;
                }
                dis[i] = Math.min(d++, dis[i]);
            }
            return dis;

        }
    }
}
