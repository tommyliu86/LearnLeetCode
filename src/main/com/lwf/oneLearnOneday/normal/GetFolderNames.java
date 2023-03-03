package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2023/3/3 8:53
 */
public class GetFolderNames {
    /**
     * hash 查找唯一即可，这里要理解题意。。阅读理解题
     *
     */
    class Solution {
        public String[] getFolderNames(String[] names) {
            String[] ans =new String[names.length];

            Map<String, Integer> posts=new HashMap<>();
            for (int i = 0; i < ans.length; i++) {
                String name = names[i];

                if (posts.containsKey(name)) {
                    Integer integer = posts.get(name);
                    while (posts.containsKey(name+"("+integer+")")){
                        integer++;
                    }
                    ans[i]=name+"("+integer+")";
                    posts.put(ans[i],1);
                    posts.put(name,integer+1);
                }else{
                    ans[i]=name;
                    posts.put(name,1);
                }

            }
            return ans;
        }

    }
}
