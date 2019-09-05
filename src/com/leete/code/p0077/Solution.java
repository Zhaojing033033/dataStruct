package com.leete.code.p0077;

/**
 * 题目
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

 示例:

 输入: n = 4, k = 2
 输出:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/combinations
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 思路
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 体会：
 *
 */
public class Solution {
    int n;
    int k;
    List<List<Integer>> output=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
       this.n = n;
       this.k = k;
       backup(1,new LinkedList <Integer>());
       return output;
    }

    public void backup(int i,LinkedList<Integer> subList){
        if(subList.size()==k){
            output.add(new ArrayList<>(subList));
            return;
        }

        for (int j = i; j <= n; j++) {
            subList.add(j);
            backup(j+1,subList);
            subList.removeLast();
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new Solution().combine(4, 2);
        for (int i = 0; i < combine.size(); i++) {
            List<Integer> integers = combine.get(i);
            for (int i1 = 0; i1 < integers.size(); i1++) {
                System.out.print(integers.get(i1));
            }
            System.out.println("");
        }
    }
}
