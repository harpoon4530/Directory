package org.personio;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ComparatorHeap {

    public static Map<String, Integer> mapCount;
    public static PriorityQueue<FreqCount> pq;

    public static class FreqCount implements Comparable<FreqCount> {
        public String str;
        public int freq;

        public FreqCount(String s, int freq) {
            this.str = s;
            this.freq = freq;
        }

        @Override
        public int compareTo(@NotNull FreqCount o) {
            if (this.freq != o.freq) {
                return Integer.compare(this.freq, o.freq);
            }
            return Integer.compare(o.str.length(), this.str.length());
        }
    }

//    public static class FreqCount {
//        public String str;
//        public int freq;
//
//        public FreqCount(String s, int freq) {
//            this.str = s;
//            this.freq = freq;
//        }
//
//    }

    public static class FreqCountComprator implements  Comparator<FreqCount> {

    @Override
    public int compare(FreqCount o1, FreqCount o2) {
//        if (o2.freq == o1.freq) {
//            return Integer.compare(o2.freq, o1.freq);
//        }
            return Integer.compare(o2.str.length(), o1.str.length());
        }
    }

    public static void main(String[] args) {

        //pq = new PriorityQueue<>();
        pq = new PriorityQueue<>(new FreqCountComprator());
        mapCount = new HashMap();

        System.out.println("Hello world....!");

        List<String> stream = Arrays.asList("apple", "banana", "apple", "cherry", "date", "banana", "elderberry");
        String result = lowestFreqCount(stream);
        System.out.println(result);
    }


    public static String lowestFreqCount(List<String> stream) {

        for (String s : stream) {

            int currentCount = mapCount.getOrDefault(s, 0);
            mapCount.put(s, currentCount + 1);

            // Remove old entry for this string if it exists
            //pq.removeIf(info -> info.str.equals(s));
            pq.removeIf(info -> s.equals(info.str));

            pq.add(new FreqCount(s, currentCount+1));
            
        }

        return pq.isEmpty() ? null : pq.peek().str;
    }

}
