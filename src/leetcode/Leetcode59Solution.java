package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;

import java.util.Arrays;

public class Leetcode59Solution extends AbstractSolution {

    @Handler
    public Integer[][] generateMatrix(Integer n) {
        Integer [][]matrix = new Integer[n][n];
        giveNum(matrix, 0, n-1, 0, n-1, 1);
        return matrix;
    }

    public void giveNum(Integer [][]matrix, int up, int down, int left, int right, int num){
        if(up>down || right<left)
            return;
        int n = matrix.length;
        if(up<0||up>=n){
            return;
        }
        if(down<0||down>=n){
            return;
        }
        if(left<0||left>=n){
            return;
        }
        if(right<0||right>=n){
            return;
        }
        for(int i=left; i<=right; i++){
            matrix[up][i] = num;
            if(i!=right)
                num++;
        }
        for(int i=up; i<=down; i++){
            matrix[i][right] = num;
            if(i!=down)
                num++;
        }
        if(down>up){
            for(int i=right; i>=left; i--){
                matrix[down][i] = num;
                if(i!=left)
                    num++;
            }
        }
        if(right>left){
            for(int i=down; i>up; i--){
                matrix[i][left] = num;
                num++;
            }
        }
        giveNum(matrix, up+1, down-1, left+1, right-1, num);
    }

    @Case
    public Integer test1(){
        return 3;
    }

    @Case
    public Integer test2(){
        return 4;
    }

    @Override
    public String outputArgumentToString(Object o){
        Integer [][]matrix = (Integer[][])o;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<matrix.length; i++) {
            sb.append(Arrays.toString(matrix[i]));
            sb.append("\n");
        }
        return sb.toString();
    }
}
