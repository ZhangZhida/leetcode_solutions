// Enhance the stack implementation to support min() operation by maintaining a minStack
// Time: min(): O(1), pop(): O(1), push: O(1), top(): O(1)
// Space: min(): O(n)

public class Solution {
    private LinkedList<Integer> s;
    private LinkedList<Integer> minStack;
    public Solution() {
      s = new LinkedList<>();
      minStack = new LinkedList<>();
    }
    
    public int pop() {
      if (s.isEmpty()) {
        return -1;
      }
      if ((int)s.peekFirst() == (int)minStack.peekFirst()) {
        minStack.pollFirst();
      }
      return s.pollFirst();
    }
    
    public void push(int element) {
      s.offerFirst(element);
      if (minStack.isEmpty() || element <= minStack.peekFirst()) {
        minStack.offerFirst(element);
      }
    }
    
    public int top() {
      if (s.isEmpty()) {
        return -1;
      } 
      return s.peekFirst();
    }
    
    public int min() {
      if (minStack.isEmpty()) {
        return -1;
      }
      return minStack.peekFirst();
    }
  }