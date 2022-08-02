package com.lwf.oneLearnOneday.easy;



public class GenerateTheString {
    class Solution {
        public String generateTheString(int n) {
                StringBuilder stringBuilder = new StringBuilder();
            if (n%2==0){
                n/=2;
                if (n%2==0){
                    for (int i = 0; i < n-1; i++) {
                        stringBuilder.append('a');
                    }
                    for (int i = 0; i < n + 1; i++) {
                        stringBuilder.append('b');
                    }
                }else{
                    for (int i = 0; i < n; i++) {
                        stringBuilder.append('a');
                    }
                    for (int i = 0; i < n ; i++) {
                        stringBuilder.append('b');
                    }
                }
            }else{
                for (int i = 0; i < n ; i++) {
                    stringBuilder.append('b');
                }
            }
            return stringBuilder.toString();
        }
    }
}
