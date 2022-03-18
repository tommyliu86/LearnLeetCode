package com.lwf.TOP100.easy;

import java.util.*;

/**
 * author Administrator
 * time 2019-09-17-0:06
 * {@link 438.md}
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        Set<Character> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < p.length(); i++) {
            set.add(p.charAt(i));
            sum += p.charAt(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = p.length() - 1; i < s.length(); i++) {
            int tempsum = 0;
            for (int j = i; j > i - p.length(); j--) {
                if (!set.contains(s.charAt(j))) {
                    continue;
                }
                tempsum += s.charAt(j);
            }

            if (tempsum == sum) {
                list.add(i - p.length() + 1);
            }
        }
        return list;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        Set<Character> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < p.length(); i++) {
            set.add(p.charAt(i));
            sum += p.charAt(i);
        }
        List<Integer> list = new ArrayList<>();

        int[] ints = new int[s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            ints[i + 1] = ints[i] + s.charAt(i);
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (ints[i + p.length()] - ints[i] == sum) {
                boolean isok = true;
                for (int j = i; j < i + p.length(); j++) {
                    if (!set.contains(s.charAt(j))) {
                        isok = false;
                        break;
                    }
                }
                if (isok) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        int[] chars = new int[26];
        int sum = 0;
        for (int i = 0; i < p.length(); i++) {
            chars[p.charAt(i) - 'a'] += 1;
            sum += p.charAt(i);
        }
        int[] ints = new int[s.length() + 1];
        List<Integer> list = new ArrayList<>();


        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            ints[i + 1] = ints[i] + s.charAt(i);
            if (chars[s.charAt(i) - 'a'] == 0) {
                start = i + 1;

            }

            if (i + 1 - start >= p.length() && ints[i + 1] - ints[i + 1 - p.length()] == sum) {
                list.add(i + 1 - p.length());
            }
        }
        return list;
    }
}
