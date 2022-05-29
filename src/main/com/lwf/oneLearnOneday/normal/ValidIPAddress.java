package com.lwf.oneLearnOneday.normal;

/**
 * Created with IntelliJ IDEA.
 *  模拟计算，需要多考虑下边界条件！！！
 * @author: liuwenfei14
 * @date: 2022-05-29 21:48
 */
public class ValidIPAddress {


    static class Solution {
        public String validIPAddress(String queryIP) {
            if (queryIP.endsWith(".") || queryIP.endsWith(":")) {
                return "Neither";
            }
            if (queryIP.contains(".")) {
                String[] split = queryIP.split("\\.");
                if (split.length == 4) {
                    boolean is = true;
                    for (int i = 0; is && i < split.length; i++) {
                        is = ip4(split[i]);
                    }
                    return is ? "IPv4" : "Neither";
                } else {
                    return "Neither";
                }
            } else if (queryIP.contains(":")) {
                String[] split = queryIP.split(":");
                if (split.length == 8) {
                    boolean is = true;
                    for (int i = 0; is && i < split.length; i++) {
                        is = ip6(split[i]);
                    }
                    return is ? "IPv6" : "Neither";
                } else {
                    return "Neither";
                }

            } else {
                return "Neither";
            }
        }

        public boolean ip4(String s) {
            char[] chars = s.toCharArray();
            if (chars.length > 0 && chars.length < 4) {
                Integer ip = 0;
                for (int i = 0; i < chars.length; i++) {
                    int j = chars[i] - '0';
                    if (j < 0 || j > 9) {
                        return false;
                    }

                    ip = ip * 10 + (chars[i] - '0');
                    if (chars.length > 1 && i == 0 && ip == 0) {
                        return false;
                    }
                }
                return ip >= 0 && ip < 256;
            } else {
                return false;
            }
        }

        public boolean ip6(String s) {
            char[] chars = s.toCharArray();
            if (chars.length > 0 && chars.length <= 4) {

                for (int i = 0; i < chars.length; i++) {
                    char aChar = chars[i];
                    if ((aChar - '0' >= 0 && aChar - '0' <= 9) || (aChar - 'a' >= 0 && aChar - 'a' < 5) || (aChar - 'A' >= 0 && aChar - 'A' < 5)) {
                        continue;
                    } else {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        }
    }
}
