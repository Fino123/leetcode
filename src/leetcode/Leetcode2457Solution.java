package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode2457Solution extends AbstractSolution{
    @Handler
    public long makeIntegerBeautiful(List<Object> input) {
        long n = (Long) input.get(0);
        int target = (Integer) input.get(1);
        long tempN = n;
        int sum = 0;
        List<Long> nums = new ArrayList<>();
        while(n>0){
            nums.add(n%10);
            sum += nums.get(nums.size()-1);
            n/=10;
        }
        for (int i=0; i<nums.size(); i++){
            if (sum>target){
                sum -= nums.get(i);
                sum += 1;
                nums.set(i, 0L);
                if (i+1<nums.size())
                    nums.set(i+1, nums.get(i+1)+1);
                else
                    nums.add(1L);
            }
        }
        long result = 0;
        for (int i=0; i<nums.size(); i++){
            result += nums.get(i) * (int) Math.pow(10, i);
        }
        return result - tempN;
    }

    @Case("case1")
    public List<Object> case1(){
        return Arrays.asList(16L, 6);
    }

    @Case("case2")
    public List<Object> case2(){
        return Arrays.asList(467L, 6);
    }
}
