package com.leete.code.p0009;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

 示例 1:

 输入: 121
 输出: true
 示例 2:

 输入: -121
 输出: false
 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 示例 3:

 输入: 10
 输出: false
 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 进阶:

 你能不将整数转为字符串来解决这个问题吗？
 */

/**
 * 思路：一：将数据转为字符，依次判断第N位和倒数第N位是否相同。有不同的，则不是
 * 二：不转为字符，借助0007号题，将数字翻转，判断是否相等。
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        return x==reverse(x);
    }
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (rev  > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;//因为MAX_VALUE尾数是7
            if (rev  < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;//因为MIN_VALUE尾数是8
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public  boolean isPalindrome1(int x){
        String s = String.valueOf(x);
        int l=0,r=s.length()-1;
        while(!(l>r)){
            if(s.charAt(l)!=s.charAt(r))return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean palindrome = new Solution().isPalindrome1(123);
        System.out.println(palindrome);
    }

}
