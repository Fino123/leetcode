package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode554Solution extends AbstractSolution {
    @Handler
    public int maxPalindromesAfterOperations(String[] words) {
        int n = 0;
        int oddSet = 0;
        for (String word : words) {
            n += word.length();
            for (char c : word.toCharArray()) {
                oddSet ^= 1<<(c - 'a');
            }
        }
        n -= Integer.bitCount(oddSet);
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int result = 0;
        for (int i=0; i<words.length; i++) {
            if (words[i].length() == 1){
                result++;
                continue;
            }
            if (words[i].length() % 2 == 0){
                n -= words[i].length();
            }else {
                n -= (words[i].length()-1);
            }
            if (n<0){
                break;
            }
            result++;
        }
        return result;
    }

    @Case(enable = true)
    public String[] case1(){
        return new String[]{"abbb","ba","aa"};
    }

    @Case(enable = true)
    public String[] case2(){
        return new String[]{"abc","ab"};
    }

    @Case
    public String[] case3(){
        return new String[]{"cd","ef","a"};
    }
}
