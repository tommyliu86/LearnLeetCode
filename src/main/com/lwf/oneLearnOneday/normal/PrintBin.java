package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/3/2 8:54
 */
public class PrintBin {
    public static void main(String[] args) {
        System.out.println((double)1/ (1<<2));
    }

    /**
     * 小数的二进制表示,二进制小数，每个位上，表示的是2的幂次方的倒数，因此就可以按位加来表示指定的小数，比如 0.101=1/2+1/（2*2*2）
     */
    class Solution {
        public String printBin(double num) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("0.");
            int i=1;
            while (num!=0&&i<32){
                double cur = (double) 1 / (1 << i);
                if (num>=cur) {
                    num-=cur;
                    stringBuilder.append("1");
                }else{
                    stringBuilder.append("0");
                }
                i++;
            }
            return i==32?"ERROR":stringBuilder.toString();
        }
    }
}
