package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;

public class Leetcode1768Solution extends AbstractSolution implements Solution {
    @Handler
    public String mergeAlternately(String[]params) {
        String word1 = params[0];
        String word2 = params[1];
        StringBuilder sb = new StringBuilder();
        int shorterLen = Math.min(word1.length(), word2.length());
        for (int i = 0; i < shorterLen; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        String longer = word1.length() > word2.length() ? word1 : word2;
        sb.append(longer.substring(shorterLen));
        return sb.toString();
    }

    @Case
    public String[] case1(){
        return new String[]{"abc", "pqr"};
    }

    @Case
    public String[] case2(){
        return new String[]{"ab", "pqrs"};
    }

    @Case
    public String[] case3(){
        return new String[]{"abcd", "pq"};
    }


}
