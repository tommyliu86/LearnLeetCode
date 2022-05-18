package com.lwf.oneLearnOneday.normal;


/**
 * author Administrator
 * time 2019-10-28-23:19
 */
public class NumTrees {
    public int numTrees(int n) {
        int[] sums=new int[n+1];
        sums[0]=1;
        sums[1]=1;
//        sums[2]=2; //n=1时的outofrange
        //二叉搜索数是按照顺序排列节点的，因此，假设一个数节点数量为x，不论节点值是什么，该子数的组合数是一样的。
        //因此，n个节点，相当于从前向后遍历一遍，每次选择一个i做根节点，两边分隔成了两部分数量，分别是左子数和右子树的数量，他们的组合数f（i-1），f（n-i）
        //两边的子树的组合的乘积就是当前的可能性。这时就变成了一个递推求解过程。
        for (int i = 2; i <n+1 ; i++) { //总节点数，从2开始，进行逐步计算
            for (int j = 1; j <i+1 ; j++) { //跟节点的下标，根节点每次选择后，左右子树的节点数量是已经计算过的，可以直接用
                sums[i]+=sums[j-1]*sums[i-j];
            }
        }
        return sums[n];
    }
}
