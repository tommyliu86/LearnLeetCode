package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/5/9 8:53
 */
public class CountTime {
    class Solution {
        public int countTime(String time) {
            int ans=1;
            String[] split = time.split(":");
            String h = split[0];
            if (h.contains("?")){
                if (h.charAt(0)=='?'&&h.charAt(1)=='?') {
                    ans*=24;
                }else{
                    if (h.charAt(0)=='?') {
                        if (h.charAt(1)-'0'>3){
                            ans*=2;
                        }else{
                            ans*=3;
                        }
                    }else{
                        if (h.charAt(0)-'0'==2){
                            ans*=4;
                        }else{
                            ans*=10;
                        }
                    }
                }
            }
            String s = split[1];
            if (s.charAt(0)=='?'){
                ans*=6;
            }
            if (s.charAt(1)=='?'){
                ans*=10;
            }
            return ans==1?0:ans;
        }
    }
}
