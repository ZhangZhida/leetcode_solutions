// Data Structure
// Time: O(n)
// Space: O(1)

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
    public ListNode cycleNode(ListNode head) {
      // write your solution here
      if (head == null || head.next == null) {
        return null;
      }
      ListNode fast = head;
      ListNode slow = head;
      ListNode cur = null;
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
          cur = slow;
          slow = head;
          while (slow != cur) {
            slow = slow.next;
            cur = cur.next;
          }
          return cur;
        }
      }
      return null;
    }
  }