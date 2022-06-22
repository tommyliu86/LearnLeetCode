package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-21 14:39
 */
public class DefangIPaddr {
    public static void main(String[] args) {
        String address="1.1";
        StringBuilder builder = new StringBuilder();
        for (int i = address.length()-1; i >= 0; i--) {
            if (address.charAt(i)=='.'){
                builder.append("[.]");
            }else{
                builder.append(address.charAt(i));
            }
        }
        System.out.println(builder.toString());
        System.out.println(builder.reverse().toString());
    }
    class Solution {
        public String defangIPaddr(String address) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < address.length(); i++) {
                if (address.charAt(i)=='.'){
                    builder.append("[.]");
                }else{
                    builder.append(address.charAt(i));
                }
            }
            return builder.toString();
        }
    }
}
