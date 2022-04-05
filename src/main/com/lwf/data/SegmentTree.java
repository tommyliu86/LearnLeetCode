package com.lwf.data;

/**
 * Created with IntelliJ IDEA.
 * 线段树，使用数组结构来存储数据，用来解决数组的区间查询、更新等问题。
 * 结构为以原数组为底，从下向上构建成二叉树结构，每个叶子节点保存原数组数据，每个节点保存左右子节点中的数据的和（以求区间和为例）
 * 用数组存储二叉树时，一般都是广度遍历模式，从顶向下构建，构建公式：节点 i的左右子节点为【2*i+1，2*i+2】
 * @author: liuwenfei14
 * @date: 2022-04-05 18:09
 */
public class SegmentTree {
    //数组存储
    int[] segment;
    //原数组长度
    int n;
    public SegmentTree(int[] nums){
        this.n=nums.length;
        segment=new int[4*n];
        build(0,nums,0,n-1);
    }

    /**
     * 递归构建线段数的数组结构
     * @param segIndex
     * @param nums
     * @param left
     * @param right
     */
    private void build(int segIndex,int[] nums,int left,int right){
        if (left==right){//叶子节点,叶子节点表示的区间是本身，因此构建时，递归找到叶子节点，进行赋值，然后通过节点=左+右来构建上层节点
            segment[segIndex]=nums[left];
            return;
        }
        int mid=(left+right)/2;
        build(segIndex*2+1,nums,left,mid);
        build(segIndex*2+2,nums,mid+1,right);
        segment[segIndex]=segment[segIndex*2+1]+segment[segIndex*2+2];
    }

    public void update(int index,int val){
        update(index,val,0,0,n-1);
    }

    /**
     * 递归更新，使用要更新的index与 每个segment中节点表示的L和R的区间进行比较，看index的叶子节点落在哪个子树中，然后进入更新即可
     * @param index
     * @param val
     * @param segIndex
     * @param segL
     * @param segR
     */
    private void update(int index,int val,int segIndex,int segL,int segR){
        if (segL==segR){ //递归更新，L==R表示找到当前index的节点了
            segment[segL]=val;
            return;
        }
        int segM=(segL+segR)/2;
        if (index>segM){
            update(index,val,segIndex*2+2,segM+1,segR);
        }else{
            update(index,val,segIndex*2+1,segL, segM);
        }
        segment[segIndex]=segment[segIndex*2+1]+segment[segIndex*2+2];
    }
    public int query(int left,int right){
        return query(0,0,n-1,left,right);
    }
    private int query(int segIndex,int segL,int segR,int left,int right){
        if (segL==left&&segR==right){ //segment的区间正好重合，则直接返回
            return segment[segIndex];
        }
        int segM=(segL+segR)/2;
        if (right<=segM){ //区间在左侧，则找左子树
            return query(segIndex*2+1,segL,segM,left,right);
        }else if (left>segM){ //区间在右侧，则找右子树
            return query(segIndex*2+2,segM+1,segR,left,right);
        }else{ //跨区间，则拆分为左和右，中间的m直接使用segment的中间值segM即可。
            return query(segIndex*2+1,segL,segM,left,segM)+query(segIndex*2+2,segM+1,segR,segM+1,right);
        }
    }
}
