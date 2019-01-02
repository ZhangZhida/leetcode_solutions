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
    public ListNode removeDup(ListNode head) {
      // Write your solution here
      if (head == null || head.next == null) {
        return head;
      }
      ListNode cur = head;
      while (cur != null && cur.next != null) {
        if (cur.next.value == cur.value) {
          cur.next = cur.next.next;
        } else {
          cur = cur.next;
        }
      }
      return head;
    }
  }