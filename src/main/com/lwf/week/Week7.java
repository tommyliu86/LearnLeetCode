package com.lwf.week;

import com.lwf.learn.everyday.data.level2.RightSideView;
import com.lwf.oneLearnOneday.easy.HeightChecker;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2022/10/30 11:00
 */
public class Week7 {
    /**
     * 1.dfs预处理获取高度，
     * 2.bfs 找关键路径并记录关键路径的map，
     * 3.使用关键路径map，如果点在map中，则使用该值，否则直接等于最大max
     */
    class Solution {
        Map<Integer,Integer> height=new HashMap<>();
        Map<Integer,Integer> keyMap=new HashMap<>();
        int max=0;
        public int[] treeQueries(TreeNode root, int[] queries) {
            max=  dfs(root);
            bfs(root);
            int[] ans=new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                if (keyMap.containsKey(queries[i])){
                    ans[i]=keyMap.get(queries[i])-1;
                }else {
                    ans[i]=max-1;
                }
            }
            return ans;
        }

        public void bfs(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            int d = max;
            queue.add(root);
            int otherMax=0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<TreeNode> key=new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (height.get(poll.val)==d){
                        key.add(poll);
                        otherMax=Math.max(otherMax,max-d);
                    }else{
                        otherMax=Math.max(otherMax,max-d+ height.get(poll.val));
                    }
                }
               if (key.size()>1){
                    return;
               }else{
                   TreeNode treeNode = key.get(0);
                   keyMap.put(treeNode.val,otherMax==0?max-d:otherMax);
                   if (treeNode.left!=null){
                       queue.offer(treeNode.left);
                   }
                   if (treeNode.right!=null){
                       queue.offer(treeNode.right);
                   }
               }
                d--;
            }

        }
        public int dfs(TreeNode node) {
            int ans=0;
            if (node==null){
                return 0;
            }else{

                ans= 1+Math.max(dfs(node.left),dfs(node.right));
            }
            height.put(node.val,ans);
            return ans;
        }
    }
    /**
     * 预处理获取高度，再进行广度遍历仍然超时
     */
    class Solution6 {
        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        public int[] treeQueries(TreeNode root, int[] queries) {
            max=  dfs(root);
            int[] ans=new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                ans[i]=bfs(root,queries[i]);
            }
            return ans;
        }
        public int bfs(TreeNode root, int k) {
            Queue<TreeNode> queue = new LinkedList<>();
            int d = 0;
            queue.add(root);
            boolean getK=false;
            while (!queue.isEmpty()) {
                int size = queue.size();
                if (getK){
                    int thisMax=0;
                    for (int i = 0; i < size; i++) {
                        TreeNode poll = queue.poll();
                        thisMax=Math.max(thisMax, map.get(poll.val)-1);
                    }
                    return thisMax+d;
                }
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();

                    if (poll.left != null ) {
                        if (poll.left.val==k){
                            getK=true;
                        }else{
                            queue.offer(poll.left);
                        }
                    }
                    if (poll.right != null ) {
                        if (poll.right.val==k){
                            getK=true;
                        }else{
                            queue.offer(poll.right);
                        }
                    }

                }
                d++;
            }
            return d - 1;
        }
        public int dfs(TreeNode node) {
            int ans=0;
            if (node==null){
                return 0;
            }else{

                ans= 1+Math.max(dfs(node.left),dfs(node.right));
            }
            map.put(node.val,ans);
            return ans;
        }
    }

    /**
     * 直接暴力深度遍历，超时
     */
    class Solution5 {
        public int[] treeQueries(TreeNode root, int[] queries) {
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                ans[i] = dfs(root, queries[i])-1;
            }
            return ans;
        }

        public int dfs(TreeNode root, int k) {
            int left = 0;
            int right = 0;
            if (root.left != null && root.left.val != k) {
                left = dfs(root.left, k);
            }
            if (root.right != null && root.right.val != k) {
                right = dfs(root.right, k);
            }
            return 1 + Math.max(left, right);
        }
    }

    /**
     * 广度遍历，超时
     */
    class Solution4 {
        public int[] treeQueries(TreeNode root, int[] queries) {
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                ans[i] = depth(root, queries[i]);
            }
            return ans;
        }

        public int depth(TreeNode root, int k) {
            Queue<TreeNode> queue = new LinkedList<>();
            int d = 0;
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();

                    if (poll.left != null && poll.left.val != k) {
                        queue.offer(poll.left);

                    }
                    if (poll.right != null && poll.right.val != k) {
                        queue.offer(poll.right);
                    }

                }
                d++;
            }
            return d - 1;
        }
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
    class Solution3 {
        public long makeIntegerBeautiful(long n, int target) {
            List<Integer> list = new ArrayList<>();
            long k = n;
            int sum = 0;
            while (k > 0) {
                int l = (int) (k % 10);
                list.add(l);
                sum += l;
                k /= 10;
            }
            if (sum <= target) {
                return 0;
            }
            List<Integer> anss = new ArrayList<>();
            int gap = 0;
            for (int i = 0; i < list.size(); i++) {
                Integer cur = list.get(i) + gap;
                gap = 1;
                anss.add(10 - cur);
                sum = sum - cur + 1;
                if (sum <= target) {
                    break;
                }
            }
            Collections.reverse(anss);
            long ans = 0;
            for (int i = 0; i < anss.size(); i++) {
                Integer integer = anss.get(i);
                ans = ans * 10 + integer;
            }
            return ans;
        }
    }

    class Solution2 {
        public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {

            Map<String, List<Integer>> indexes = new HashMap<>();
            Map<String, Long> sums = new HashMap<>();
            long max = 0;
            for (int i = 0; i < creators.length; i++) {
                String creator = creators[i];
                sums.put(creator, sums.getOrDefault(creator, 0L) + views[i]);
                List<Integer> orDefault = indexes.getOrDefault(creator, new ArrayList<>());
                orDefault.add(i);
                indexes.put(creator, orDefault);
                max = Math.max(max, sums.get(creator));
            }
            List<List<String>> ans = new ArrayList<>();
            for (Map.Entry<String, Long> entry : sums.entrySet()) {
                if (entry.getValue() == max) {
                    List<String> list = new ArrayList<>();
                    list.add(entry.getKey());
                    List<Integer> integers = indexes.get(entry.getKey());
                    if (integers.size() == 1) {
                        list.add(ids[integers.get(0)]);
                    } else {
                        List<String> idd = new ArrayList<>();
                        int maxx = 0;
                        for (int i = 0; i < integers.size(); i++) {
                            if (views[integers.get(i)] > maxx) {
                                idd.clear();
                                idd.add(ids[integers.get(i)]);
                                maxx = views[integers.get(i)];
                            } else if (views[integers.get(i)] == maxx) {
                                idd.add(ids[integers.get(i)]);
                            }
                        }
                        idd.sort(String::compareTo);
                        list.add(idd.get(0));
                    }
                    ans.add(list);
                }
            }
            return ans;
        }
    }

    class Solution1 {
        public int averageValue(int[] nums) {
            int sum = 0;
            int n = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & 1) == 0 && nums[i] % 3 == 0) {
                    sum += nums[i];
                    n++;
                }
            }
            return n == 0 ? 0 : (sum / n);
        }
    }
}
