package com.lwf.oldtime;

import java.util.ArrayList;
import java.util.List;

/**
 * author Administrator
 * time 2019-08-29-22:31
 * {@link 572.md}
 */
public class IsSubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null ) return false;
        if (s.val==t.val&& isEqual(s,t)) return true;
        else    {
            return isSubtree(s.left,t)||isSubtree(s.right,t);
        }
    }
    boolean isEqual(TreeNode a,TreeNode b){
        if (a==null&&b==null) return true;
        if ((a==null&&b!=null)||(a!=null&&b==null))return false;
        return a.val==b.val&&isEqual(a.left,b.left)&&isEqual(a.right,b.right);
    }
}
class wrong{
    public boolean isSubtree(TreeNode s, TreeNode t) {
        List<Integer> lists=new ArrayList<>();
        List<Integer> listt=new ArrayList<>();
        getArray(s,lists);
        getArray(t,listt);
        for (int i = 0; i < lists.size() - listt.size(); i++) {
            for (int j = 0; j < listt.size(); j++) {
                if (lists.get(i+j)!=listt.get(j)){
                    break;
                }
            }
            return true;
        }
        return false;
    }
    void getArray(TreeNode node, List<Integer> list){
        if (node==null) return ;
        getArray(node.left,list);
        list.add(node.val);
        getArray(node.right ,list);
    }
}