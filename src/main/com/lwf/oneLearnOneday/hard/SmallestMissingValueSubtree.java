package com.lwf.oneLearnOneday.hard;

import java.util.*;

/**
 * 2003.每棵子树内缺失的最小基因值
 * https://leetcode.cn/problems/smallest-missing-genetic-value-in-each-subtree/?envType=daily-question&envId=2023-10-31
 * @author liuwenfei
 * @date 2023/10/31 8:45
 */
public class SmallestMissingValueSubtree {
    /**
     * 灵神解题思路，分成两种情况，从节点基因值是1的节点出发，分成两种，一种是不包含1的树，这这些节点不需要找最小值，最小值==1，
     * 第二种是包含1节点的树，这类数，需要遍历时记录数中的基因集合，每个节点都找到节点包含的基因集合，就可以找到其中的最小值
     * https://leetcode.cn/problems/smallest-missing-genetic-value-in-each-subtree/solutions/2505883/tu-jie-yi-zhang-tu-miao-dong-duo-chong-x-q095/?envType=daily-question&envId=2023-10-31
     */
    class Solution {
        public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
            int n = parents.length;
            int[] ans =new int[n];
            //直接初始化所有的节点最小==1，这样，从基因==1出发找的所有父节点需要计算最小基因，其他的就是1
            Arrays.fill(ans,1);
            //找到基因1的节点下标
            int node=-1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==1) {
                    node=i;
                    break;
                }
            }
            //没有找到 ==1的节点，则所有的都是1
            if (node==-1)
                return ans;

            //从node开始，构建所有的父系节点，同时记录父系节点的基因集合,由于从下向上找父节点，而父节点的另一个子树的情况需要从上向下，因此我们需要构建树的子节点信息
            List<Integer>[] nodes=new List[n];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i]=new ArrayList<>();
            }
            for (int i = 0; i < parents.length; i++) {
                if (parents[i]!=-1) {
                    nodes[parents[i]].add(i);
                }
            }
            Set<Integer> gens=new HashSet<>();
            int min=2;
            while (node!=-1){
                dfs(node,nodes,gens,nums);
                while (gens.contains(min)) {
                    min++;
                }
                ans[node]=min;
                node=parents[node];
            }
            return ans;
        }

        private void dfs(int node, List<Integer>[] nodes, Set<Integer> gens, int[] nums) {
            gens.add(nums[node]);
            for (Integer integer : nodes[node]) {
                if (!gens.contains( nums[integer])){
                    dfs(integer,nodes,gens,nums);
                }
            }
        }
    }
}
