/*

Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.

Assumptions

the composition is not null and is not guaranteed to be sorted
K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words
Return

a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)
Examples

Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]

*/

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;



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
