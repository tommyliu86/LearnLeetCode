package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-08-21-22:53
 * {@link 521.md}
 */
public class FindLUSlength {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        return Math.max(a.length(),b.length());
    }
}
