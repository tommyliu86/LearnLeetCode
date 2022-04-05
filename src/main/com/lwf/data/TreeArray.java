package com.lwf.data;

/**
 * Created with IntelliJ IDEA.
 * 树状数组，存储使用数组，模拟构建出一颗树的结构，主要用来解决区间求和和连续更新数据的算法问题。
 * tree(i)=A(i-lowbit(i)+1)+A(i-lowbit(i)+2)...+A(i-lowbit(i)+i)
 * tree(i)=i-lowbit(i) ~~i 的元素和
 * @author: liuwenfei14
 * @date: 2022-04-05 19:26
 */
public class TreeArray {
    //tree的index 使用需要从1开始计数，因为需要借助于二进制计算步长和父节点。
    int[] tree;
    int[] nums;
    int n;
    public TreeArray(int[] nums){
        this.nums  =nums;
        this.n=nums.length;
        tree=new int[n+1];
        for (int i = 0; i < nums.length; i++) {
            add(i+1,nums[i]);
        }
    }

    /**
     * index x的父节点步长，也是当前节点包含元素的步长。
     * @param x
     * @return
     */
    private int lowbit(int x){
        return x&(x^(x-1));
    }

    /**
     * 添加和更新tree中的index对应的值的方法。也可以用来构建tree
     * @param index
     * @param val
     */
    private void add(int index,int val){
        for (int i = index; i <= n; i+=lowbit(i)) {
            tree[i]+=val;
        }
    }
    public void update(int index,int val){
        add(index+1,val-nums[index]);
        nums[index]=val;
    }
    public int query(int left,int right){
        return query(right-1)-query(left);
    }

    /**
     * 查询到index 的前缀和，使用lowbit计算出当前index能包含的元素，
     * tree(i)=A(i-lowbit(i)+1)+A(i-lowbit(i)+2)...+A(i-lowbit(i)+i)
     * @param index
     * @return
     */
    private int query(int index){
        int count=0;
        for (int i = index; i > 0; i-=lowbit(i)) {
            count+=tree[i];
        }
        return count;
    }
}
