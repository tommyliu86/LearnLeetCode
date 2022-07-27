package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

public class MagicDictionary {

    List<DicNode> nodes;

    public MagicDictionary() {
        nodes = new ArrayList<>();
    }

    public void buildDict(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            String s = dictionary[i];
            List<DicNode> cur=nodes;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                DicNode curNode=null;
                for (DicNode dicNode : cur) {
                    if (dicNode.var==c) {
                       curNode=dicNode;
                       break;
                    }
                }
                if (curNode==null){
                    curNode=new DicNode();
                    curNode.var=c;
                    cur.add(curNode);
                }
                if (j==s.length()-1){
                    curNode.end=true;
                }
                cur=curNode.next;
            }
        }
    }

    public boolean search(String searchWord) {
        List<DicNode> cur=nodes;
        return search(searchWord.toCharArray(),0,0,cur);
    }
    private boolean search(char[] chars,int i,int count,List<DicNode> cur){
        if (i==chars.length-1){
            for (int j = 0; j < cur.size(); j++) {
                DicNode dicNode = cur.get(j);
                if (dicNode.end&&((dicNode.var==chars[i]&&count==1)||(dicNode.var!=chars[i]&&count==0))){
                    return true;
                }
            }
            return false;
        }
        for (int j = 0; j < cur.size(); j++) {
            DicNode dicNode = cur.get(j);
            if (dicNode.var==chars[i]){
                boolean sub = search(chars, i + 1, count, dicNode.next);
                if (sub){
                    return true;
                }
            }else if (count==0){
                boolean sub = search(chars, i + 1, count+1, dicNode.next);
                if (sub){
                    return true;
                }
            }
        }
        return false;
    }

    class DicNode {
        char var;
        List<DicNode> next;
        boolean end;
       public DicNode(){
           next=new ArrayList<>();
       }
    }

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
}
