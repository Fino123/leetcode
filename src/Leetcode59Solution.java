public class Leetcode59Solution implements Solution{
    public int[][] generateMatrix(int n) {
        int [][]matrix = new int[n][n];
        giveNum(matrix, 0, n-1, 0, n-1, 1);
        return matrix;
    }

    public void giveNum(int [][]matrix, int up, int down, int left, int right, int num){
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

    @Override
    public void test(){

    }
}
