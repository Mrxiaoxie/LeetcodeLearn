package com.benshell.pipeline.stack;

public class TargetSum {

    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,target,0,0);
        return count;
    }

    public void dfs(int[] nums,int target,int index, int sum){
        if(index == nums.length && sum == target){
            count ++;
            return;
        }
        if(index >= nums.length){
            return ;
        }
        dfs(nums,target,index + 1,sum - nums[index]);
        dfs(nums, target, index + 1, sum + nums[index]);
    }


    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;
        System.out.println(targetSum.findTargetSumWays(nums,target));
    }
}
