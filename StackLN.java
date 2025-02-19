public class StackLN {

    ListNode dummy;

    public StackLN() {
        dummy = new ListNode(-1);
    }

    public void push(int val) {

        ListNode newNode = new ListNode(val);
        newNode.next = dummy.next;
        dummy.next = newNode;
    }

    public int pop() {
        int returnVal = dummy.next.val;
        dummy.next = dummy.next.next;
        return returnVal;
    }

    public int peek() {
        int returnVal = dummy.next.val;
        return returnVal;
    }

    public boolean isEmpty() {

        return dummy.next == null;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}