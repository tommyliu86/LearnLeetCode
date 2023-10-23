package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/10/20 8:46
 */
public class CategorizeBox {
    public static void main(String[] args) {
        String s="1,2,3,";
        String[] split = s.split("[,|，]");
        System.out.println(split.length);
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

    }

    class Solution {
        public String categorizeBox(int length, int width, int height, int mass) {
            String[] cate=new String[]{"Neither","Bulky","Both","Heavy"};
            int score=0,isHeavy=mass>=100?1:0;
            if (length>=10000||width>=10000||height>=10000||((long)length*width*height>=1000_000_000)){
                score++;
            }
            score+=isHeavy;
            if (score==0||score==2){
                return cate[score];
            }else{
                return cate[isHeavy==1?3:1];
            }
        }
    }
}
