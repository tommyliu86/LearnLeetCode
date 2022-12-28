package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2022/12/28 8:33
 */
public class MinimumLength {
    class Solution {
        public int minimumLength(String s) {
            int l=0;
            int r=s.length()-1;
            while (l<r){
                char c=s.charAt(l);
                if (s.charAt(l)==c&&s.charAt(r)==c){
                    int il=0,ir=0;
                    //需要在相等的时候也做检查，避免最后剩下一个的情况没检查到。导致最后一个l==r的错误
                    while (l+il<=r-ir&& s.charAt(l+il)==c){
                        il++;
                    }
                    while (l+il<=r-ir&& s.charAt(r-ir)==c){
                        ir++;
                    }
                    l+=il;
                    r-=ir;
                }else{
                    break;
                }
            }
            return r-l+1;
        }
    }
}
