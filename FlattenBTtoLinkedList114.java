public class FlattenBTtoLinkedList114 {

    public void flatten(TreeNode root) {

        helper(root);

    }

    private Result helper(TreeNode node) {

        if (node == null) {
            return null;
        }

        Result newResult = new Result(null, null);

        // pre order: root, left, right;

        Result left = helper(node.left);
        Result right = helper(node.right);

        if (left == null && right == null) {
            newResult.head = node;
            newResult.tail = node;
        }

        if (left != null && right != null) {

            node.right = left.head;
            left.tail.right = right.head;
            newResult.tail = right.tail;

        }

        if (left != null && right == null) {
            node.right = left.head;
            newResult.tail = left.tail;
        }

        if (right != null && left == null) {
            node.right = right.head;
            newResult.tail = right.tail;
        }

        newResult.head = node;
        node.left = null;

        return newResult;

    }

}

class Result {
    TreeNode head;
    TreeNode tail;

    Result(TreeNode head, TreeNode tail) {
        this.head = head;
        this.tail = tail;

    }
}
