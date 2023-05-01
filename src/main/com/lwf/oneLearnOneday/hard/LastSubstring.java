package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/4/24 20:24
 */
public class LastSubstring {
        public static void main(String[] args) {
            new Solution().lastSubstring("zaazaabcdezaazb");
        }
        static
    class Solution {
        public String lastSubstring(String s) {
            int i=0,j=0;
            while (j<s.length()){
                if (j==i||s.charAt(i)>s.charAt(j)){
                    j++;
                }else if (s.charAt(i)<s.charAt(j)){
                    i=j++;

                }else{
                    int i1=i,j1=j;
                    while(i1<j&&j1<s.length()){
                        if (s.charAt(i1)==s.charAt(j1)){
                            i1++;
                            j1++;
                        }else if (s.charAt(i1)>s.charAt(j1)){
                            j=j1;
                            break;
                        }else{
                            if (s.charAt(j1)>s.charAt(i)){
                                i=j1;
                                j=j1+1;
                            }else{
                                //j需要冲i后面继续检查。
                                i=j;
                                j=i+1;

                            }
                            break;
                        }
                    }
                    if (i1==j){
                        j=j1;
                    }
                    if (j1==s.length()){
                        break;
                    }
                }
            }
            return s.substring(i);
        }
    }
    /**
     * 暴力法，超时
     */
    class Solution1 {
        public String lastSubstring(String s) {
            int l=0,r=0;
            List<Integer> indez=new ArrayList<>();
            char max='a'-1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)>max){
                    max=s.charAt(i);
                    indez.clear();
                    indez.add(i);
                }else if (s.charAt(i)==max){
                    indez.add(i);
                }
            }
            if (indez.size()==1||indez.size()==s.length()) {
                return s.substring(indez.get(0));
            }else{
                int i=indez.get(0);
                for (Integer j : indez) {
                    int i1=i;
                    int j1=j;
                    while (j1<s.length()){
                        if (s.charAt(i1)==s.charAt(j1)){
                            i1++;
                            j1++;
                        }else {
                            i=s.charAt(i1)>s.charAt(j1)?i:j;
                            break;
                        }
                    }
                }
                return s.substring(i);
            }

        }
    }
}
