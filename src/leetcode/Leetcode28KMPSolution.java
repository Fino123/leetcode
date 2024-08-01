package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;

import java.util.Arrays;

//kmp字符串匹配算法
public class Leetcode28KMPSolution extends AbstractSolution {

    @Handler
    public int strStr(String[] param) {
        String ss = param[0];
        String pp = param[1];
        if (ss.length()<pp.length()) {
            return -1;
        }
        char[] ppChars = pp.toCharArray();
        char[] ssChars = ss.toCharArray();
        int []next = new int[pp.length()];
        next[0] = 0;
        int j=0;
        for (int i=1;i<pp.length();i++) {
            while(j>0 && ppChars[j]!=ppChars[i]){
                j = next[j-1];
            }
            if (ppChars[i]==ppChars[j]){
                next[i] = j+1;
                j++;
            }else{
                next[i] = 0;
            }
        }
        System.out.println(Arrays.toString(next));
        j = 0;
        for (int i = 0;i<ssChars.length;i++) {
            while(j>0 && ssChars[i]!=ppChars[j]){
                j = next[j-1];
            }
            if (ssChars[i]==ppChars[j]){
                j++;
            }
            if (j==ppChars.length){
                return i-ppChars.length+1;
            }
        }
        return -1;
    }

    @Case("官网测试用例1")
    public String[] case1(){
        return new String[]{"sadbutsad", "sad"};
    }

    @Case("官网自测用例2")
    public String[] case2(){
        return new String[]{"leetcode", "leeto"};
    }

    @Case("题解测试用例1")
    public String[] case3(){
        return new String[]{"abeababeabf", "abeabf"};
    }

    @Case
    public String[] case4(){
        return new String[]{"aaacecaaa", "aacecaaa"};
    }
}
