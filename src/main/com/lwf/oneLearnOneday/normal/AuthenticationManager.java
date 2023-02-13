package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/2/9 9:44
 */
public class AuthenticationManager {
        int ttl;

        Map<String,Integer> tokens=new HashMap<>();
        public AuthenticationManager(int timeToLive) {

            ttl=timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
                tokens.put(tokenId,currentTime);

        }

        public void renew(String tokenId, int currentTime) {
            if (tokens.containsKey(tokenId)) {
                Integer pre = tokens.get(tokenId);
                if (pre+ttl>currentTime){
                    tokens.put(tokenId,currentTime);
                }
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int ans=0;

            Iterator<Map.Entry<String, Integer>> iterator = tokens.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, Integer> next = iterator.next();
                if (next.getValue()+ttl<=currentTime){
                    iterator.remove();
                }else{
                    ans++;
                }
            }

            return ans;
        }


/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
}
