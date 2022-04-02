package com.lwf.TOP100.normal;

/**
 * author Administrator
 * time 2019-09-03-23:21
 * {@link 3.md}
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()<2)return s.length();
        int[] map=new int[128];//保存字符在字符串中的索引位置index，在min，max两个指针移动时进行记录比较是否有字符重复出现
        int min=0;
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            int pos=s.charAt(i)-0;
            if (map[pos]!=0&&map[pos]>min){//遇到相同字符了进行处理 1.计算当前最大长度max，2.把小指针移动到重复字符的index位置。3.更新当前字符的索引到map中
                max=Math.max(max,i-min);
                min=map[pos];
                map[pos]=i+1;
            }else{ //没有相同则继续
                map[pos]=i+1;
            }
        }
        return Math.max(max,s.length()-min);//最后会剩下max和min到最后的一个子串，需要进行比对下
    }
}
