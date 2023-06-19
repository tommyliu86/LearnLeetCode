package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/6/12 8:45
 */
public class TreeAncestor {

    /**
     * 用树来存储所有的父亲节点，由于每次查找父亲都是单步的，因此会超时，这里需要考虑2**n的算法，实现logn的查找。
     */
    int[][] nodes;

    public TreeAncestor(int n, int[] parent) {
        nodes = new int[n][31];
        //遍历parent，把所有父节点找到并放好，构建出了一颗树[i][0]就是这颗树本身
        for (int i = 0; i < n; i++) {
            nodes[i][0] = parent[i];
        }
        //遍历每个节点中的后续，这些保存的是2**i的节点，跳跃
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 31; j++) {
                nodes[i][j] = nodes[i][j - 1] == -1 ? -1 : nodes[nodes[i][j - 1]][j-1];
            }
        }

    }

    /**
     * 如何表示2**i，是通过每一个父亲节点再查找时，仍然需要查找他的第i位？
     * @param node
     * @param k
     * @return
     */
    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < nodes[0].length; j++) {
            if (((k >> j) & 1) != 0) {
                node = nodes[node][j];
                if (node == -1) {
                    return -1;
                }
            }
        }

        return node;
    }


/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
}


class TreeAncestor1 {
    /**
     * 用树来存储所有的父亲节点，由于每次查找父亲都是单步的，因此会超时，这里需要考虑2**n的算法，实现logn的查找。
     */
    class Node {
        int val;
        Node parent;
        List<Node> children = new ArrayList<>();
    }

    Node[] nodes;

    public TreeAncestor1(int n, int[] parent) {
        nodes = new Node[n];
        Node root = new Node();
        root.val = 0;
        nodes[0] = root;

        for (int i = 1; i < parent.length; i++) {

            Node node = nodes[i];
            if (node == null) {
                node = new Node();
                node.val = i;
                nodes[i] = node;
            }
            int par = parent[i];
            Node parNode = nodes[par];
            if (nodes[par] == null) {
                parNode = new Node();
                parNode.val = par;
                nodes[par] = parNode;

            }
            parNode.children.add(node);
            node.parent = parNode;
        }
    }

    public int getKthAncestor(int node, int k) {
        Node cur = nodes[node];
        while (k > 0 && cur != null) {
            cur = cur.parent;
            k--;
        }
        return cur == null ? -1 : cur.val;
    }


/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
}
