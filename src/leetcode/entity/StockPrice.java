package leetcode.entity;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StockPrice {
    private final PriorityQueue<PricePair> timestampMaximumTree;
    private final PriorityQueue<PricePair> priceMaximumTree;
    private final PriorityQueue<PricePair> priceMinimumTree;
    private final Map<Integer, PricePair> pricePairMap;

    public StockPrice() {
        timestampMaximumTree = new PriorityQueue<>(new Comparator<PricePair>() {
            @Override
            public int compare(PricePair o1, PricePair o2) {
                return o2.getTimestamp() - o1.getTimestamp();
            }
        });
        priceMaximumTree = new PriorityQueue<>(new Comparator<PricePair>() {
            @Override
            public int compare(PricePair o1, PricePair o2) {
                return o2.getPrice() - o1.getPrice();
            }
        });
        priceMinimumTree = new PriorityQueue<>(new Comparator<PricePair>() {
            @Override
            public int compare(PricePair o1, PricePair o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
        pricePairMap = new HashMap<>();
    }

    public void update(int timestamp, int price) {
        PricePair node = null;
        if (pricePairMap.containsKey(timestamp)){
            pricePairMap.get(timestamp).setPrice(price);
            node = pricePairMap.get(timestamp);
            timestampMaximumTree.remove(node);
            priceMaximumTree.remove(node);
            priceMinimumTree.remove(node);
        }else{
            pricePairMap.put(timestamp, new PricePair(timestamp, price));
            node = pricePairMap.get(timestamp);
        }
        timestampMaximumTree.offer(node);
        priceMinimumTree.offer(node);
        priceMaximumTree.offer(node);
    }

    public int current() {
        assert timestampMaximumTree.peek() != null;
        return timestampMaximumTree.peek().getPrice();
    }

    public int maximum() {
        assert priceMaximumTree.peek() != null;
        return priceMaximumTree.peek().getPrice();
    }

    public int minimum() {
        assert priceMinimumTree.peek() != null;
        return priceMinimumTree.peek().getPrice();
    }

    public static class PricePair {
        private int timestamp;
        private int price;

        public PricePair(int timestamp, int price) {
            this.timestamp = timestamp;
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object obj) {
            return ((PricePair) obj).getTimestamp() == timestamp;
        }
    }
}
