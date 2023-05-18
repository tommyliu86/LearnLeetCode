package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/5/18 9:05
 */
public class AddNegabinary {
    /**
     * 模拟进位，注意进位之后用原数据- 去进位，获取到的再进行 -值处理即可
     */
    class Solution {
        public int[] addNegabinary(int[] arr1, int[] arr2) {
            int l1 = arr1.length;
            int l2 = arr2.length;
            int[] counts=new int[Math.max(l1,l2)];
            int i = 0;
            while (i < l1 || i < l2) {
                int i1 = l1 - i - 1 >= 0 ? arr1[l1 - i - 1] : 0;
                int i2 = l2 - i - 1 >= 0 ? arr2[l2 - i - 1] : 0;
                counts[i++]=i1+i2;
            }
            List<Integer> list=new ArrayList<>();
            int next=0;
            for (int j = 0; j < counts.length; j++) {
                //当前 c=递进过来的+当前的 ,next表示从前一位变过来了多少个，这个 进位i =（i+2）+（i+1）
                int count = counts[j]-next;
                if (count<0){
                    list.add(1);
                    next=-1;
                }else{
                    list.add( count%2);
                    next=count/2;
                }
            }
            if (next==-1){
                list.add(1);
            }else if (next==1){
                list.add(1);
                list.add(1);
            }
            boolean first=true;
            for (int i1 = list.size() - 1; first&& i1 >= 0; i1--) {
                if (first&&list.get(i1)==0){
                    list.remove(i1);
                }else{
                    first=false;
                }
            }
            if (list.size()==0){
                return new int[]{0};
            }
            int[] ans=new int[list.size()];
            for (int i1 = 0; i1 < ans.length; i1++) {
                ans[i1]=list.get(list.size()-1-i1);
            }
            return ans;

        }
    }
}
