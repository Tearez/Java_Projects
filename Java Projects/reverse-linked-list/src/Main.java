import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = Solution.reverseList(head);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public static ListNode reverseList(ListNode head) {
            ListNode node = head;
            ListNode previous = null;
            ListNode next = null;

            while (node != null) {
                next = node.next;
                node.next = previous;
                previous = node;
                node = next;
            }
            node = previous;
            return node;
        }
    }
}
