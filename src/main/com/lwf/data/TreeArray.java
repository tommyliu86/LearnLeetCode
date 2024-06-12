package com.lwf.data;

/**
 * 灵神的树状数组的题解
 * https://leetcode.cn/problems/range-sum-query-mutable/solutions/2524481/dai-ni-fa-ming-shu-zhuang-shu-zu-fu-shu-lyfll/?envType=daily-question&envId=2023-11-01
 * Created with IntelliJ IDEA.
 * 树状数组，存储使用数组，模拟构建出一颗树的结构，主要用来解决区间求和和连续更新数据的算法问题。
 * 把整个数组按照二进制的位数进行分隔，通过这样的分隔，可以使用某一段某一段的值，通过加减法来实现所有区间【i,j】的和的计算
 *
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
     * 位运算，找到最近的一个高位的二进制，，比如 101000 -》100111 -》 1111 -》1000
     * @param x
     * @return
     */
    private int lowbit(int x){
        return x&(x^(x-1));
    }

    public static void main(String[] args) {
        //1.找最低位的元素。也就是二进制表示中从低到高依次找到每个位置
        //lowbit ,
        // 1.通过i&-i 直接找到最低位元素，因为 -i 使用的是二进制补码表示，是把所有的位都取反，然后+1得到。
        //  这时，除了最低位的元素到末尾与i相同，其他位都不同
        // 2.通过 i&(i^(i-1)), i^(i-1),可以直接获取到最低位的元素往后都是1的一个数字，这个数从最低位元素开始，往后都是1，比如 1000^(1000 -1)=1111
        // 因此，通过这个计算，可以获取到最低位的lowbit
        int i=9;
        while (i>0){
            System.out.println(i&-i);
            System.out.println(i&(i^( i-1)));
            i&=i-1;
        }

        //i&（i-1）可以逐个位置去除最低位的lowbit

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
        //树状数组使用的是从1开始的下标，因此这里的index需要+1，直接更新对应节点的值，通过add，可以从底向上直接到最后的节点
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
