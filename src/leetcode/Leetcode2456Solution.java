package leetcode;

import leetcode.annotation.Case;
import leetcode.annotation.Handler;

import java.util.*;

public class Leetcode2456Solution extends AbstractSolution{
    @Handler
    public List<List<String>> mostPopularCreator(List<Object> input) {
        //String[] creators, String[] ids, int[] views
        String[] creators = (String[]) input.get(0);
        String[] ids = (String[]) input.get(1);
        int[] views = (int[]) input.get(2);
        int n = creators.length;
        HashMap<String, Long> popular = new HashMap<>();
        HashMap<String, PriorityQueue<Video>> name2queue = new HashMap<>();
        for (int i=0; i<n; i++){
            String name = creators[i];
            Long hisPopular = popular.getOrDefault(name, 0L);
            hisPopular += views[i];
            popular.put(name, hisPopular);
            PriorityQueue<Video> queue = name2queue.getOrDefault(name, null);
            if (queue==null){
                queue = new PriorityQueue<>();
                name2queue.put(name, queue);
            }
            Video video = new Video(ids[i], views[i]);
            queue.offer(video);
        }
        List<Map.Entry<String, Long>> entries = new ArrayList<>(popular.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                return Long.signum(o2.getValue() - o1.getValue());
            }
        });
        List<List<String>> result = new ArrayList<>();
        long maxView = Long.MIN_VALUE;
        for (int i=0; i<entries.size(); i++){
            List<String> singleton = new ArrayList<>();
            String name = entries.get(i).getKey();
            long value = entries.get(i).getValue();
            if (value>=maxView){
                singleton.add(name);
                singleton.add(name2queue.get(name).peek().getName());
                maxView = value;
                result.add(singleton);
            }
        }
        return result;
    }

    @Case("case1")
    public List<Object> case1(){
        List<Object> data = new ArrayList<>();
        data.add(new String[]{"alice","bob","alice","chris"});
        data.add(new String[]{"one","two","three","four"});
        data.add(new int[]{5,10,5,4});
        return data;
    }

    @Case("case2")
    public List<Object> case2(){
        List<Object> data = new ArrayList<>();
        data.add(new String[]{"alice","alice","alice"});
        data.add(new String[]{"a","b","c"});
        data.add(new int[]{1,2,2});
        return data;
    }

    private static class Video implements Comparable<Video>{
        private String name;
        private long view;

        public void setName(String name) {
            this.name = name;
        }

        public void setView(long view) {
            this.view = view;
        }

        public String getName() {
            return name;
        }

        public long getView() {
            return view;
        }

        public Video(String name, int view) {
            this.name = name;
            this.view = view;
        }

        @Override
        public int compareTo(Video o) {
            long viewCompare = Long.compare(o.getView(), view);
            if (viewCompare==0){
                return name.compareTo(o.getName());
            }
            return Long.signum(viewCompare);
        }
    }
}
