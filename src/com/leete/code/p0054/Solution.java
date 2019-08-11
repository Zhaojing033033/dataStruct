package com.leete.code.p0054;

/**
 * 题目
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

 示例 1:

 输入:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 输出: [1,2,3,6,9,8,7,4,5]
 示例 2:

 输入:
 [
 [1, 2, 3, 4],
 [5, 6, 7, 8],
 [9,10,11,12]
 ]
 输出: [1,2,3,4,8,12,11,10,9,5,6,7]

 */

/**
 * 思路：1：双指针：通过两个指针的来确定要被添加的元素的下标。通过方向确定指针的如何移动。通过上下左右四个边界来判断是否变换方向。
 *  2：按层遍历。一个循环遍历一层。遍历完一层后，同时四个边界同时编小，进行入下一个循环。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 体会：
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]=i*matrix.length+j+1;
            }
        }

        List<Integer> integers = new Solution().spiralOrder(matrix);
        integers.forEach(item -> System.out.println(item));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<>();

        if(matrix.length==0)
            return output;
        int t=0,l=0,r=matrix[0].length-1,b=matrix.length-1  ;//需要遍历的上左历左下四个边界
        int row=0,col=0;//行列的指针
        int redirct=0;//指针移动方向。0，1，2，3。0：向右。1：向下。2：向左。3：向上

        while (t<=b && l<=r){

            output.add(matrix[row][col]);

            //变换方向  //缩小边界
            if(col == r && redirct==0){//向右移动，并且移动到边界时，变换方向为向下，且上边界下移
                redirct=(redirct+1)%4;//变换方向
                t++;//缩小边界
            }
            else if (row == b && redirct ==1){ //向下移动，并且移动到边界时，变换方向为左，且右边界左移
                redirct=(redirct+1)%4;
                r--;
            }
            else if(col==l && redirct==2) {//向左移动，并且移动到边界时，变换方向为右，且下边界上移
                redirct=(redirct+1)%4;
                b--;
            }
            else if(row == t && redirct==3){//向上移动，并且移动到边界时，变换方向为右，且左边界右移
                redirct=(redirct+1)%4;
                l++;
            }
            //移动指针，根据不同方向，不同的移动
            if(redirct==0){
                col++;
            }
            else if(redirct==1){
                row++;
            }
            else if(redirct==2){
                col--;
            }
            else if(redirct==3){
                row--;
            }
        }
        return output;
    }
}
