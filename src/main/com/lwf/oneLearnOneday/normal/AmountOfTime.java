package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * @author: liuwenfei
 * @date: 2024/4/24-8:56
 */
public class AmountOfTime {
    public static void main(String[] args) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        map.compute(1,(k,v)->(v==null?new ArrayList<Integer>():v)).add(2);
        map.compute(1,(k,v)->(v==null?new ArrayList<Integer>():v)).add(3);
        System.out.println(map.toString());
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 深度优先遍历，记录左数深度，右树深度，同时记录start所在的深度，然后进行计算即可
     * 直接深度优先遍历找左右树高度再进行求解不可行！
     * 解法1：dfs遍历树，构建出图，然后进行dfs找到最大深度,使用方法的递归，会导致超时，改为while迭代，则可以减少时间
     */
    class Solution {

        public int amountOfTime(TreeNode root, int start) {
            Map<Integer, List<Integer>> map=new HashMap<>();
            dfs(root,map);

            int max=-1;
            Queue<Integer> queue=new LinkedList<>();
            Set<Integer> set=new HashSet<>();

            queue.add(start);
            while (!queue.isEmpty()){
                max++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = queue.poll();
                    if (set.contains(poll)){
                        continue;
                    }
                    set.add(poll);
                    List<Integer> integers = map.get(poll);
                    if (integers!=null){
                        for (Integer integer : integers) {
                            if (!set.contains(integer)) {
                                queue.add(integer);
                            }
                        }
                    }

                }
            }

           return max;
        }

        private int dept(Map<Integer, List<Integer>> map,List<Integer> ll, Integer i,int dep) {
            List<Integer> sub = map.get(i);
            if (sub==null){
                return dep;
            }
            ll.add(i);
            int max=dep;
            for (Integer j : sub) {
                if (ll.contains(j)){
                    continue;
                }
                max=Math.max(max,dept(map,ll,j,dep+1));
            }
            ll.remove(ll.size()-1);
            return max;
        }

        private void dfs(TreeNode node, Map<Integer, List<Integer>> map) {
            if (node==null) {
                return;
            }
            if (node.left!=null){
                map.compute(node.val,(k,v)->(v==null?new ArrayList<Integer>():v)).add(node.left.val);
                map.compute(node.left.val,(k,v)->(v==null?new ArrayList<Integer>():v)).add(node.val);
                dfs(node.left,map);
            }
            if (node.right!=null){
                map.compute(node.val,(k,v)->(v==null?new ArrayList<Integer>():v)).add(node.right.val);
                map.compute(node.right.val,(k,v)->(v==null?new ArrayList<Integer>():v)).add(node.val);
                dfs(node.right,map);
            }
        }

    }
}
