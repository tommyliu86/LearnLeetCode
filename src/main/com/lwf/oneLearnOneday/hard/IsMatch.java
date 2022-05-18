package com.lwf.oneLearnOneday.hard;

/**
 * Created with IntelliJ IDEA.
 *
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * 10. 正则表达式匹配
 * @author: liuwenfei14
 * @date: 2022-02-17 10:08
 */
public class IsMatch {
    /**
     * 动态规划，主要是做转移公式的推导，一定是需要先把公式想出来的。。
     * regex 的字符有三种，a . 和*，.可以看做是任意字符，*前面必须是字符
     * 因此遍历regex时，如果j=*，则需要结合j-1来判断，因此把(j-1)*当做整体来进行匹配，（j-1）*分成 0次和n次使用。
     *     （j-1）*使用0次，也就是 i j-2的问题。（j-1）*使用n次。则必须要至少j-1==i才行。因此根据条件降级为i-1 j的问题。
     * 如果j=a||.，则根据 i==j 来降级为i-1和j-1的问题
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }
    public boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];//数组中默认值是false
        f[0][0] = true;
        for (int i = 0; i <=s.length(); ++i) { //i是字符串长度
            for (int j = 1; j <= n; ++j) { //j是正则串长度
                //j为字符串长度，则j长度的字符串的末尾字符是charat（j-1）
                int indexJ=j-1;
                if (p.charAt(indexJ) == '*') { //末尾是*

                    if (matches(s, p, i, j - 1)) { //用*前一位的字符来match是否相同
                        f[i][j] = f[i - 1][j];//因为（j-1）*可以匹配多个，这时就需要i前移一位，看(j-1)*是否匹配了多个
                        if (f[i][j]==false){//这里的逻辑一般想不到。如果i-1和j没有匹配，则需要j向前移动，看是否匹配
                            f[i][j] = f[i][j - 2];
                        }
                    }else{
                        f[i][j] = f[i][j - 2];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    /**
     * 对比两个字符串在指定位置的字符是否匹配，前提是j处不是*。
     * @param s
     * @param p
     * @param i
     * @param j
     * @return
     */
    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
