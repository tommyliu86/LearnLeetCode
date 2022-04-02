package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-08-14
 * {@link 443.md}
 */
public class Compress {
    public static void main(String[] args) {
        System.out.println(new Compress().compress(new char[]{
                'a', 'b', 'c', 'd', 'e', 'f','g','g','g','g','g','g','g','g','g','g','g','g','a','b','c'}));
    }
        public int compress(char[] chars) {
            if (chars.length<2) return chars.length;
            int start=0;
            int end=1;
            int count=0;
            while (end<chars.length){
                if (chars[end]==chars[start]) {
                    count++;

                }else   {
                    if (count<1){
                        start++; //这里若不相等时只有一个字符，则起始位++，之后进行赋值操作。
                        //此时两种情况，1。start=end。则赋值为自己=自己，若start<end.则是把end的char前移到新队列中的位置！
                        chars[start]=chars[end];
                    }else {
                        char[] chars1 = String.valueOf(count+1).toCharArray();
                        for (int i = 0; i < chars1.length; i++) {
                            chars[start+1+i]=chars1[i];
                        }
                        start=start+chars1.length+1;
                        chars[start]=chars[end];

                    }
                    count=0;
                }
                end++;
            }
            if (count==0) {
                return start + 1;
            }
            else{
                char[] chars1 = String.valueOf(count+1).toCharArray();
                for (int i = 0; i < chars1.length; i++) {
                    chars[start+1+i]=chars1[i];
                }
               return start+chars1.length+1;
            }
        }

}
