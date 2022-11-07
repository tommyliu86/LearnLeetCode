package com.lwf.oneLearnOneday.normal;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2022/11/7 8:59
 */
public class AmbiguousCoordinates {

    /**
     * 暴力模拟
     */
    class Solution {
        public List<String> ambiguousCoordinates(String s) {
            s=s.substring(1,s.length()-1);
            List<String> ans=new ArrayList<>();
            for (int i = 1; i < s.length(); i++) {
                List<String> ls = gen(s.substring(0, i));
                List<String> rs = gen(s.substring(i));
                if (ls.size()==0||rs.size()==0){
                    continue;
                }
                for (int j = 0; j < ls.size(); j++) {
                    for (int k = 0; k < rs.size(); k++) {
                        ans.add("("+ ls.get(j)+","+rs.get(k)+")");
                    }
                }
            }
            return ans;
        }
        public List<String> gen(String s){
            List<String> ans=new ArrayList<>();
            if (s.length()==1){
                ans.add(s);
                return ans;
            }
            if (s.charAt(0)=='0'&&s.charAt(s.length()-1)=='0') {
                return ans;
            }else if (s.charAt(0)=='0'){
                ans.add(String.join(".",s.substring(0,1),s.substring(1)));
            }else if (s.charAt(s.length()-1)=='0'){
                ans.add(s);
            } else{
                ans.add(s);
                for (int i = 1; i < s.length(); i++) {
                   ans.add( String.join(".",s.substring(0,i),s.substring(i)));
                }
            }
            return ans;
        }
    }
}
