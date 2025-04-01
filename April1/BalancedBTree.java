package April1;

public class BalancedBTree {

    public boolean isBalanced(TreeNode root) {

        Result r = isBalancedHelper(root);

        return r.isBalanced;

    }

    private Result isBalancedHelper(TreeNode node) {
        if (node == null) {
            return new Result(true, 0);
        }

        Result left = isBalancedHelper(node.left);
        Result right = isBalancedHelper(node.right);

        if (left.isBalanced && right.isBalanced && (Math.abs(left.height - right.height) <= 1)) {
            return new Result(true, Math.max(left.height, right.height) + 1);
        }

        return new Result(false, -1);
    }

}

class Result {

    boolean isBalanced;
    int height;

    public Result(boolean isBalanced, int height) {

        this.isBalanced = isBalanced;
        this.height = height;

    }

}

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
