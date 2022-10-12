package com.lwf.oneLearnOneday.normal;

import javax.swing.*;
import java.util.*;

/**
 * @author liuwenfei
 * @date 2022/10/5 11:58
 */
public class SubdomainVisits {
    class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String,Integer> map=new HashMap<>();
            for (int i = 0; i < cpdomains.length; i++) {
                String cpdomain = cpdomains[i];
                String[] domains = cpdomain.split(" ");

                Integer times = Integer.valueOf(domains[0]);
                String domain = domains[1];
                int j=0;
                while (j!=-1&& j<domain.length()){

                    String substring = domain.substring(j, domain.length());
                    map.put(substring,map.getOrDefault(substring,0)+times);

                    j=domain.indexOf(".",j+1);
                    if (j!=-1) {
                        j++;
                    }

                }
            }
            List<String> rtn=new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                rtn.add(entry.getValue()+" "+entry.getKey());
            }
            return rtn;
        }
    }
}
