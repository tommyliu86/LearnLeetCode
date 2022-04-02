package com.lwf.oldtime;

import java.util.*;

/**
 * author Administrator
 * time 2019-08-19-23:21
 * {@link 500.md}
 */
public class FindWords {
    public static void main(String[] args) {
        System.out.println(new FindWords().findWords(new String[]{
                "asdfghjklASDFGHJKL","qwertyuiopQWERTYUIOP","zxcvbnmZXCVBNM"}));
    }
    public String[] findWords(String[] words) {
        Set<Integer> s1=new HashSet<>(Arrays.asList(0+'Q',0+'W',0+'E',0+'R',0+'T',0+'Y',0+'U',0+'I',0+'O',0+'P',0+'q',0+'w',0+'e',0+'r',0+'t',0+'y',0+'u',0+'i',0+'o',0+'p'));
        Set<Integer> s2=new HashSet<>(Arrays.asList(0+'A',0+'S',0+'D',0+'F',0+'G',0+'H',0+'J',0+'K',0+'L',0+'a',0+'s',0+'d',0+'f',0+'g',0+'h',0+'j',0+'k',0+'l'));
        Set<Integer> s3=new HashSet<>(Arrays.asList(0+'Z',0+'X',0+'C',0+'V',0+'B',0+'N',0+'M',0+'z',0+'x',0+'c',0+'v',0+'b',0+'n',0+'m'));
        String[] rtn=new String[words.length];
        int count=0;
        for (int i = 0; i < words.length; i++) {
            char[] chars=words[i].toCharArray();
            Set<Integer> s;
            if ( s1.contains(0+ chars[0])){
                s=s1;
            }else if(s2.contains(0+ chars[0])){
                s=s2;
            }else{
                s=s3;
            }
            int j=1;
            while (j<chars.length&&s.contains(0+chars[j])){
                j++;
            }
            if (j==chars.length) {
                rtn[count]=(words[i]);
                count++;
            }

        }
        return Arrays.copyOf(rtn,count);

    }

}
