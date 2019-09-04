package com.leete.code.p0063;

/**
 * 题目
 * <p>
 * 思路
 * <p>
 * 思路
 * <p>
 * 思路
 */

/**
 * 思路
 * 动态规划：
 * 1、边界
 */

/**
 * 体会：
 *
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1)  //边界处理
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        obstacleGrid[0][0]=1;

        //处理第一行和第一列，将所有没有障碍物的位置设置为1，有障碍物的位置设为0
        for (int i = 1; i < m; i++)
            obstacleGrid[i][0] = obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0]== 1 ? 1:0 ;
        for (int i = 1; i < n; i++)
            obstacleGrid[0][i] = obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1]== 1 ? 1:0 ;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //若当前位置为0（没有障碍），则利用动态方程求解
               if(obstacleGrid[i][j] == 0){
                   obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
               }else {
                   //若为1，则有障碍物，经过该位置的路径岀无效。
                   obstacleGrid[i][j]=0;
               }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}