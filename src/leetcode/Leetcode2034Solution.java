package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;
import leetcode.entity.StockPrice;

import java.util.Arrays;

public class Leetcode2034Solution extends AbstractSolution{
    @Handler
    public void myTest(StockPrice stockPrice){
        stockPrice.update(1, 10);
        stockPrice.update(2,5);
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        stockPrice.update(1, 3);
        System.out.println(stockPrice.maximum());
        stockPrice.update(4, 2);
        System.out.println(stockPrice.minimum());
    }

    @Case
    public StockPrice case1(){
        return new StockPrice();
    }

    @Override
    public String outputArgumentToString(Object o){
        return "";
    }

}
