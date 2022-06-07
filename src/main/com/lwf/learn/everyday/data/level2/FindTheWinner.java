package com.lwf.learn.everyday.data.level2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-07 13:17
 */
public class FindTheWinner {
    /**
     * 约瑟夫环，利用数列 模拟 队列，使用除余来表示环形，每次迭代可以找到下一个要移除的位置。
     */
    class Solution {
        public int findTheWinner(int n, int k) {
            List<Integer> list=new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            int index=0;
            while (list.size()>1){
                index=(k+index-1)%list.size();
                list.remove(index);
            }
            return list.get(0);
        }
    }
    /**
     * 公式推导，假设当前有1个人，进行报数k的游戏，只有一个人则是胜利者，他的index=0，那么假设这个人一直是胜利者，
     * 他在2、3、4、、、n个人时也是胜利者，其实就转变为了这个人的index每轮变换下标，最后变换到了哪里。
     * 设 f(i,k)表示他的坐标，则下一轮他会到 f(i+1,k)= (f(i,k)+k)%(i+1),因此我们可以直接向上变换到n个人。
     * 最后找到的i就是这个人的下标，由于下标是从0开始的，因此最后结果+1即可。
     */
    class Solution1 {
        public int findTheWinner(int n, int k) {
            int i=0;
            for (int j = 0; j < n; j++) {
                i=(i+k)%(j+1); //为什么不-1，因为-1的那个人是被删除掉的
            }
            return i+1;
        }
    }
}
