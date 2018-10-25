

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HashMap_TopKFrequentWords {

    public static void main(String[] args) {
	// write your code here
        String[] combo = {"d","a","c","b","d","a","b","b","a","d","d","a","d"};
        int k = 5;

        Solution solution = new Solution();
        String[] result = solution.topKFrequent(combo, k);
        System.out.println(result);
    }



}

class Solution {

    public String[] topKFrequent(String[] combo, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        getHashMap(combo, map);

        PriorityQueue<Map.Entry<String, Integer> > pq = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer> >() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if(e1.getValue() < e2.getValue())
                    return -1;
                else if(e1.getValue() == e2.getValue())
                    return 0;
                else
                    return 1;
            }
        } );

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(pq.size() < k) {
                pq.offer(entry);
            } else {
                if(entry.getValue() > pq.peek().getValue()) {
                    pq.poll();
                    pq.offer(entry);
                }
            }

        }

        String[] topK = new String[pq.size()];
        int i = pq.size() - 1;
        while(i >= 0) {
            topK[i] = pq.poll().getKey();
            i--;
        }

        return topK;
    }

    public void getHashMap(String[] strs, Map<String, Integer> map) {
        for (String s : strs) {
            Integer value = map.get(s);
            if (value == null) {
                map.put(s, 1);
            } else {
                map.put(s, value + 1);
            }
        }
    }
}
