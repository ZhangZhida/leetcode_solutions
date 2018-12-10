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
    public boolean isPalindrome(ListNode head) {
      // Write your solution here
      // find middle
      if (head == null) {
        return true;
      }
      if (head.next == null) {
        return true;
      }
      ListNode slow = head;
      ListNode slow2 = head;
      ListNode fast = head;
      while (fast != null && fast.next != null) {
        slow2 = slow;
        slow = slow.next;
        fast = fast.next.next;
      }
      ListNode right = reverse(slow2.next);
      slow2.next = null;
      
      while (head!= null) {
        if (head.value != right.value) {
          return false;
        }
        head = head.next;
        right = right.next;
      }
      return true;
    }
    
    private ListNode reverse(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }
      ListNode newHead = reverse(head.next);
      head.next.next = head;
      return newHead;
    }
  }
  