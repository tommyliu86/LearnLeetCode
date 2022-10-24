package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2022/10/20 8:52
 */
public class KthGrammar {
    /**
     * 递归或迭代即可
     */
    class Solution {
        public int kthGrammar(int n, int k) {
            if (k==1){
                return 0;
            }
            if (k==2){
                return 1;
            }
            if (k%2==1) {
                return kthGrammar(n,1+(k/2));
            }else{
                return kthGrammar(n,k/2)^1;
            }

        }
    }
}
