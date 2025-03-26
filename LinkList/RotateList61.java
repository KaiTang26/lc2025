package LinkList;

public class RotateList61 {

    public static void main(String[] args) {
        

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode node =

        while (node != null) {

            System.out.println(node.val);
            node = node.next;

        }



    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0) {
            return head;
        }

        int size = 0;

        ListNode count = head;

        while (count != null) {
            count = count.next;
            size++;
        }

        int rotation = k > size ? k % size : k;

        if (rotation == 0) {
            return head;
        }

        System.out.println("rotation: " + rotation);
        System.out.println("size: " + size);

        ListNode reversHead = reverse(head);

        ListNode kNodePre = reversHead;

        for (int i = 0; i < rotation - 1; i++) {
            kNodePre = kNodePre.next;
        }

        ListNode kNode = kNodePre.next;
        kNodePre.next = null;

        head = reverse(reversHead);
        reversHead.next = reverse(kNode);

        return head;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode curr = node;

        while (curr != null) {

            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        return pre;
    }

}
