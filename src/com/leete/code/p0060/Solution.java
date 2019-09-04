package com.leete.code.p0060;

/**
 * 题目
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * <p>
 * 思路
 * <p>
 * 思路
 */

/**
 * 思路
 * 回朔+剪枝：剪枝时遇到问题。不剪枝超时
 */

/**
 * 体会：
 *
 */
public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder output = new StringBuilder();
        getPermutation("", n, k, 0, output);
        return output.toString();
    }

    public int getPermutation(String input, int n, int k, int count, StringBuilder output) {
        if (input.length() == n) {
            count++;
            if (count == k) {
                output.append(input);
                return count;
            }
            return count;
        }

        int i = 1;
        while (i <= n) {
            //count < k，找到第K个排序，后面的分支 不继续。
            // input.indexOf(i + "") < 0 遇到重复的数字，当前分支不继续
            if (count < k && input.indexOf(i + "") < 0) {
                //每个分支符合要求的排列的个数 ,后面分支就不需要真的去递归，直接通过计算，计算出
                int count_ = getPermutation(input + i, n, k, count, output);
                if(count_==k)
                    return k;
                int branch= count_ - count;
                if(branch>0){
                    for (int j = i; j <= n; j++) {
                        if(count+branch<k ){
                            i++;
                            count=count+branch;
                        }else {
                            break;
                        }
                    }
                }else {
                    i++;
                }
            }else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //String permutation = new Solution().getPermutation(9, 305645);
        String permutation = new Solution().getPermutation(4, 11);//2413
        //String permutation = new Solution().getPermutation(3, 3);//213
        //String permutation = new Solution().getPermutation(3, 2);//132
        System.out.println(permutation);
    }
}
