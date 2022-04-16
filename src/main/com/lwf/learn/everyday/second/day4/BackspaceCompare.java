package com.lwf.learn.everyday.second.day4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-16 15:38
 */
public class BackspaceCompare {
    /**
     * 遍历循环。
     */
    class doublePoint {
        public boolean backspaceCompare(String s, String t) {
            char[] sC = s.toCharArray();
            char[] tC = t.toCharArray();

            int sI = sC.length - 1;
            int tI = tC.length - 1;
            int stepS=0;
            int stepT=0;
            /**
             * 通过或的关系，多一次循环，把一个为空了之后。另外一个剩余的也走一下看是否能走到空字符串来判断是否相等。
             */
            while (sI>=0||tI>=0){
                while (sI>=0&&( sC[sI]=='#'||stepS>0)){
                    if (sC[sI]=='#'){
                        stepS++;
                    }else{
                        stepS--;
                    }
                    sI--;
                }
                while (tI>=0&&( tC[tI]=='#'||stepT>0)){
                    if (tC[tI]=='#'){
                        stepT++;
                    }else{
                        stepT--;
                    }
                    tI--;
                }
                if (sI>=0&&tI>=0){
                    if (sC[sI]!=tC[tI]){
                        return false;
                    }
                }else{
                    if (sI>=0||tI>=0) {
                        return false;
                    }
                }
                sI--;
                tI--;
            }

           return true;
        }
    }

    /**
     * 重构字符串
     */
    class Solution {
        public boolean backspaceCompare(String s, String t) {
            char[] sC = s.toCharArray();
            char[] tC = t.toCharArray();

            int sI = sC.length - 1;
            int tI = tC.length - 1;
            Queue<Character> listS = new LinkedList<>();
            int step = 0;
            while (sI >= 0) {
                if (sC[sI] == '#' || step > 0) {
                    if (sC[sI] == '#') {
                        step++;
                    } else {
                        step--;
                    }
                } else {
                    listS.add(sC[sI]);
                }
                sI--;
            }

            step = 0;
            while (tI >= 0) {
                if (tC[tI] == '#' || step > 0) {
                    if (tC[tI] == '#') {
                        step++;
                    } else {
                        step--;
                    }
                } else {
                    if (listS.isEmpty()) {
                        return false;
                    } else {

                        Character poll = listS.poll();
                        if (poll != tC[tI]) {
                            return false;
                        }
                    }
                }
                tI--;
            }
            return listS.isEmpty();

        }
    }
}
