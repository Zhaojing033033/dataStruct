package com.leete.code.P0050;

/**
 * 题目
 * <p>
 */

/**
 * 思路
 */

/**
 * 体会：三目运算比if..else..耗时！！！
 *
 */
public class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(n<0){
            x=1/x;
            N=-N;
        }

        return fastPow(x,N);

    }

    private double fastPow(double num, long n) {
        if (n == 0  )
            return 1.0;

        double v = fastPow(num, n / 2);

       if(n % 2==0)
           return v*v;
       else
           return v*v*num;//底数表现在这里

    }

    public static void main(String[] args) {
        double v = new Solution().myPow(2, -2);
        System.out.println(v);
    }
}
