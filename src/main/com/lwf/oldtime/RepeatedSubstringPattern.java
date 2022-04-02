package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-08-16-23:28
 * {@link 459.md}
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println("abaab".matches("^([a-z]+){2,}$"));
    }
    public boolean repeatedSubstringPattern(String s) {

       int step=1;
       while (step<s.length()){
           if (s.length()%step!=0){
               step++;
           }else {
                int i=step;
               for (; i < s.length()&&s.charAt(i)==s.charAt(i%step); i++) {

               }
               if (i==s.length()){
                   return true;
               }
               step++;
           }
       }
       return false;

    }
    public boolean repeatedSubstringPattern1(String s) {
       return s.matches("([a-z]+)+");
    }
}
