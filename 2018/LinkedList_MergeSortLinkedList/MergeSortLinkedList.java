class MergeSortLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        mergeSort(head);
    }

    public static ListNode mergeSort(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        head.printout();
        ListNode newHead = helper(head);
        System.out.println();
        newHead.printout();
        
        return newHead;
    }

    private static ListNode helper(ListNode head) {
        if (head.next == null) {
            ListNode newHead = new ListNode(head.value);
            return newHead;
        }

        ListNode mid = findMidNode(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = head;

        right = reverse(right);
        ListNode newHead1 = helper(left);
        ListNode newHead2 = helper(right);

        ListNode newHead = merge(newHead1, newHead2);
        return newHead;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.value <= right.value) {
                cur.next = left;
                left = left.next;
                cur = cur.next;
            } else {
                cur.next = right;
                right = right.next;
                cur = cur.next;
            }
        }
        if (left != null) {
            cur.next = left;
        } else if (right != null) {
            cur.next = right;
        }
        return dummy.next;
    }

    private static ListNode findMidNode(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
        next = null;
    }
    public void printout() {
        ListNode temp = next;
        System.out.println(value);
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
