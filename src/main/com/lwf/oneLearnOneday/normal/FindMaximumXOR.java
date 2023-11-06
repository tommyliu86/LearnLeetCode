package com.lwf.oneLearnOneday.normal;

import java.util.Set;

/**
 * @author liuwenfei
 * @date 2022/12/9 9:28
 */
public class FindMaximumXOR {
    /**
     * 421. 数组中两个数的最大异或值
     * https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/?envType=daily-question&envId=2023-10-30
     * 字典树，通过树记录所有的数字的0、1位的情况，然后进行字典树遍历
     */
    class Solution {
        public int findMaximumXOR(int[] nums) {
            Node root=new Node();
            int ans=0;
            for (int i = 0; i < nums.length; i++) {
                ans=Math.max(find(root,nums[i]),ans);
                insert(root,nums[i]);
            }
            return ans;
        }
        class Node{
            Node n0;
            Node n1;
        }
        public int find(Node root,int x){
            if (root.n0==null&&root.n1==null) return 0;
            int ans=0;
            Node cur=root;
            for (int i = 31; i >= 0; i--) {
                int j= (x&(1<<i))>0?1:0;
                if ((j==0&&cur.n1!=null)||(j==1&&cur.n0!=null)){
                   ans|=1<<i;
                    cur=j==0? cur.n1:cur.n0;
                }else{
                    cur=j==0? cur.n0:cur.n1;
                }
            }
            return ans;
        }
        public void insert(Node root,int x){
            Node cur=root;
            for (int i = 31; i >= 0; i--) {
                int j= (x&(1<<i))>0?1:0;
                if (j==0){
                    if (cur.n0==null){
                        cur.n0=new Node();
                    }
                }else{
                    if (cur.n1==null){
                        cur.n1=new Node();
                    }
                }
                cur=j==0? cur.n0:cur.n1;
            }
        }
    }
    class Solution1 {
        public int findMaximumXOR(int[] nums) {
            Set<Integer>[] indexes=new Set[32];
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int j=0;
                while (num!=0){
                    int i1 = num / 2;
                    num>>=1;
                    if (i1==1){
                        indexes[j].add(i);
                    }
                    j++;
                }

            }
            return 0;

        }
    }
}
