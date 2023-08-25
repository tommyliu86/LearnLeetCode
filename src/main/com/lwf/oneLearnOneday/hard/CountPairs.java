package com.lwf.oneLearnOneday.hard;

import com.lwf.data.Trie;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/1/5 9:30
 */
public class CountPairs {
    /**
     * 二分查找
     * 1.遍历获取到每个点的边数
     * 2.排序后，每个query，可以
     *      1. 从最小开始遍历，每个i，二分查找 query-i 的下标
     *      2.大于query的i，后面的直接进行阶乘计算
     *
     * 3.排序后，使用双指针
     *      1.双指针遍历，每次考虑的也是单点，不需要二分查找，代码更简单
     */
    class Solution {
        public int[] countPairs(int n, int[][] edges, int[] queries) {
            int[] counts=new int[n+1];
            Map<Integer,Integer> edgMap=new HashMap<>();

            for (int i = 0; i < edges.length; i++) {
                for (int i1 : edges[i]) {
                    counts[i1]++;
                }
               int x= Math.min(edges[i][0],edges[i][1]);
               int y= Math.max(edges[i][0],edges[i][1]);
               //merge== ++
                edgMap.merge(x<<16|y,1,Integer::sum);
            }
            int[] origC = Arrays.copyOf(counts, counts.length);
            Arrays.sort(counts);
            int[] ans=new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int query = queries[i];
                int x=1,y=n;
                while (x<y){
                    if (counts[x]+counts[y]>query){
                        ans[i]+=y-x;
                        y--;
                    }else{
                        x++;
                    }
                }
                //计算重复边的情况,我们的ans记录的是数对数量，因此如果边不满足情况，则需要减去这个数对
                for (Map.Entry<Integer, Integer> entry : edgMap.entrySet()) {
                    Integer k = entry.getKey();
                    Integer v = entry.getValue();
                    int count = origC[k >> 16] + origC[k & ((int) Math.pow(2, 16) - 1)];
                    if (count > query && count - v <= query) {
                        ans[i]--;
                    }
                }

            }
            return ans;
        }
    }
    /**
     * 字典树 01字典树
     */
    class Solution1 {
        class BitTrie{
            BitTrie[] children=new BitTrie[2];
            /**
             * 记录当前二进制位数上有多少个为1的数量，
             */
            private  int count;

            /**
             * 插入元素，构建0-1字典数
             * @return
             */
            public void insert(int x){
                BitTrie node=this;
                /**
                 * 设置的i的最大值，是数字的最大二进制位数，这样构建的是以二进制最长位数为高度的字典树，每个位的节点上保存
                 */
                for (int i=15;i>=0;i--){
                    int b=(x>>i )&1;
                    if (node.children[b]==null){
                        node.children[b]=new BitTrie();
                    }
                    node= node.children[b];
                    node.count++;
                }
            }
            /**
             * 使用输入得x，进行数据匹配的搜索，获取字典树匹配之后的要查询的数据
             * @return
             */
            public int search(int x,int limit){
                BitTrie node=this;
                int ans=0;
                for (int i=15;node!=null&& i>=0;i--){
                    int b=(x>>i )&1;
                    //当前位是1，则判断 与x 异或==0的就是小于limit的数量
                    if (((limit>>i)&1)==1){
                        //相等的异或=0，肯定小于limit
                        if (node.children[b]!=null) {
                            ans+=node.children[b].count;
                        }
                        //当前位==b的已经加入到ans中了，因此，继续检查 当前wei！=b的，也就是异或之后==limit的当前位的数据
                        node=node.children[b^1];

                    }else{
                        //limit位==0，则node必须匹配 也是b的节点，也就是前缀路径和limit相同的，继续检查后续数据
                        node=node.children[b];
                    }
                }
                return ans;
            }
        }
        public int countPairs(int[] nums, int low, int high) {
            BitTrie bitTrie = new BitTrie();
            int ans=0;
            for (int i = 0; i < nums.length; i++) {
                ans+=bitTrie.search(nums[i],high+1)-bitTrie.search(nums[i],low);
                bitTrie.insert(nums[i]);
            }
            return ans;
        }
    }
}
