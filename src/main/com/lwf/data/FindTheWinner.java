package com.lwf.data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-04 11:16
 */
public class FindTheWinner {
    /**
     *问题描述：n个人（编号0~(n-1）），从0开始报数，报到（m-1）的退出，剩下的人继续从0开始报数。求胜利者的编号。
     * 我们知道第一个人（编号一定是（m-1）mod n) 出列之后，剩下的n-1个人组成了一个新的约瑟夫环（以编号为k=m mod n的人开始）：
     * k k+1 k+2 ... n-2,n-1,0,1,2,... k-2
     * 并且从k开始报0。
     * 我们把他们的编号做一下转换：
     * k --> 0
     * k+1 --> 1
     * k+2 --> 2
     * ...
     * ...
     * k-2 --> n-2
     * 变换后就完完全全成为了（n-1）个人报数的子问题，假如我们知道这个子问题的解：
     * 例如x是最终的胜利者，那么根据上面这个表把这个x变回去不刚好就是n个人情况的解吗。
     * 变回去的公式很简单，相信大家都可以推出来：x'=(x+k) mod n
     */
    class Solution {
        public int findTheWinner(int n, int k) {
            if(n==1){
                return 1;
            }
            return (findTheWinner(n-1,k)+k-1)%n+1;
        }
    }
}
