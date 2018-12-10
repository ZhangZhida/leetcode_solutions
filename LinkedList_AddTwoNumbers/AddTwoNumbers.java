// Example

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)

// Output: 7 -> 0 -> 8

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      // Write your solution here
      ListNode dummy = new ListNode(0);
      ListNode cur = dummy;
      int inc = 0;
      while ((l1 != null && l2 != null)) {
        int mod = (l1.value + l2.value + inc) % 10;
        cur.next = new ListNode(mod);
        inc = (l1.value + l2.value + inc) / 10;
        cur = cur.next;
        l1 = l1.next;
        l2 = l2.next;
      }
      // post-processing: in case l1 or l2 is not null
      if(l1 != null || l2 == null) {
        while (l1 != null) {
          int mod = (l1.value + inc) % 10;
          cur.next = new ListNode(mod);
          cur = cur.next;
          inc = (l1.value + inc) / 10;;
          l1 = l1.next;
        }
      } else {
        while (l2 != null) {
          int mod = (l2.value + inc) % 10;
          cur.next = new ListNode(mod);
          cur = cur.next;
          inc = (l2.value + inc) / 10;
          l2 = l2.next;
        }
      }
      if (inc != 0) {
        cur.next = new ListNode(inc);
      }
      return dummy.next;
    }
  }