package com.lwf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-10 20:26
 */
public class test {
    public static void main(String[] args) {
        List<Integer> list1=new ArrayList(Arrays.asList(1,2,3));
        List<Integer> list11=new ArrayList(Arrays.asList(2,3,4));
        System.out.println(list1.containsAll(list11));
        list1.removeAll(list11);
        System.out.println(list1);

    }
    public static void main1(String args[]) {
        String str = "03.141";
        String pattern = "^(([1-9]\\d{0,12})|(0))(.\\d{0,3})?$";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());

        S<Void> ss=new S<>();
        S s1=ss;
        s1.setData("123");
        System.out.println(  ss.toString());
        System.out.println(  s1.toString());
    }
    public static class S<T>{
        private T data;

        public T getData() {
            return data;
        }

        public S<T> setData(T data) {
            this.data = data;
            return this;
        }

        @Override
        public String toString() {
            return "S{" +
                    "data=" + data +
                    '}';
        }
    }
    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param words string字符串一维数组
         * @return string字符串
         */
        public String longestWord(String[] words) {
            // write code here
            List<String>[] dics = new List[26];
            for (int i = 0; i < dics.length; i++) {
                dics[i] = new ArrayList<String>();
            }
            Arrays.sort(words, Comparator.comparing(String::length));

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (word.length()>0){

                    int j = word.charAt(0) - 'a';
                    dics[j].add(word);
                }
            }

            int max = 0;
            List<String> list = new ArrayList<>();
            for (int i = words.length - 1; i >= 0; i--) {
                String word = words[i];
                if (word.length() < max) {
                    break;
                }
                if (recursive(word, 0, dics)) {
                    if (word.length() > max) {
                        max = word.length();
                        list = new ArrayList<>();
                        list.add(word);
                    } else if (word.length() == max) {
                        list.add(word);
                    }
                }
            }
            if (list.size() == 0) {
                return "";
            } else {
                 list.sort(Comparator.comparing(s->s.charAt(0)));
                 return list.get(0);
            }

        }

        public Boolean recursive(String t, int i, List<String>[] dics) {
            if (i >= t.length()) {
                return true;
            }
            int j = t.charAt(i) - 'a';
            List<String> dic = dics[j];
            if (dic.size() == 0) {
                return false;
            }
            for (int k = 0; k < dic.size(); k++) {
                String s = dic.get(k);
                if (s.length() > t.length() - i) {
                    return false;
                }
                if (t.substring(i, i+s.length()).equals(s)) {
                    if (i==0&&t.length()==s.length()){
                        continue;
                    }
                    if (recursive(t, i + s.length(), dics)) {
                        return true;
                    }
                }
            }
            return false;
        }


    }
}
