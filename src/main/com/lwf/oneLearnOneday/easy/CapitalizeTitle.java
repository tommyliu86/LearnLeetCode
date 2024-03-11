package com.lwf.oneLearnOneday.easy;

/**
 * 2129. 将标题首字母大写
 *
 * @author liuwenfei
 * @date 2022/11/29 9:41
 */
public class CapitalizeTitle {
    class Solution {
        public String capitalizeTitle(String title) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = title.toCharArray();
            for (int i = 0; i < chars.length; ) {
                if (chars[i]==' '){
                    stringBuilder.append(chars[i++]);
                }else{
                    int j=i;
                    while (j<chars.length&&chars[j]!=' '){
                        j++;
                    }
                    if (j-i>2){
                        stringBuilder.append(Character.toUpperCase(chars[i++]));
                        while (i<chars.length&&chars[i]!=' '){
                            stringBuilder.append(Character.toLowerCase(chars[i++]));

                        }
                    }else{
                        while (i<chars.length&&chars[i]!=' '){
                            stringBuilder.append(Character.toLowerCase(chars[i++]));

                        }
                    }
                }
            }
            return stringBuilder.toString();
        }
    }

    class Solution1 {
        public String capitalizeTitle(String title) {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (i < title.length()) {
                if (title.charAt(i) == ' ') {
                    stringBuilder.append(' ');
                    i++;
                } else {
                    int j = i + 1;
                    while (j < title.length() && title.charAt(j) != ' ') {
                        j++;
                    }
                    if (j - i > 2) {
                        stringBuilder.append(Character.toUpperCase(title.charAt(i++)));

                    }
                    for (; i < j; i++) {
                        stringBuilder.append(Character.toLowerCase(title.charAt(i)));
                    }
                }
            }
            return stringBuilder.toString();
        }
    }
}
