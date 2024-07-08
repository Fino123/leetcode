import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode179Solution implements Solution{
    public String largestNumber(int[] nums) {
        List<String> numStr = new ArrayList<>();
        for (int num : nums){
            numStr.add(String.valueOf(num));
        }
        Collections.sort(numStr, (s1, s2) -> {
            String s1s2 = s1 + s2;
            String s2s1 = s2 + s1;
            if (s1s2.length()==s2s1.length()){
                for (int i=0; i<s1s2.length(); i++){
                    if (s1s2.charAt(i)!=s2s1.charAt(i)){
                        return s1s2.charAt(i)-s2s1.charAt(i);
                    }
                }
                return 0;
            }else{
                return s1s2.length() - s2s1.length();
            }
        });
        StringBuilder result = new StringBuilder();
        for (int i=numStr.size()-1; i>=0; i--){
            result.append(numStr.get(i));
        }
        result.reverse();
        while(result.length()>0 && result.charAt(result.length()-1)=='0'){
            result.deleteCharAt(result.length()-1);
        }
        if (result.length()==0){
            return "0";
        }
        else {
            return result.reverse().toString();
        }
    }

    @Override
    public void test(){
        int []num = {3,30,34,5,9};
        System.out.println(largestNumber(num));
    }
}
