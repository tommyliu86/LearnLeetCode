package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-18 09:07
 */
public class LexicalOrder {
    /**
     * 迭代，用一个常数number来进行模拟遍历到的节点的值。通过number ++ 和number *10，number /10来上下层
     */
    class dp {

        public List<Integer> lexicalOrder(int n) {
            List<Integer> list=new ArrayList<>();
            int number=1; //不断迭代number；，通过number计算下一个，因此需要向下*10 向上/10
            for (int i = 0; i < n; i++) { //用于计数。
                list.add(number);
                if (number*10>n){
                    while (number%10==9||number+1>n) { //当前子节点是否已经全部遍历完成到最后 0-9
                        number/=10;
                    }
                    number++;
                }else{
                    number*=10;
                }
            }
            return  list;
        }
    }
    /**
     * 递归，前序遍历模拟进行计算。先添加本节点，然后再添加子节点（0到9）递归即可遍历到所有节点
     */
    class Solution {

        public List<Integer> lexicalOrder(int n) {
            List<Integer> list=new ArrayList<>();
            int level=0;
            int t=n;
            while(t>0){
                t=t/10;
                level++;
            }
            List<Integer> rtn=new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                rtn.addAll(dfs(n,level,i,1));
            }
            return rtn;
        }

        private List<Integer> dfs(int n ,int level,int curr,int curL){
            if (curL>level){
                return Collections.emptyList();
            }
            boolean need=false;
            if (curL==level){
                need=true;
            }
            List<Integer> rtn=new ArrayList<>();
            if (!need){
                rtn.add(curr);
                for (int i = 0; i < 10; i++) {
                    rtn.addAll(dfs(n,level,curr*10+i, curL+1));
                }
            }else{
                if (curr<=n){
                    rtn.add(curr);
                }
            }
            return rtn;
        }
    }
}
