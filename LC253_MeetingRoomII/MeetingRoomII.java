/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Interval> startHeap = new PriorityQueue<>(new myComparator1());
        for (Interval intv : intervals) {
            startHeap.offer(intv);
        }
        PriorityQueue<Interval> endHeap = new PriorityQueue<>(new myComparator2());
        int roomNum = 0;
        while (!startHeap.isEmpty()) {
            Interval intv = startHeap.poll();
            if (endHeap.isEmpty()) {
                endHeap.offer(intv);
                roomNum++;
            } else {
                if (endHeap.peek().end <= intv.start) {
                    endHeap.poll();
                    endHeap.offer(intv);
                } else {
                    endHeap.offer(intv);
                    roomNum++;
                }
            }
        }
        return roomNum;
    }
}

class myComparator1 implements Comparator<Interval> {
    @Override
    public int compare(Interval int1, Interval int2) {
        if (int1.start == int2.start) {
            return 0;
        } else {
            return int1.start < int2.start ? -1 : 1;
        }
    }
}

class myComparator2 implements Comparator<Interval> {
    @Override 
    public int compare(Interval int1, Interval int2) {
        if (int1.end == int2.end) {
            return 0;
        } else {
            return int1.end < int2.end ? -1 : 1;
        }     
    }  
}