package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;

public class Leetcode3099Solution extends AbstractSolution {
    @Handler
    public int sumOfTheDigitsOfHarshadNumber(Integer x) {
        int ori = x;
        int sum = 0;
        while(x>0){
            sum += x%10;
            x /= 10;
        }
        if(ori%sum==0){
            return sum;
        }else{
            return -1;
        }
    }

    @Case
    public Integer test1(){
        return 18;
    }
}
