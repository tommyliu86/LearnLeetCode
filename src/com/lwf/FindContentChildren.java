package com.lwf;

import java.util.Arrays;

/**
 * author Administrator
 * time 2019-08-16-23:18
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length==0||s.length==0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        if (g[0]>s[s.length-1]) return 0;
        if(g[g.length-1]<s[0]) return Math.min(g.length,s.length);
        int cursorg=0;
        int cursors=0;
        while (cursorg<g.length&&cursors<s.length){
            if (g[cursorg]>s[cursors]){
                cursors++;
            }else{
                cursorg++;
                cursors++;
            }
        }
        return cursorg;
    }
}
