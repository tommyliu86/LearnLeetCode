package com.lwf;

public class CountPrimes {
    /**
     * 1.分析定义，素数是只能被1和自身整除的书， k%all！=0,其中的all从1到k-1，使用该方法暴力破解
     * 2.根据素数的特征找到优化算法的地方。
     *  1.素数肯定是奇数。
     *  2.若一个数不是素数则存在m=u*v存在，则可以知道u/v<=sqrt(m)，因为不可能 u和v都大于sqrt（m）所以，只要m%u！=0&&u<=sqrt（m）成立，就是素数
     *  此处的暴力破解优化后的方案的时间复杂度O((n/2)的平方)
     * @param n
     * @return
     */
    public int countPrimes(int n){
        if (n<3) return 0;
        int rtn=1;
        for (int i = 3; i <n ; i++) {
            if (i%2==0) continue;
            boolean is=true;
            /**
             * 此处的平方根方法需要思考一下原因在于
             */
            for (int j = 3; j <Math.sqrt(i) ; j+=2) {
                if(i%j==0){
                    is=false;
                    break;
                }
            }
            if(is) rtn++;
        }
        return rtn;
    }
}
