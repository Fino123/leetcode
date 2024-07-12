import leetcode.Solution;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException{
        String clzNameFormatter = "leetcode.Leetcode%sSolution";
        System.out.println("请输入题目序号：");
        Scanner scanner = new Scanner(System.in);
        int qNum = scanner.nextInt();
        Class<?> solutionClz = Class.forName(String.format(clzNameFormatter, qNum));
        try {
            Solution solution = (Solution) solutionClz.newInstance();
            solution.test();
        }catch (Exception e){
            System.err.println("执行测试用例时出错：" + e.getMessage());
        }
    }
}
