public class LinkedList {

    LinkedNode dummyNode;

    public LinkedList() {
        dummyNode = new LinkedNode(-1);
    }

    public int get(int location) {

        LinkedNode pre = dummyNode;

        for (int i = 0; i < location; i++) {
            pre = pre.next;
        }

        return pre.next.value;
    }

    public boolean contains(int value) {

        LinkedNode curr = dummyNode.next;

        while (curr != null) {

            if (curr.value == value) {
                return true;
            }

            curr = curr.next;

        }
        return false;
    }
    

    public void add(int location, int value) {

        LinkedNode pre = dummyNode;

        for (int i = 0; i < location; i++) {
            pre = pre.next;
        }

        LinkedNode node = new LinkedNode(value);

        node.next = pre.next;
        pre.next = node;

    }

    public void remove(int location) {

        LinkedNode pre = dummyNode;

        for (int i = 0; i < location; i++) {
            pre = pre.next;
        }

        if (pre.next != null) {
            pre.next = pre.next.next;
        }

    }

    public void print() {

        LinkedNode head = dummyNode.next;

        while (head != null) {

            System.out.print(head.value + " ->");

            head = head.next;
        }

        System.out.print("null");
    }
}

class LinkedNode {
    public int value;
    public LinkedNode next;

    public LinkedNode(int value) {
        this.value = value;
    }
}
