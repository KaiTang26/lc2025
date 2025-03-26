package LinkList;

public class CopyListWithRandomPointer138 {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);

        n1.next = n2;
        n1.random = n2;
        n2.random = n2;

        CopyListWithRandomPointer138 c = new CopyListWithRandomPointer138();
        Node node = c.copyRandomList(n1);

        while (node != null) {

            System.out.println(node.val);

            node = node.next;

        }
    }

    public Node copyRandomList(Node head) {

        if (head == null) {
            return head;
        }

        Node dummy = new Node(-1);
        dummy.next = head;

        // create deep copy
        while (head != null) {
            Node copyNode = new Node(head.val);
            copyNode.next = head.next;
            head.next = copyNode;
            head = head.next.next;
        }

        head = dummy.next;

        while (head != null && head.next != null) {

            if (head.random != null) {
                head.next.random = head.random.next;
            }

            head = head.next.next;
        }

        head = dummy.next;

        dummy.next = dummy.next.next;

        while (head != null && head.next != null) {
            Node temp = head.next;
            head.next = head.next.next;
            head = temp;

        }

        return dummy.next;

    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
