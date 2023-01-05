package com.lwf.oneLearnOneday.hard;

import com.lwf.data.Trie;

/**
 * @author liuwenfei
 * @date 2023/1/5 9:30
 */
public class CountPairs {
    class Solution {
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
