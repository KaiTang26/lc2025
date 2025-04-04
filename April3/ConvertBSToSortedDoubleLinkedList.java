package April3;

public class ConvertBSToSortedDoubleLinkedList {

    // left root right

    public Node treeToDoublyList(Node root) {

        if (root == null) {
            return root;
        }

        Result r = helper(root);

        r.head.left = r.tail;
        r.tail.right = r.head;

        return r.head;

    }

    private Result helper(Node node) {

        if (node == null) {
            return null;
        }

        Node head = node;
        Node tail = node;

        if (node.left == null && node.right == null) {
            return new Result(head, tail);
        }

        Result left = helper(node.left);

        if (left != null) {

            left.tail.right = node;
            node.left = left.tail;

            head = left.head;

        }

        Result right = helper(node.right);

        if (right != null) {

            node.right = right.head;
            right.head.left = node;

            tail = right.tail;

        }

        return new Result(head, tail);

    }

}

class Result {

    Node head;
    Node tail;

    public Result(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
