public class Main {

    public static void main(String[] args) {
        // write your code here
    }

     static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while(slow!=null&& fast !=null){
            slow = slow.next;
            fast = fast.next;
            if (fast != null){
                fast = fast.next;
            }
            if (slow == fast){
                break;
            }
        }
        if (slow == null || fast == null){
            return null;
        }
        fast = head;

        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }
}
