package com.lwf.oneLearnOneday.normal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-29 09:07
 */
public class FourTree {

    /*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

    class Solution {
        public Node construct(int[][] grid) {
            return recursive(grid,new int[]{0,0}, grid.length);
        }
        public Node recursive(int[][]grid,int[] origin,int length){
            if (length==1){
                return new Node(grid[origin[0]][origin[1]]==1,true,null,null,null,null);
            }
            int mid=length/2;
            Node tl=recursive(grid,origin,mid);
            Node tr=recursive(grid,new int[]{origin[0],origin[1]+mid},mid);
            Node bl=recursive(grid,new int[]{origin[0]+mid,origin[1]},mid);
            Node br=recursive(grid,new int[]{origin[0]+mid,origin[1]+mid},mid);

            boolean val = tl.val;
            if (tl.isLeaf&&tr.isLeaf&&bl.isLeaf&&br.isLeaf&&tr.val==val&&bl.val==val&&br.val==val){
                return new Node(val,true,null,null,null,null);
            }else{
                return new Node(false,false,tl,tr,bl,br);
            }

        }



    }
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
