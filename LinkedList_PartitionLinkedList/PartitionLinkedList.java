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
    public ListNode partition(ListNode head, int target) {
      // Write your solution here
      if (head == null || head.next == null) {
        return head;
      }
      ListNode left = new ListNode(0);
      ListNode cur1 = left;
      ListNode right = new ListNode(0);
      ListNode cur2 = right;
      while (head != null) {
        if (head.value < target) {
          cur1.next = head;
          cur1 = cur1.next;
        } else {
          cur2.next = head;
          cur2 = cur2.next;
        }
        head = head.next;
      }
      cur1.next = right.next;
      cur2.next = null;
      return left.next;
    }
  }
  