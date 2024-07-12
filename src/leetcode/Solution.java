package leetcode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public interface Solution{
    void test() throws InvocationTargetException, IllegalAccessException;
    List<Method> getCaseMethods();
    String inputArgumentToString(Object o);
    String outputArgumentToString(Object o);
}
