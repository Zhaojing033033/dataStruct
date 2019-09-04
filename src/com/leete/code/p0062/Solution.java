package com.leete.code.p0062;

/**
 * 题目
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 * <p>
 * 思路:回塑会超时
 * <p>
 * 思路:
 * 回塑会超时：
 * 由于有许多重复的计算，所以 可以通过缓存已经计算过的结果，进行查表来优化。
 * 动态规划思路：
 * 1、找到动态方程
 * 2、初始化动态方程最原始的两个数（或几个）
 * 3、循环的方式
 */

/**
 * 思路:
 * 回塑会超时：
 * 由于有许多重复的计算，所以 可以通过缓存已经计算过的结果，进行查表来优化。
 * 动态规划思路：
 * 1、找到动态方程
 * 2、初始化动态方程最原始的两个数（或几个）
 * 3、循环的方式
 */

/**
 * 体会：
 *
 */


public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] data = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j]=-1;
            }
        }
        return backup(m - 1, n - 1, data);
    }

    public int backup(int m, int n, int[][] data) {
        if (-1 == m || -1 == n) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        if (data[m ][n] != -1)
            return data[m][n];

        data[m ][n ] = backup(m - 1, n, data) + backup(m, n - 1, data);

        return data[m ][n];
    }

    //动态规划
    public int aa(int m, int n) {
        int[][] data = new int[m][n];
        for (int i = 0; i < m; i++)
            data[i][0] = 1;
        for (int i = 0; i < n; i++)
            data[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                data[i][j] = data[i - 1][j] + data[i][j - 1];
            }
        }
        return data[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int i = new Solution().uniquePaths(7, 3);
        System.out.println(i);
    }
}
