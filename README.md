# leetcode
保存平时练习leetcode的测试用例。
运行Main.java中的main函数，按提示输入题号即可。
```java
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
```
