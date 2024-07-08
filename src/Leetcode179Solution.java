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
            int longerLen = Math.max(s1.length(), s2.length());
            for (int i=0; i<longerLen; i++){
                char c1 = i<s1.length()? s1.charAt(i):'0';
                char c2 = i<s2.length()? s2.charAt(i):'0';
                if (c1 != c2) {
                    return c1 - c2;
                }
            }
            return s2.length()-s1.length();
        });
        StringBuilder result = new StringBuilder();
        for (int i=numStr.size()-1; i>=0; i--){
            result.append(numStr.get(i));
        }
        return result.toString();
    }

    @Override
    public void test(){
        int []num = {10, 2};
        System.out.println(largestNumber(num));
    }
}
