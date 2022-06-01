package com.lwf.learn.everyday.coding.level2;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-01 16:12
 */
public class AuthenticationManager {
    public class AuthenticationManager1 {

        int ttl;
        Map<String, Integer> map = new HashMap<>();

        public AuthenticationManager1(int timeToLive) {
            ttl = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId, currentTime);
        }

        public void renew(String tokenId, int currentTime) {

            if (map.containsKey(tokenId)) {

                if (map.get(tokenId)+ttl > currentTime) {

                    map.put(tokenId,currentTime);
                }

            }
        }

        public int countUnexpiredTokens(int currentTime) {
            Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> next = iterator.next();
                if (next.getValue()+ttl<=currentTime) {
                    iterator.remove();
                }
            }
            return map.size();
        }
    }

    int ttl;
    Map<String, entry> map = new HashMap<>();

    class entry {
        String tokenId;
        Integer time;

        public entry(String s, Integer i) {
            tokenId = s;
            time = i;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof entry) {
                return Objects.equals(this.tokenId,((entry)obj).tokenId);
            }
            return false;
        }
    }

    PriorityQueue<entry> queue;

    public AuthenticationManager(int timeToLive) {
        ttl = timeToLive;
        queue = new PriorityQueue<entry>(Comparator.comparing(e -> e.time));
    }

    public void generate(String tokenId, int currentTime) {
        if (map.containsKey(tokenId)){
            entry entry = map.get(tokenId);
            queue.remove(entry);
            entry.time=currentTime+ttl;
            queue.add(entry);
        }else{
            entry entry = new entry(tokenId, currentTime + ttl);
            map.put(tokenId,entry);
            queue.add(entry);
        }
    }

    public void renew(String tokenId, int currentTime) {

        if (map.containsKey(tokenId)) {
            entry entry = map.get(tokenId);
            if (entry.time > currentTime) {

                entry.time = currentTime + ttl;
            }

        }
    }

    public int countUnexpiredTokens(int currentTime) {
        while (!queue.isEmpty() && queue.peek().time <= currentTime) {
            entry poll = queue.poll();
            map.remove(poll.tokenId);
        }
        return queue.size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */