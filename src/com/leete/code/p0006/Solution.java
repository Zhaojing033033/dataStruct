package com.leete.code.p0006;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 体会：单指针
 */

/**
 * 体会：单指针，改变方向的指针
 */

/**
 * 思路：
 * 解法一：单指针，通过两个变量来控制指针位置和移动方向，然后遍历字符串，依次将字符放入指针所在行
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;

        boolean down = true;//控制指针移动方向
        int rowNum = 0;//指针指着的行数

        numRows = Math.min(s.length(), numRows);
        //初始化行
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        //开始遍历字符串
        for (int i = 0; i < s.length(); i++) {

            rows[rowNum].append(s.charAt(i));
            //根据移动方向，移动指针
            if (down)
                rowNum++;
            else
                rowNum--;
            //若指针指头第一行或最后一行，则改变移动方向
            if (rowNum == 0 || rowNum == numRows - 1)
                down = !down;

        }
        //将各行汇汇总
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < rows.length; i++) {
            ret.append(rows[i].toString());
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 4;
        String convert = new Solution().convert(s, numRows);
        System.out.println(convert);
    }
}
