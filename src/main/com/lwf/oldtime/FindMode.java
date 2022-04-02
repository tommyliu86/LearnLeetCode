package com.lwf.oldtime;

import java.util.ArrayList;
import java.util.List;

/**
 * author Administrator
 * time 2019-08-20-22:33
 * {@link 501.md}
 */
public class FindMode {

    public int[] findMode(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        recurse(root,list);
        int[] rtn=new int[list.size()];
        for (int i = 0; i < rtn.length; i++) {
            rtn[i]=list.get(i);
        }
        return rtn;
    }
    int count=1;
    int max=0;
    TreeNode pre;
    void recurse(TreeNode node, List<Integer> list){
        if (node==null) return ;
        recurse(node.left,list);
        if (pre!=null&&node.val==pre.val){
            count++;
        }else {
            count=1;
        }
        if (count==max){
            list.add(node.val);
        }
        if (count>max){
            max=count;
            list.clear();
            list.add(node.val);
        }
        pre=node;
        recurse(node.right,list);
    }
}