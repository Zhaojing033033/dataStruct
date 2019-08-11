package com.leete.code.p0049;

/**
 * 题目
 */

/**
 * 思路
 */

import java.util.*;

/**
 * 体会：
 *
 */
public class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,List<String>> ret=new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                char[] split = strs[i].toCharArray();
                Arrays.sort(split);
                String sortedString =new String(split);
                putMapSubList(ret,sortedString,strs[i]);
            }
            return  new ArrayList<>(ret.values());

        }

    public void putMapSubList(Map<String,List<String>> map,String key,String val){
        if(!map.containsKey(key)){
            ArrayList<String> strings = new ArrayList<>();
            map.put(key,strings);
        }
        map.get(key).add(val);
    }

    public static void main(String[] args) {
        String[] split = "cba".split("");
        Arrays.sort(split);

        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);

        }
    }
}
