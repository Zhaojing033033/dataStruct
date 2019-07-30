package com.leete.code.lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 3
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

/**
 * 体会：浮动窗口
 */
public class Solution {


    public int lengthOfLongestSubstring2(String s) {
        int maxLength=0;
        int[] array= new int[255];
        for (int i=0,j = 0; j < s.length() ; j++) {
            char charAt = s.charAt(j);

            if(array[charAt] != 0){
                Integer charIndex = array[charAt];
                i = Math.max(charIndex, i);//比较重复的字符的下标与左边界的大小，取大的
                //i=i+1;    (1)  若在这里处理+1，则在最后一次时，就多加了1。所有 在（2）改成 map.put(charAt,j+1)
            }
            maxLength= Math.max(j-i+1,maxLength);
            array[charAt]=j+1;// (2) map.put(charAt,j);
        }

        return  maxLength;
    }

    public int lengthOfLongestSubstring1(String s) {
        int maxLength=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0,j = 0; j < s.length() ; j++) {
            char charAt = s.charAt(j);

            if(map.containsKey(charAt)){
                Integer charIndex = map.get(charAt);
                i = Math.max(charIndex, i);//比较重复的字符的下标与左边界的大小，取大的
                //i=i+1;    (1)  若在这里处理+1，则在最后一次时，就多加了1。所以 在（2）改成 map.put(charAt,j+1)
            }
            maxLength= Math.max(j-i+1,maxLength);
            map.put(charAt,j+1);// (2) map.put(charAt,j);
        }

        return  maxLength;
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength=0;
        Set<Character> set = new HashSet<>();
        for (int i=0,j = 0; j < s.length() ; ) {
            char charAt = s.charAt(j);

            if(set.contains(charAt)){
                set.remove(s.charAt(i));
                i++;
            }else{

                set.add(charAt);
                maxLength= Math.max(j-i+1,maxLength);
                j++;
            }
        }

        return  maxLength;
    }


    public static void main(String[] args) {


        String test="bbbbb";
        String test1="abcabcbb";
        String test2="pwwkew";
        int length1 = new Solution().lengthOfLongestSubstring2(test);
        System.out.println(length1+"");


        int length2 = new Solution().lengthOfLongestSubstring2(test1);
        System.out.println(length2+"");

        int length3 = new Solution().lengthOfLongestSubstring2("tmmzuxt");
        System.out.println(length3+"");
    }
}
