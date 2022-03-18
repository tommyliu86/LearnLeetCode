package com.lwf;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * author Administrator
 * time 2019-07-31
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root==null) return  null;
        List<String> list=new ArrayList<>();
        binaryPaths("",list,root);
        return list;
    }

    void binaryPaths(String path,List<String> list,TreeNode node){
        path=path.length()==0? String.valueOf(node.val): MessageFormat.format("{0}->{1}",path,node.val);
        if (node.left==null&&node.right==null){

            list.add(path);
            return;
        }
        if (node.left!=null){
            binaryPaths(path,list,node.left);
        }
        if(node.right!=null){
            binaryPaths(path,list,node.right);
        }
    }

}
