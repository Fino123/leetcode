
public class Leetcode3099Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
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

    public void test(){
        Leetcode3099Solution solution = new Leetcode3099Solution();
        System.out.println(solution.sumOfTheDigitsOfHarshadNumber(18));
    }
}
