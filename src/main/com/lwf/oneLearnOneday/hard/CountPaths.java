package com.lwf.oneLearnOneday.hard;

import java.util.*;

/**
 * 2867. 统计树中的合法路径数目
 *
 * @author: liuwenfei
 * @date: 2024/2/27-8:50
 */
public class CountPaths {
    class Solution {
        private final static int MX = (int) 1e5;
        private final static boolean[] numbers = new boolean[MX + 1]; // 质数=false 非质数=true

        static {
            numbers[1] = true;
            for (int i = 2; i * i <= MX; i++) {
                //如果是质数，质数的倍数都是非质数
                if (!numbers[i]) {
                    for (int j = i * i; j <= MX; j += i) {
                        numbers[j] = true;
                    }
                }
            }
        }



        public long countPaths(int n, int[][] edges) {
            //树的节点
            List<Integer>[] map = new List[n + 1];
            for (int i = 0; i < map.length; i++) {
                map[i] = new ArrayList<>();
            }
            int[] mems = new int[n + 1];

            for (int[] edge : edges) {
                map[edge[0]].add(edge[1]);
                map[edge[1]].add(edge[0]);
            }
            long ans = 0;
            //遍历每个质数节点，然后找到质数节点周围的所有的子树集合的节点数量。
            for (int i = 1; i < n+1; i++) {
                if (numbers[i])
                    continue;
                //当前质数点
                Integer cur = i;
                //周围的子树
                List<Integer> subTrees = map[cur];
                List<Integer> counts = new ArrayList<>();
                for (int i1 = 0; i1 < subTrees.size(); i1++) {

                    int mem = mems[subTrees.get(i1)];
                    if (mem > 0) {
                        counts.add(mem);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        dfs(subTrees.get(i1), cur, list, map);
                        for (Integer integer : list) {
                            mems[integer] = list.size();
                        }
                        counts.add(list.size());
                    }
                }
                //子树的连通组合出所有的组合路径
                long count = 0;
                for (int j = 0; j < counts.size(); j++) {
                    ans += counts.get(j);
                    ans += (long)counts.get(j) * count;
                    count += counts.get(j);
                }
            }
            return ans;

        }

        //使用nodes记录遍历到的所有的非质数节点，这样就可以找到所有的当前连通块的连通节点数
        public void dfs(Integer node, Integer parent, List<Integer> nodes, List<Integer>[] map) {
            if (!numbers[node])
                return;

            nodes.add(node);
            List<Integer> subTrees = map[node];
            for (Integer subTree : subTrees) {
                if (!parent.equals(subTree) && numbers[subTree])
                    dfs(subTree, node, nodes, map);
            }
        }

    }

    class Solution1 {
        List<Integer> numbers = new ArrayList<>();
        //树的节点
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] mems = new int[1000_001];

        public long countPaths(int n, int[][] edges) {

            //质数
            numbers = primes(n + 1);
            for (int[] edge : edges) {
                map.computeIfAbsent(edge[0], ArrayList::new).add(edge[1]);
                map.computeIfAbsent(edge[1], ArrayList::new).add(edge[0]);
            }
            int ans = 0;
            //遍历每个质数节点，然后找到质数节点周围的所有的子树集合的节点数量。
            for (int i = 0; i < numbers.size(); i++) {
                if (!map.containsKey(numbers.get(i)))
                    continue;
                //当前质数点
                Integer cur = numbers.get(i);
                //周围的子树
                List<Integer> subTrees = map.get(cur);
                List<Integer> counts = new ArrayList<>();
                for (int i1 = 0; i1 < subTrees.size(); i1++) {

                    int mem = mems[subTrees.get(i1)];
                    if (mem > 0) {
                        counts.add(mem);
                    } else {
                        ArrayList<Integer> list = new ArrayList<>();
                        dfs(subTrees.get(i1), cur, list);
                        for (Integer integer : list) {
                            mems[integer] = list.size();
                        }
                        counts.add(list.size());
                    }
                }
                //子树的连通组合出所有的组合路径
                int count = 0;
                for (int j = 0; j < counts.size(); j++) {
                    ans += counts.get(j);
                    ans += counts.get(j) * count;
                    count += counts.get(j);
                }
            }
            return ans;

        }

        //使用nodes记录遍历到的所有的非质数节点，这样就可以找到所有的当前连通块的连通节点数
        public void dfs(Integer node, Integer parent, List<Integer> nodes) {
            if (numbers.contains(node))
                return;

            nodes.add(node);
            List<Integer> subTrees = map.get(node);
            for (Integer subTree : subTrees) {
                if (!parent.equals(subTree) && !numbers.contains(subTree))
                    dfs(subTree, node, nodes);
            }
        }

        //使用额外map进行记忆化，会导致内存过大，这里直接使用另外一种方法，就是记录非质数连通块的大小，如果进入到这个块中的任意一个点，则表示可以获取到这个的大小，
        //因为我们肯定是从质数开始找的连通块
        Map<Integer, Integer> maps = new HashMap<>();

        public int dfs(Integer node, Integer parent) {
            int key = parent * 1000_000 + node;
            if (maps.containsKey(key))
                return maps.get(key);
            int count = 0;
            if (!numbers.contains(node)) {

                count++;
                List<Integer> subTrees = map.get(node);
                for (int i = 0; i < subTrees.size(); i++) {
                    Integer sub = subTrees.get(i);
                    if (sub.equals(parent)) {
                        continue;
                    }
                    count += dfs(sub, node);
                }
            }
            maps.put(key, count);
            return count;
        }

        /**
         * 求解小于n的所有的质数的数量
         *
         * @param n
         * @return
         */
        public List<Integer> primes(int n) {
            int[] mark = new int[n];
            List<Integer> ans = new ArrayList<>();
            for (int i = 2; i < mark.length; i++) {
                if (mark[i] == 0) {
                    ans.add(i);
                    mark[i] = 1;
                    for (int j = 2; j * i < n; j++) {
                        mark[j * i] = 1;
                    }
                }
            }
            return ans;
        }

        /**
         * 求解小于n的所有的质数的数量
         *
         * @param n
         * @return
         */
        public int countPrimes(int n) {
            int[] mark = new int[n];
            int ans = 0;
            for (int i = 2; i < mark.length; i++) {
                if (mark[i] == 0) {
                    ans++;
                    mark[i] = 1;
                    for (int j = 2; j * i < n; j++) {
                        mark[j * i] = 1;
                    }
                }
            }
            return ans;
        }
    }
}
