package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractSolution implements Solution {
    @Override
    public void test() throws InvocationTargetException, IllegalAccessException {
        System.out.println("--------------开始执行测试----------------");
        Class<?> clz = this.getClass();
        List<Method> cases = getCaseMethods();
        Method handler = null;
        for (Method method : clz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Handler.class)){
                if (handler == null){
                    handler = method;
                }else{
                    throw new RuntimeException("Handler方法只能有一个");
                }
            }
        }
        if (handler == null){
            throw new RuntimeException("Handler方法没定义");
        }
        int i = 1;
        for (Method caseMethod : cases){
            Object caseData = caseMethod.invoke(this);
            if (caseData == null){
                throw new RuntimeException("输入参数为空");
            }
            Object result = handler.invoke(this, caseData);
            System.out.printf("--------------case:%d----------------\n", i++);
            System.out.println("case信息：" + caseMethod.getAnnotation(Case.class).value());
            System.out.println("输入：");
            System.out.println(inputArgumentToString(caseData));
            System.out.println("结果：");
            System.out.println(outputArgumentToString(result));
        }
    }

    @Override
    public List<Method> getCaseMethods() {
        List<Method> caseMethods = new ArrayList<>();
        Class<?> clz = this.getClass();
        for (Method method : clz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Case.class)){
                caseMethods.add(method);
            }
        }
        return caseMethods;
    }

    @Override
    public String inputArgumentToString(Object o){
        return o.getClass().isArray()? Arrays.toString((Object[]) o): o.toString();
    }

    @Override
    public String outputArgumentToString(Object o){
        return o.getClass().isArray()? Arrays.toString((Object[]) o): o.toString();
    }
}
