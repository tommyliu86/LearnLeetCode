package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-08-22-23:38
 */
public class Intersect {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1==null|| quadTree1.isLeaf){
            if (quadTree1==null) return quadTree2;
            if (quadTree1.val==true){
                return quadTree1;
            }
            else{
                return quadTree2;
            }
        }else{
            if (quadTree2==null ||quadTree2.isLeaf){
                if (quadTree2==null ) return quadTree1;
                if (quadTree2.val==true){
                    return quadTree2;
                }else{
                    return quadTree1;
                }
            }
            else {
                Node topleft=intersect(quadTree1.topLeft,quadTree2.topLeft);
                Node topright=intersect(quadTree1.topRight,quadTree2.topRight);
                Node botleft=intersect(quadTree1.bottomLeft,quadTree2.bottomLeft);
                Node botright=intersect(quadTree1.bottomRight,quadTree2.bottomRight);

                if (topleft.isLeaf&&topright.isLeaf&&botleft.isLeaf&&botright.isLeaf
                &&(topleft.val==topright.val==botleft.val==botright.val)){

                    return new Node(topleft.val,true,null,null,null,null);
                }else{
                    return new Node(false,false,topleft,topright,botleft,botright);
                }

            }
        }
    }

    /*
    // Definition for a QuadTree node.
    */
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
}