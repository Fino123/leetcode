package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;

import java.util.ArrayList;
import java.util.List;

public class Leetcode43Solution extends AbstractSolution {
    @Handler
    public String multiply(String[] params) {
        String num1 = params[0];
        String num2 = params[1];
        String upNum = num1.length() >= num2.length() ? num1 : num2;
        String downNum = num1.length() >= num2.length() ? num2 : num1;
        List<String> nums = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<downNum.length(); i++){
            int add = 0;
            int mul1 = downNum.charAt(downNum.length()-i-1)-'0';
            StringBuilder temp = new StringBuilder();
            for (int j=0; j<i; j++) temp.append(0);
            for (int j=0; j<upNum.length(); j++){
                int mul2 = upNum.charAt(upNum.length()-j-1)-'0';
                int mulResult = mul1*mul2 + add;
                add = mulResult / 10;
                temp.append(mulResult%10);
            }
            if (add!=0) temp.append(add);
            nums.add(temp.toString());
        }
        String[] numsArr = nums.toArray(new String[0]);
        int add = 0;
        for (int i=0; i<numsArr[numsArr.length-1].length(); i++){
            int cur = 0;
            for (String s : numsArr) {
                if (i < s.length()) {
                    cur += s.charAt(i) - '0';
                }
            }
            cur += add;
            add = cur / 10;
            result.append(cur%10);
        }
        if (add!=0) result.append(add);
        for (int i=result.length()-1; i>=0; i--){
            if (result.charAt(i) == '0') result.deleteCharAt(i);
            else break;
        }
        if (result.length()==0) return "0";
        return result.reverse().toString();
    }

    @Case
    public String[] test1(){
        return new String[]{"9133", "0"};
    }
}
