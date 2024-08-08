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

# 新增题解
需要继承自AbstractSolution；
通过@Handler注解标记题解方法；
通过@Case注解设置输入样例；
保证输入和输出类型一致；
例如
```java
public class Leetcode14Solution extends AbstractSolution {

    @Handler
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==1){
            return strs[0];
        }
        if (strs==null || strs.length==0){
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length-1);
    }

    public String longestCommonPrefix(String[] strs, int left, int right){
        if (left==right){
            return strs[left];
        }
        int mid = left + (right-left)/2;
        String p1 = longestCommonPrefix(strs, left, mid);
        String p2 = longestCommonPrefix(strs, mid+1, right);
        return commonPrefix(p1, p2);
    }

    public String commonPrefix(String s1, String s2){
        String shorter = s1.length()>s2.length()?s2:s1;
        String longer = s1.length()>s2.length()?s1:s2;
        for (int i=0; i<shorter.length(); i++){
            if (shorter.charAt(i)!=longer.charAt(i)){
                return shorter.substring(0, i);
            }
        }
        return shorter;
    }

    @Case("官方测试用例1")
    public String[] test1(){
        String[] strs = {"flower","flow","flight"};
        return strs;
    }

}
```

