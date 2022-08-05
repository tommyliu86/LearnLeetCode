package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderlyQueue {
    class Solution {
        public String orderlyQueue(String s, int k) {
            char[] chars = s.toCharArray();
            if (k>1){
                Arrays.sort(chars);
                return String.valueOf(chars);
            }
            List<Integer> list=new ArrayList<>();
            int min=0;
            for (int i = 0; i < chars.length; i++) {
                if (min==chars[i]){
                    list.add(i);
                }else if (min>chars[i]){
                    min=chars[i];
                    list.clear();
                    list.add(i);
                }
            }
            char[] rtn=new char[s.length()];
            rtn[0]=chars[ list.get(0)];
            int i=1;
           while (i<s.length()&&list.size()>1){
               char sub=0;
               List<Integer> minList=new ArrayList<>();
               for (int j = 0; j < list.size(); j++) {
                   Integer index =( list.get(j)+i)%s.length();
                   if (sub>chars[index]){
                       minList.clear();
                       minList.add(j);
                       sub=chars[index];
                   }else if (sub==chars[index]){
                       minList.add(j);
                   }
               }
               rtn[i]=sub;
               list=minList;
               i++;
           }
            Integer l = list.get(0);
            for (; i < chars.length; i++) {
              rtn[i]= chars[ (i+l)%s.length()];
            }
            return String.valueOf(rtn);
        }
    }
}
