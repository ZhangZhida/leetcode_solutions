// Data structure: two stacks
// Time: 
//      poll():     amortized O(1), worst O(n)
//      offer():    O(1)
//      size():     O(1)
//      isEmpty():  O(1)
// Space:
//      O(1), not including two stacks

public class Solution {
  
    private LinkedList<Integer> s1;
    private LinkedList<Integer> s2;
    
    public Solution() {
      s1 = new LinkedList<>(); // every time we add a elem, we offer it into s1
      s2 = new LinkedList<>(); // every time we remove a elem, we poll it from s2
    }
    
    public Integer poll() {
      if (s1.size() + s2.size() == 0) {
        return null;
      }
      if (s2.size() != 0) {
        return s2.poll();
      } else {
        while (s1.size() > 0) {
          s2.offer(s1.poll());
        }
        return s2.poll();
      }
    }
    
    public void offer(int element) {
      s1.offer(element);
    }
    
    public Integer peek() {
      if (s1.size() + s2.size() == 0) {
        return null;
      }
      if (s2.size() != 0) {
        return s2.peek();
      } else {
        while (s1.size() > 0) {
          s2.offer(s1.poll());
        }
        return s2.peek();
      }
    }
    
    public int size() {
      return s1.size() + s2.size();
    }
    
    public boolean isEmpty() {
      return size() == 0;
    }
  }