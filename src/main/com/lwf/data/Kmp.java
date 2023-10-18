package com.lwf.data;

/**
 * https://www.cnblogs.com/dusf/p/kmp.html
 *
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * @author liuwenfei
 * @date 2023/10/18 8:47
 */
public class Kmp {
    public int kmp(String source,String s){
        char[] t = source.toCharArray();
        int i=0,j=0;
        int[] next=next(s);
        //i，j是 主串 和 子串 的指针，进行对比，如果对比的字符不相同，则只回溯 子串即可。这就是kmp的核心
        while (i<source.length()&&j<s.length()){
            if (j==-1||t[i]==s.charAt(j)){
                i++;
                j++;
            }else{
                //不匹配时，i不需要回溯，我们只要移动 子串的 j，j就是next的下一个要匹配 也就是k
                j=next[j];
            }
        }
        //j到了s的长度，表示匹配成功,否则 匹配失败
        if (j==s.length()){
            return i-j;
        }else{
            return -1;
        }
    }
    /**
     * 数组本身的 每一个位上不相同时要 移动对比指针指向的下一个位置
     * @param s
     * @return
     */
    public int[] next(String s){
        char[] chars = s.toCharArray();
        int[] next=new int[chars.length];
        //特殊值 -1，标识此时第一位不匹配则需要直接找下一个位置了
        next[0]=-1;
        //index 位
        int j=0;
        //前一个j的下一位
        int k=-1;
        //每次写入的是j的下一位，也就是我们通过对比j 和j的前缀字符串的下一个k，如果相同，则j+1的 k值==k+1，
        while (j<s.length()-1){
            if (k==-1){
                //如果k==-1，表示目前是第一个字符，那么下一个位置要对比的就应该是第一个字符，也就是index=0的字符
                next[++j]=++k;
            }else if (chars[j]==chars[k]){
                //当前的字符和 上一个字符位置的 前缀串的尾巴相同，也即是前缀字符串会 变长，因此 下一个字符不相同时，可以用的前缀字符串直接+1
                next[++j]=++k;
            }else{
                //如果j 和 前缀字符串的尾巴k不相同，则需要 循环查找每个 k的 前一个前缀字符串的尾巴来进行对比，找到j可以匹配到的最大前缀字符串。
                while ((k=next[k])!=-1&& chars[ k]!=chars[j]){

                }
                next[++j]=++k;
            }
        }
        return next;
    }
}
