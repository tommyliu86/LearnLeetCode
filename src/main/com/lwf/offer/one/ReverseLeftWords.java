package com.lwf.offer.one;

public class ReverseLeftWords {
    class Solution {
        public String reverseLeftWords(String s, int n) {

            n = n % s.length();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s.substring(n)).append(s.substring(0,n));
            return stringBuilder.toString();
        }
    }
}
