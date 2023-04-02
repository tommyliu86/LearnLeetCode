package com.lwf.oneLearnOneday.normal;

public class maskPII {
    /**
     * 尽量利用java库来进行简化
     */
    class Solution {
      String[] strings =  new String[]{  "***-***-", "+*-***-***-", "+**-***-***-", "+***-***-***-"};
        public String maskPII(String s) {
            StringBuilder stringBuilder = new StringBuilder();
            if (s.indexOf('@')>0){
                int i = s.indexOf('@');
                stringBuilder.append(s.charAt(0)).append("*****")
                        .append(s,i-1,s.length());
                return stringBuilder.toString().toLowerCase();
            }else{
                /**
                 * 使用正则会拖慢速度，直接使用数组遍历会快很多
                 */
//                s= s.replaceAll("[^0-9]", "");
                StringBuilder stringBuilder1 = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                        stringBuilder1.append(s.charAt(i));
                    }
                }
                s=stringBuilder1.toString();
                stringBuilder.append(strings[s.length()-10]).append(s,s.length()-4,s.length());
                return stringBuilder.toString();
            }
        }
    }

    /**
     * 暴力法
     */
    class Solution1 {
        public String maskPII(String s) {
            StringBuilder stringBuilder = new StringBuilder();
            if (s.indexOf('@') > 0) {
                int i = s.indexOf('@');
                stringBuilder.append(Character.toLowerCase(s.charAt(0))).append("*****").append(Character.toLowerCase(s.charAt(i - 1))).append("@");
                i++;
                while (i < s.length()) {
                    stringBuilder.append(Character.toLowerCase(s.charAt(i++)));
                }
            } else {

                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        stringBuilder.append(s.charAt(i));
                    }
                }
                String s1 = stringBuilder.toString();
                StringBuilder stringBuilder1 = new StringBuilder();

                if (s1.length() == 10) {
                    stringBuilder1.append("***-***-").append(s1, 6, 10);
                } else if (s1.length() == 11) {
                    stringBuilder1.append("+*-***-***-").append(s1, 7, 11);
                } else if (s1.length() == 12) {
                    stringBuilder1.append("+**-***-***-").append(s1, 8, 12);
                } else if (s1.length() == 13) {
                    stringBuilder1.append("+***-***-***-").append(s1, 9, 13);
                }
                stringBuilder = stringBuilder1;
            }
            return stringBuilder.toString();
        }
    }
}
