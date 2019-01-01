// Data Structure
// Time: O(nlogk), where k is the num of list in listOfLists
// Space: O(k)

/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
    public ListNode merge(List<ListNode> listOfLists) {
      // Write your solution here/.
      if (listOfLists == null) {
        return null;
      }
      for (ListNode node : listOfLists) {
        if (node == null) {
          return null;
        }
      }
      
      int listNum = listOfLists.size();
      ListNode dummy = new ListNode(0);
      ListNode cur = dummy;
      PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new MyComparator());
      for (int i = 0; i < listNum; i++) {
        if (listOfLists.get(i) != null) {
          minHeap.offer(listOfLists.get(i));
        }
      }
      while (!minHeap.isEmpty()) {
        ListNode node = minHeap.poll();
        cur.next = node;
        cur = cur.next;
        if (node.next != null) {
          minHeap.offer(node.next);
        }
      }
      return dummy.next;
    }
    
    static class MyComparator implements Comparator<ListNode> {
      @Override
      public int compare(ListNode a, ListNode b) {
        if (a.value == b.value) {
          return 0;
        } else {
          return a.value < b.value ? -1 : 1;
        }
      }
    }
    
  }