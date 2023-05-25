package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/5/24 8:49
 */
public class FrogPosition {

    class Solution {
        double scores=0;
        public double frogPosition(int n, int[][] edges, int t, int target) {
            Node[] nodes = new Node[n];
            for (int i = 0; i < nodes.length; i++) {
                Node node = new Node();
                node.val=i+1;
                nodes[i]=node;
            }
            buildNode(nodes, edges);

            int[] marks = new int[n];
            marks[0]=1;

            //target无法出去+t==0时恰好在target
            dfs(nodes[0],marks,target,t);
            return scores;
        }
        public void dfs(Node node,int[] marks,int target,int t){
            List<Node> children = node.children;

            int next=0;
            for (int i = 0; i < children.size(); i++) {
                Node cur = children.get(i);
                if (marks[cur.val-1]==0) {
                    next++;
                }
            }
            if (next==0||t==0) {
                if (node.val==target){
                    scores+= (double)1/marks[target-1];
                }
                return;
            }
            next*=marks[node.val-1];
            for (int i = 0; i < children.size(); i++) {
                Node cur = children.get(i);
                if (marks[cur.val-1]==0) {
                   marks[cur.val-1]=next;
                   dfs(cur,marks,target,t-1);
                   marks[cur.val-1]=0;
                }
            }
        }

        private void buildNode(Node[] nodes, int[][] edges) {
            for (int[] edge : edges) {
                int i1 = edge[0];
                int i2 = edge[1];
                nodes[i1 - 1].children.add(nodes[i2 - 1]);
                nodes[i2 - 1].children.add(nodes[i1 - 1]);
            }
        }

        public class Node {
            int val;
            List<Node> children=new ArrayList<>();
        }
    }
}
