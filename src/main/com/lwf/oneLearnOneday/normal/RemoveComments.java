package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/8/3 8:40
 */
public class RemoveComments {
    /**
     * 块注释可以在代码行中，也就是 block + a + block + b + block,
     * 其中的block可以是一行，也可以是多行，因此，分情况考虑统计最好是逐行逐字符来进行解析，而不是直接一行整行解析。
     */
    class Solution {
        public List<String> removeComments(String[] source) {
            List<String> ans = new ArrayList<>();
            boolean isBlock = false;
            int i = 0;
            StringBuilder builder = new StringBuilder();
            while (i < source.length) {
                String cur = source[i++];

                if (isBlock){

                }else{

                }

            }
            return null;
        }
    }
}
