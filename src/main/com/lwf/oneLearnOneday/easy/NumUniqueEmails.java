package com.lwf.oneLearnOneday.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-04 09:09
 */
public class NumUniqueEmails {
    class Solution {
        public int numUniqueEmails(String[] emails) {
            Set<String> set=new HashSet<>();
            for (int i = 0; i < emails.length; i++) {
                String email = emails[i];
                String[] split = email.split("@");
                String[] split1 = split[0].split("\\+");
                String replace = split1[0].replace(".", "");
                replace+=split[1];
                set.add(replace);
            }
            return set.size();
        }
    }
}
