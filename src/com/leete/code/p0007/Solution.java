package com.leete.code.p0007;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */

public class Solution {
    public int reverse(int x) {
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


    public static void main(String[] args) {
        int a = -1463847412;
        int i = new Solution().reverse(a);
        System.out.println(i);


        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        int x=123;
        x/=10;
        System.out.println( x);
        int b=123;
        b=b/10;
        System.out.println(b);
    }
}
