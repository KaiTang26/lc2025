public class BSTIterator {

    Node dummy;
    Node head;

    public BSTIterator(TreeNode root) {
        dummy = new Node(-1);
        head = dummy;
        helper(root);

        head = dummy;

    }

    public int next() {
        int val = head.val;
        head = head.next;
        return val;

    }

    public boolean hasNext() {

        return head != null && head.next != null;

    }

    private void helper(TreeNode treeNode) {

        // inorder: left root right
        if (treeNode != null) {

            helper(treeNode.left);

            Node newNode = new Node(treeNode.val);
            head.next = newNode;
            head = newNode;

            helper(treeNode.right);

        } else {
            return;
        }

    }

}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}
