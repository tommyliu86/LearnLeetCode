package com.lwf;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author Administrator
 * time 2019-08-12
 * {@link 429.md}
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list=new ArrayList<>();
        if (root== null ) return list;
        if (root.children==null) {
            list.add(new ArrayList<>(Arrays.asList(root.val)));
            return list;
        }
        getLevel(root,0,list);
        return list;
    }
    void getLevel(Node node ,int level,List<List<Integer>> list){
        if (list.size()<level+1 ){
            list.add(level,new ArrayList<>(Arrays.asList(node.val)));

        }
        else  {
            List<Integer> sublist=list.get(level);
            sublist .add(node.val);
        }
        if (node.children!=null ){
            for (Node child : node.children) {
                getLevel(child,level+1,list);
            }
        }
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
