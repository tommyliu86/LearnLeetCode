package com.lwf.TOP100.normal;

/**
 * Created with IntelliJ IDEA.
 * https://leetcode-cn.com/problems/number-of-provinces/
 * 547. 省份数量
 *
 * @author: liuwenfei14
 * @date: 2022-03-21 10:06
 */
public class FindCircleNum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ins=new int[][]{new int[]{1,0,0,1},new int[]{0,1,1,0},new int[]{0,1,1,1},new int[]{1,0,1,1}};
        int circleNum = solution.findCircleNum(ins);
        System.out.println(circleNum);
    }

    /**
     * 图的深度遍历方法。通用做法
     * 1.使用一个额外数组来保存节点是否遍历过了
     * 2.对顶点数组进行一次遍历
     * 3.每个顶点，对和其相连顶点进行深度向下遍历，一次找到所有相连顶点。构成一个图
     * 4.在遍历过程中注意统计遍历到的节点个数做边界终止条件即可。
     */
    static class Solution {
        Integer markCount=0;
        public int findCircleNum(int[][] isConnected) {
            boolean [] mark=new boolean[isConnected.length];
            int num=0;


            for (int i = 0; i < isConnected.length&&markCount<=isConnected.length; i++) {
                if (mark[i]){
                    continue;
                }
                dfs(isConnected,i,mark);
                num++;
            }
            return num;
        }
        private void dfs(int[][] isConnected,int curIndex,boolean[] mark){
            mark[curIndex]=true;
            markCount++;
            for (int j = 0; j < isConnected.length&&markCount<=isConnected.length; j++) {
                if (mark[j]){
                    continue;
                }
                if (isConnected[curIndex][j]==1){

                    dfs(isConnected,j, mark);
                }
            }
        }
    }
}
