
public class DeleteNode237 {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;

        node.next = node.next.next;
    }

}

class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

}
