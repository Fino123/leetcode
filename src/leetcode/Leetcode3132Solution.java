package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;
import leetcode.entity.Pair;

import java.util.Arrays;

public class Leetcode3132Solution extends AbstractSolution{
    @Handler
    public int minimumAddedInteger(Pair<int[], int[]> input) {
        int[] nums1 = input.getKey();
        int[] nums2 = input.getValue();
        int[] longer = nums1.length > nums2.length? nums1 : nums2;
        int[] shorter = nums1.length > nums2.length? nums2 : nums1;
        Arrays.sort(longer);
        Arrays.sort(shorter);
        int min = Integer.MAX_VALUE;
        for (Integer i : new Integer[]{0,1,2}){
            int gap = shorter[0] - longer[i];
            int left = i;
            int right = 0;
            int mis = 0;
            while(right<shorter.length&&left<longer.length){
                if (shorter[right]-longer[left]==gap) {
                    left++;
                    right++;
                }else {
                    left++;
                    mis++;
                    if (mis>2)
                        break;
                }
            }
            if (right==shorter.length){
                min = Math.min(min, gap);
            }
        }
        return min;
    }

    @Case("case1")
    public Pair<int[], int[]> case1(){
        return new Pair<>(new int[]{4,20,16,12,8}, new int[]{14,18,10});
    }

    @Case("case2")
    public Pair<int[], int[]> case2(){
        return new Pair<>(new int[]{3,5,5,3}, new int[]{7,7});
    }


}
