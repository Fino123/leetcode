import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException{
        String clzNameFormatter = "Leetcode%sSolution";
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