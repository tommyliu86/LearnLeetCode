package com.lwf.arithmetic.level1.sortsearch;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-16 21:35
 */
public class FirstBadVersion {
    /**
     * 递归解法，二分查找
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        return bad(1,n);
    }
    int bad(int left,int right){
        if (left>=right){
            return right;
        }
        int mid=left+ (right-left)/2;
        if (left==mid){
            if (isBadVersion(left)){
                return left;
            }else{
                return left+1;
            }
        }
        if (isBadVersion(mid)==true){
            return bad(left,mid);
        }else{
            return bad(mid,right);
        }

    }

    boolean isBadVersion(int i){
        return false;
    }
}
