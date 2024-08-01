package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;

import java.util.HashMap;
import java.util.Map;

public class Leetcode3Solution extends AbstractSolution{

    @Handler
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()){
            return 0;
        }
        Map<Character, Integer> pos = new HashMap<>();
        int result = Integer.MIN_VALUE;
        int start = 0;
        for (int i=0; i<s.length(); i++){
            if (pos.containsKey(s.charAt(i))){
                int old = start;
                start = pos.get(s.charAt(i))+1;
                for (int j=old; j<start; j++){
                    pos.remove(s.charAt(j));
                }
                i--;
            }else {
                result = Math.max(result, i - start + 1);
                pos.put(s.charAt(i), i);
            }
        }
        return result;
    }

    @Case
    public String case1(){
        return "abcabcbb";
    }

    @Case
    public String case2(){
        return "bbbbb";
    }

    @Case
    public String case3(){
        return "pwwkew";
    }

    @Case
    public String case4(){
        return "abba";
    }
}
