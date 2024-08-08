package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Leetcode2231Solution extends AbstractSolution{
    @Handler
    public int largestInteger(int num) {
        List<Integer> nums = new LinkedList<>();
        while(num!=0){
            nums.add(num%10);
            num/=10;
        }
        Collections.reverse(nums);
        for (int i=0; i<nums.size()-1; i++){
            int maxIndex = i;
            for (int j=i+1; j<nums.size(); j++){
                if (canChange(nums.get(i), nums.get(j))){
                    if (nums.get(j)>nums.get(maxIndex)){
                        maxIndex = j;
                    }
                }
            }
            int temp = nums.get(maxIndex);
            nums.set(maxIndex, nums.get(i));
            nums.set(i, temp);
        }
        int result = 0;
        for (Integer integer : nums) {
            result *= 10;
            result += integer;
        }
        return result;
    }

    private boolean canChange(int num1, int num2) {
        return num1 % 2 == num2 % 2;
    }

    @Case
    public int case1(){
        return 1234;
    }

    @Case
    public int case2(){
        return 65875;
    }

}
