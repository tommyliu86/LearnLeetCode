package com.lwf;

/**
 * author Administrator
 * time 2019-08-01
 */
public class FirstBadVersion {
    /**
     * 超时
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        while (isBadVersion(n)) {
            n--;
        }
        return n + 1;
    }

    /**
     * 使用迭代代替递归，通过
     * @param n
     * @return
     */
    public int firstBadVersion1(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid=start+(end-start)/2;
            if (isBadVersion( mid)) {
                end = mid-1;
            }else{
                if (isBadVersion(mid+1)) return mid +1;
                 start=mid + 1;
            }
        }
        return isBadVersion(start)?start:start+1;
    }

    /**
     * 递归调用stackoverflowError了
     *
     * @param start
     * @param end
     * @return
     */
    int binarySearch(int start, int end) {
        if (isBadVersion((start + end) / 2)) {
            return binarySearch(start, (start + end) / 2 - 1);
        } else {
            if (isBadVersion((start + end) / 2 + 1)) return (start + end) / 2;
            return binarySearch((start + end) / 2 + 1, end);
        }
    }

    boolean isBadVersion(int version) {
        return true;
    }
}
