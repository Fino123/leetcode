package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;

public class Leetcode14Solution extends AbstractSolution {

    @Handler
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==1){
            return strs[0];
        }
        if (strs==null || strs.length==0){
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length-1);
    }

    public String longestCommonPrefix(String[] strs, int left, int right){
        if (left==right){
            return strs[left];
        }
        int mid = left + (right-left)/2;
        String p1 = longestCommonPrefix(strs, left, mid);
        String p2 = longestCommonPrefix(strs, mid+1, right);
        return commonPrefix(p1, p2);
    }

    public String commonPrefix(String s1, String s2){
        String shorter = s1.length()>s2.length()?s2:s1;
        String longer = s1.length()>s2.length()?s1:s2;
        for (int i=0; i<shorter.length(); i++){
            if (shorter.charAt(i)!=longer.charAt(i)){
                return shorter.substring(0, i);
            }
        }
        return shorter;
    }

    @Case("官方测试用例1")
    public String[] test1(){
        String[] strs = {"flower","flow","flight"};
        return strs;
    }

}
