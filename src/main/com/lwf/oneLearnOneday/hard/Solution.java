package com.lwf.oneLearnOneday.hard;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-26 09:46
 */
public class Solution {
    int maxW;
    Map<Integer, Integer> b2w;
    Random random;

    public Solution(int n, int[] blacklist) {
        random=new Random();
        maxW=n-blacklist.length;
        b2w=new HashMap<>();
        Set<Integer> blist=new HashSet<>();

        for (int i = 0; i < blacklist.length; i++) {
            if (blacklist[i]<maxW) {
                b2w.put(blacklist[i],0);
            }
            blist.add(blacklist[i]);
        }

        int w=maxW;

        for (Integer key : b2w.keySet()) {
            while (blist.contains(w)){
                w++;
            }
            b2w.put(key,w);
        }

    }

    public int pick() {
        int i = random.nextInt(maxW);
        if (b2w.containsKey(i)){
            return b2w.get(i);
        }else{
            return i;
        }
    }
}
