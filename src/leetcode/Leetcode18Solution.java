package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;

import java.util.*;

// https://leetcode.cn/problems/4sum/
public class Leetcode18Solution extends AbstractSolution implements Solution{
    @Handler
    public List<List<Integer>> fourSum(Integer []param) {
        int[] params = new int[param.length];
        for (int i = 0; i < params.length; i++) {
            params[i] = param[i];
        }
        int []nums = Arrays.copyOfRange(params, 0, params.length-1);
        int target = param[params.length-1];
        Arrays.sort(nums);
        if (nums.length<4){
            return new ArrayList<>();
        }
        int []next = new int[nums.length];
        int nextAddOn = 1;
        for (int i=nums.length-1; i>=0; i--) {
            next[i] = nextAddOn;
            if (i>0 && nums[i] == nums[i-1]) {
                nextAddOn++;
            } else {
                nextAddOn = 1;
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        Set<String> picked = new HashSet<>();
        helper(nums, target, result, numList, picked, next, 0, 0L);
        return result;
    }

    public void helper(int []nums, int target, List<List<Integer>> result,
                       List<Integer> numList, Set<String> picked, int[]next, int start, long sum) {
        if (numList.size() == 4) {
            if (sum == target) {
                String hash = numList.toString();
                if (!picked.contains(hash)) {
                    result.add(numList);
                    picked.add(hash);
                }
            }
            return;
        }
        for (int i=start; i<nums.length; i += next[i]) {
            int value = nums[i];
            long newSum = sum + value;
            if (value>=0 && newSum > target)
                break;
            numList.add(value);
            if (numList.size()==1){
                long biggestCondition = (long)value+(long)nums[nums.length-1]
                        +(long)nums[nums.length-2]+(long)nums[nums.length-3];
                if (biggestCondition < target) {
                    numList.remove(0);
                    continue;
                }
            }
            List<Integer> newNumList = new ArrayList<>(numList);
            helper(nums, target, result, newNumList, picked, next, i+1, newSum);
            numList.remove(numList.size()-1);
        }
    }

    @Case(enable = false)
    public Integer[] case1(){
        return new Integer[]{1,0,-1,0,-2,2, 0}; //target==0
    }

    @Case(enable = false)
    public Integer[] case2(){
        return new Integer[]{2,2,2,2,2, 8}; //target==8
    }

    @Case(enable = false)
    public Integer[] case3(){
        return new Integer[]{1,-2,-5,-4,-3,3,3,5, -11};
    }

    @Case(enable = false)
    public Integer[] case4(){
        return new Integer[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,20,20,20,20,20
                ,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,30,30,30,30,30,30,30,30,30,30,30,30,30,30,
                30,30,30,30,30,30,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,40,50,50,50,
                50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,60,60,60,60,60,60,60,60,60,60,60,60
                ,60,60,60,60,60,60,60,60,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,
                80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,90,90,90,90,90,90,90,90,90,
                90,90,90,90,90,90,90,90,90,90,90, 200};
    }

    @Case(enable = false)
    public Integer[] case5(){
        return new Integer[]{-1000000000,-1000000000,1000000000,-1000000000,-1000000000, 294967296};
    }

    @Case(enable = false)
    public Integer[] case6(){
        return new Integer[]{1000000000,-1,-1,-1, 999999997};
    }

    @Case
    public Integer[] case7(){
        return new Integer[]{0,0,0,1000000000,1000000000,1000000000,1000000000, 1000000000};
    }
}
