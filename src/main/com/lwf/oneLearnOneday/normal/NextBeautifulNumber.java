package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 2048. 下一个更大的数值平衡数
 */
public class NextBeautifulNumber {
    class Solution1 {
        public int nextBeautifulNumber(int n) {
          recurse(1,new ArrayList<>(),7,0);
            bs.sort(Integer::compareTo);
           return halfSearch(n);
        }

        private int halfSearch(int n) {
            int i=0,j=bs.size();
            while (i<j){
                int m=i+(j-i)/2;
                if (bs.get(m)<=n){
                    i=m+1;
                }else{
                    j=m;
                }
            }

            return i;
        }


        List<Integer> bs=new ArrayList<>();
        /**
         *
         * 回溯把所有的都拼接出来，生产出所有的数来
         * 从1开始，到9，数据长度最大是7，因此，使用这个
         */
        public void recurse(int i,List<Integer> list,int max,int sum){
            if (i>=max||sum>=max||sum+i>max){
                build(list,sum);
                return;
            }

            list.add(i);
            recurse(i+1,list,max,sum+i);
            list.remove(list.size()-1);
            recurse(i+1,list,max,sum);

        }
        public void build(List<Integer> list,int l){
            int[] count=new int[10];
            for (Integer i : list) {
                count[i]=i;
            }
            int[] q=new int[l];
            recurse(q,0,list,count);

        }
        public void recurse(int[] q,int i, List<Integer> list,int[] count){
            if (i==q.length){
                int a=0;
                int gap=1;
                for (int i1 = 0; i1 < q.length; i1++) {
                    a+=gap*q[i1];
                    gap*=10;
                }
                bs.add(a);
                return ;
            }
            for (int i1 = 0; i1 < list.size(); i1++) {
                Integer cur = list.get(i1);
                if (count[cur]==0){
                    continue;
                }
                q[i]=cur;
                count[cur]--;
                recurse(q,i+1,list,count);
                count[cur]++;
            }
        }
    }

    /**
     * 暴力求解
     */
    class Solution {
        public int nextBeautifulNumber(int n) {
            for (int i = n+1; i < 2000_000; i++) {
                if (isOk(i)){
                    return i;
                }
            }
            return 0;
        }
        public boolean isOk(int i){
            int[] count=new int[10];
            while (i!=0){
                int i1 = i % 10;
                count[i1]++;
                i/=10;
            }
            for (int j = 0; j < count.length; j++) {
                if (count[j]!=j&&(j==0||count[j]!=0)) {
                    return false;
                }
            }
            return true;
        }

    }
}
