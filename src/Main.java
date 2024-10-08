import leetcode.Solution;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        String clzNameFormatter = "leetcode.Leetcode%sSolution";
        System.out.println("请输入题目名称：");
        Scanner scanner = new Scanner(System.in);
        String qName = scanner.nextLine();
        Class<?> solutionClz = Class.forName(String.format(clzNameFormatter, qName));
        try {
            Solution solution = (Solution) solutionClz.newInstance();
            solution.test();
        }catch (Exception e){
            throw e;
        }
    }
}
