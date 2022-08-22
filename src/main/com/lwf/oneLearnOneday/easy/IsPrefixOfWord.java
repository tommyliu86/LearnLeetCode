package com.lwf.oneLearnOneday.easy;


class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
      char[] chars=  sentence.toCharArray();
        int i=0;
        int count=0;
        while(i<chars.length-searchWord.length()){
            count++;
            int j=i;
            while(j<chars.length&& chars[j]!=' '){
                j++;
            }
            if(j-i>=searchWord.length()){
               int k=0;
               while(k<searchWord.length()&&searchWord.charAt(k)==chars[i+k]){
                    k++;
               }
               if(k==searchWord.length())   {
                return count;
               }  
            }

            i=j;
        }

        return -1;

    }
}