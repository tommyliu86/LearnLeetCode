package com.lwf.learn.everyday.first.day1;

/**
 * Created with IntelliJ IDEA.
 *https://leetcode-cn.com/problems/first-bad-version/
 * 278. 第一个错误的版本
 * @author: liuwenfei14
 * @date: 2022-03-31 19:39
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        if (n==1){
            return 1;
        }
        int left=1;
        int right=n;
        while (left<right){
            //不能直接相加/2，会溢出
            int mid=left+ (right-left)/2;

            if (isBadVersion(mid)){
                if (mid==1||!isBadVersion(mid-1)){

                    return mid;
                }else{
                    right=mid-1;
                }
            }else{

                    left=mid+1;
            }
        }
        return isBadVersion( left)?left:left+1;

    }
    boolean isBadVersion(int version){
        return true;
    }
}
