package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/2/8 9:37
 */
public class RemoveSubfolders {
    /**
     * 字典树
     */
    class Solution {
        public List<String> removeSubfolders(String[] folder) {
            Node root=new Node();
            for (int i = 0; i < folder.length; i++) {
                String s = folder[i];
                String[] split = s.split("/");
                addNode(root,split);
            }
            List<String> ans=new ArrayList<>();
            dfs(root,new ArrayList<String>(),ans);
            return ans;
        }
        public void dfs(Node node,List<String> strs,List<String> ans){
            if (node.leaf){
                ans.add("/"+ String.join("/",strs));
                return;
            }
            if (!node.childrn.isEmpty()) {
                for (Map.Entry<String, Node> entry : node.childrn.entrySet()) {
                    strs.add(entry.getKey());
                    dfs(entry.getValue(),strs,ans);
                    strs.remove(strs.size()-1);
                }
            }
        }
        public void addNode(Node root,String[] split){
            Node cursor=root;
            for (int j = 1; j < split.length; j++) {
                String cur = split[j];
                if (cursor.childrn.containsKey(cur)) {
                    Node node = cursor.childrn.get(cur);
                    if (node.leaf) {
                        return;
                    }else if (j==split.length-1) {
                        node.leaf=true;
                    }else{
                        cursor=node;
                    }
                }else{
                    Node node = new Node();
                    node.val=cur;
                    node.leaf=(j==split.length-1);
                    cursor.childrn.put(cur,node);
                    cursor=node;
                }
            }
        }
        public class Node{
            String val;
            boolean leaf=false;
            Map<String, Node> childrn=new HashMap<>();
        }
    }
}
