package April3;

public class FlattenBTtoLinkedList {

    public void flatten(TreeNode root) {

        helper(root);

    }

    private Result helper(TreeNode node) {

        if (node == null) {
            return null;
        }

        TreeNode head = node;
        TreeNode tail = node;

        Result left = helper(node.left);
        Result right = helper(node.right);

        if (left != null) {
            head.right = left.head;
            tail = left.tail;
        }

        if (right != null) {
            tail.right = right.head;
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

// root left right

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}