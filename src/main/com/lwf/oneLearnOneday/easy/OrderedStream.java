package com.lwf.oneLearnOneday.easy;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {

        String[] strs;
        int cursor=0;
        public OrderedStream(int n) {
            strs=new String[n];
        }

        public List<String> insert(int idKey, String value) {
            strs[idKey-1]=value;
            List<String> rtn=new ArrayList<>();
            int i=idKey-1;
            if (i==cursor){
                while (i<strs.length&& strs[i]!=null){
                    rtn.add(strs[i++]);
                }
                cursor=i;
            }
            return rtn;
        }


/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
}
