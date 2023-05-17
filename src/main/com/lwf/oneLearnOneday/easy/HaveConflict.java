package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/5/17 8:58
 */
public class HaveConflict {
    class Solution {
        public boolean haveConflict(String[] event1, String[] event2) {
            return ( event1[0].compareTo( event2[0])>=0&&event1[0].compareTo( event2[1])<=0)
                    ||(event2[0].compareTo(  event1[0])>=0&& event2[0].compareTo(event1[1])<=0);
        }
    }
}
