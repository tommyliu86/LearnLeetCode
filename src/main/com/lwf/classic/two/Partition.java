package com.lwf.classic.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LCR 086. 分割回文串
 * @author liuwenfei
 * @date 2024/1/10 9:09
 */
public class Partition {
    /**
     * 1.预处理，获取每个位置i向后的回文字符串列表，然后遍历枚举，进行回溯获取所有。
     * 一般情况下，stream函数式编程都会造成性能损失。
     */
    class Solution {
        public String[][] partition(String s) {
            List<String>[] pa=new List[s.length()];
            for (int i = 0; i < s.length(); i++) {
                pa[i]=isPa(s,i);
            }

            List<String> list=new ArrayList<>();
            List<List<String>> ans=new ArrayList<>();
            recurse(s,pa,0,list,ans);
            String[][] ar=new String[ans.size()][];
            for (int i = 0; i < ans.size(); i++) {
                String[] sub=new String[ans.get(i).size()];
                for (int i1 = 0; i1 < sub.length; i1++) {
                    sub[i1]=ans.get(i).get(i1);
                }
                ar[i]=sub;
            }
            return ar;
        }
        public void recurse(String s,List<String>[] pa,int i,List<String> list,List<List<String>> ans){
            if (i==s.length()){
                ans.add(new ArrayList<>(list));
                return;
            }
            for (int j = 0; j < pa[i].size(); j++) {
                String cur = pa[i].get(j);
                list.add(cur);
                recurse(s,pa,i+cur.length(),list,ans);
                list.remove(list.size()-1);
            }
        }

        public List<String> isPa(String s,int i){
            List<String> ans=new ArrayList<>();
            for (int j = i; j < s.length(); j++) {
                int a=i,b=j;
                while (a<=b&&s.charAt(a)==s.charAt(b)){
                    a++;
                    b--;
                }
                if (a>b){
                    ans.add(s.substring(i,j+1));
                }
            }
            return ans;
        }
    }
}
