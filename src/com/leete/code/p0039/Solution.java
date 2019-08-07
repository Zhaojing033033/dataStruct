package com.leete.code.p0039;
import java.util.*;
/**
 * 题目给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的数字可以无限制重复被选取。

 说明：

 所有数字（包括 target）都是正整数。
 解集不能包含重复的组合。 
 示例 1:

 输入: candidates = [2,3,6,7], target = 7,
 所求解集为:
 [
 [7],
 [2,2,3]
 ]
 示例 2:

 输入: candidates = [2,3,5], target = 8,
 所求解集为:
 [
   [2,2,2,2],
   [2,3,3],
   [3,5]
 ]
 */

/**
 * 思路:回朔
 */

/**
 * 体会：
 *
 */
public class Solution {

    public static void main(String[] args) {
        int [] aa  =new int[]{4,2,8};
        List<List<Integer>> lists = new Solution().combinationSum(aa, 8);
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> integers = lists.get(i);
            for (int j = 0; j < integers.size(); j++) {
                System.out.print(integers.get(j)+" ");
            }
            System.out.println("");
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(candidates.length==0)
            return output;
        combinationSum(candidates,target,0,new ArrayList<Integer>(),output);
        return output;
    }

    private void combinationSum(int[] candidates,int target,int l,List<Integer> input,List<List<Integer>> ouput){

        for (int i = l; i <candidates.length ; i++) {
            List<Integer> copy=new ArrayList<>(input);

            int sum=0;
            for (int j = 0; j < copy.size(); j++)
                sum=sum+copy.get(j);

            sum=sum+candidates[i];
            if(sum == target){
                copy.add(candidates[i]);
                ouput.add(copy);
                continue;
            }else if(sum>target){
                continue;
            }else {
                copy.add(candidates[i]);
                combinationSum(candidates,target,i,copy,ouput);
            }

        }

    }
}
