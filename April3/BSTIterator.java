package April3;

public class BSTIterator {
    TreeNode head = null;

    public BSTIterator(TreeNode root) {

        Result r = helper(root);

        head = r.head;

    }

    public int next() {

        int val = head.val;
        head = head.right;

        return val;

    }

    public boolean hasNext() {

        System.out.println(head.val);

        return head != null && head.right != null;

    }

    private Result helper(TreeNode node) {

        if (node == null) {
            return null;
        }

        TreeNode head = node;
        TreeNode tail = node;

        Result left = helper(node.left);

        if (left != null) {
            head = left.head;
            left.tail.right = node;
        }

        Result right = helper(node.right);

        if (right != null) {
            node.right = right.head;
            tail = right.tail;
        }

        node.left = null;

        return new Result(head, tail);

    }

}

class Result {
    TreeNode head;
    TreeNode tail;

    public Result(TreeNode head, TreeNode tail) {
        this.head = head;
        this.tail = tail;
    }
}
