package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;

import java.util.Arrays;

public class Leetcode45Solution extends AbstractSolution {

    @Handler
    public int jump(Integer[] nums) {
        int []times = new int[nums.length];
        Arrays.fill(times, Integer.MAX_VALUE);
        times[0] = 0;
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<=nums[i]+i && j<nums.length; j++){
                times[j] = Math.min(times[j], times[i]+1);
            }
        }
        return times[nums.length-1];
    }

    @Case
    public Integer[] test1() {
        return new Integer[]{2,3,1,1,4};
    }
}
