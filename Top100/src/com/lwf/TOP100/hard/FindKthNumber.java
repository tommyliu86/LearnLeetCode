package com.lwf.TOP100.hard;

/**
 * Created with IntelliJ IDEA.
 *https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/
 * 440. 字典序的第K小数字
 * @author: liuwenfei14
 * @date: 2022-03-23 09:43
 */
public class FindKthNumber {
    /**
     * 解题：
     * 1.字典序： 若两个数字位数相同则判断大小。若位数不相同则需要根据位数短的长度来先判断，比较相同位数长度的大小，谁小谁在前面
     * 2.给定数字 k,j  若  k.length==j.length 则 比较k，j大小，否则 比较相同位数的大小，f(k)==f(j) 则谁长谁靠后，否则谁大谁靠后
     *
     * 1.典型的字典序列其实是把数字当做字符串构建为字段序列的树。从上到下的层分别是字符串位置可能的字符。
     * 2.由于层高表示的是字符串长度，因此如果层高没有和n的位数相等，这一层肯定是可以铺满的（位数比n小的数字肯定比n小，则肯定会出现），因此最好的方法是层序遍历。
     *
     * 题目要求判断 n个数中给定 的第k小的数字，因此需要
     */
  static   class Solution {
        public int findKthNumber(int n, int k) {
            String s = String.valueOf(n);
            int depth = s.length();
            int[] count=new int[9];
            int first = Integer.valueOf( String.valueOf( s.charAt(0)));
            int countForTree1 = countForTree(depth , 10);
            int countForTree2 = countForTree(depth - 1, 10);
            for (int i = 0; i < first-1; i++) {
                count[i]=countForTree1;
            }
            for (int i = first-1; i < count.length; i++) {
                count[i]=countForTree2;
            }
            count[first-1]+=n-first*Math.pow(10,depth);


            return 0;
        }

        private int countForTree(int depth,int nodeSize){
            int rtn=0;
            while (depth>=0){
                rtn+=Math.pow(nodeSize,--depth);
            }
            return rtn;
        }

        public static void main(String[] args) {
            new Solution().findKthNumber1(10,3);
        }
        /**
         * 层序遍历，记录当前遍历了多少个节点 count 当count=k时的当前节点值就是要查找的。
         * 遍历时的节点值是字典序树从上到下的每个层（层高depth）顺序节点（i）的值，curr=i*math.pow(10,depth-1)++。
         * @param n
         * @param k
         * @return
         */
        public int findKthNumber1(int n, int k) {
            int curNumber=1;
            int count=1;
            while (count<k){ //count 是已经遍历过的节点
                int curCount =count(curNumber,n); //获取到当前前缀下的节点数量
                if (curCount<=k-count){ //如果当前节点数量没有超过剩余要走的，则加到已走过的节点数量，并且当前前缀值++去找下一个前缀
                    count+=curCount;
                    curNumber++;
                }else{ //当前前缀值下的步数超过了剩余，则进入当前前缀下层去找节点
                    curNumber*=10;
                    count++;
                }
            }
            return curNumber;
        }

        private int count(int prefix,int n){
            int count=0;
            long levelFirst=prefix; //10的9次方，再乘10会越界。
            long levelLast=prefix;
            while(levelFirst<=n){
                count+= (levelLast>n?n:levelLast)-levelFirst+1; //每一层的节点个数，当层高小于n.length的时候，每一层都可以铺满。
                levelFirst*=10; //下一层的第一个是 0
                levelLast=levelLast*10+9; //下一层的最后一个是上一层最后一个的下一层+9
            }
            return count;
        }
    }
}
