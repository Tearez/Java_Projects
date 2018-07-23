public class Main {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(3);
        node.next.next.next.next.next = new ListNode(3);

        ListNode result = Solution.deleteDuplicates(node);

        while (result != null) {
            System.out.print(" " + result.val);
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
        public static ListNode deleteDuplicates(ListNode head) {
            ListNode result = new ListNode(-123);
            ListNode node = result;

            int current = -1000;
            while (head != null) {
                if (head.val != current) {
                    node.next = new ListNode(head.val);
                    node = node.next;
                    if(head.next != null){
                        current = head.val;
                    }
                }
                head = head.next;

            }

            return result.next;
        }
    }
}
