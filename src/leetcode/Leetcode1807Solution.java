package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;
import leetcode.entity.Pair;

import java.util.*;

public class Leetcode1807Solution extends AbstractSolution {
    @Handler
    public String evaluate(Pair<String, List<List<String>>> input) {
        String s = input.getKey();
        List<List<String>> knowledge = input.getValue();
        Map<String, String> hash = new HashMap<>();
        for (List<String> arr: knowledge){
            hash.put(arr.get(0), arr.get(1));
        }
        StringBuilder result = new StringBuilder();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='('){
                int posRightQuote = s.indexOf(')', i+1);
                result.append(hash.getOrDefault(s.substring(i+1, s.indexOf(')', posRightQuote)), "?"));
                i = posRightQuote;
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    @Case
    public Pair<String, List<List<String>>> case1(){
        List<List<String>> arr = new ArrayList<>();
        arr.add(Arrays.asList("name","bob"));
        arr.add(Arrays.asList("age","two"));
        return new Pair<>("(name)is(age)yearsold", arr);
    }

    @Case
    public Pair<String, List<List<String>>> case2(){
        List<List<String>> arr = new ArrayList<>();
        arr.add(Arrays.asList("a","yes"));
        return new Pair<>("(a)(a)(a)aaa", arr);
    }

    @Case
    public Pair<String, List<List<String>>> case3(){
        List<List<String>> arr = new ArrayList<>();
        arr.add(Arrays.asList("a","b"));
        return new Pair<>("hi(name)", arr);
    }

    @Override
    public String inputArgumentToString(Object o) {
        Pair<String, List<List<String>>> pair = (Pair<String, List<List<String>>>) o;
        StringBuilder builder = new StringBuilder();
        builder.append("字符串s为：" + pair.getKey() + "\n");
        builder.append("knowledge为：\n");
        for (List<String> list: pair.getValue()){
            builder.append(list);
            builder.append("\n");
        }
        return builder.toString();
    }
}
